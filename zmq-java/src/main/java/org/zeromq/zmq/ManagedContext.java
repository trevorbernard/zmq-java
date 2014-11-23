/*
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.zeromq.zmq;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import zmq.Ctx;
import zmq.SocketBase;
import zmq.ZMQ;

// No class access modifier is used so ManagedContext is only visible to itself and it's namespace.
// This is to avoid people trying to initialize a Context
class ManagedContext {
  private static final int DEFAULT_IO_THREADS = 1;

  private final Lock lock;
  private final Ctx ctx;
  private final Set<SocketBase> sockets;

  private ManagedContext() {
    this.ctx = zmq.ZMQ.zmqInit(DEFAULT_IO_THREADS);
    this.lock = new ReentrantLock();
    this.sockets = new HashSet<SocketBase>();
  }

  SocketBase createSocket(int type) {
    final SocketBase base = ctx.createSocket(type);
    lock.lock();
    try {
      sockets.add(base);
    } finally {
      lock.unlock();
    }
    return base;
  }

  void destroy(SocketBase socketBase) {
    socketBase.setSocketOpt(ZMQ.ZMQ_LINGER, 0);
    socketBase.close();
    lock.lock();
    try {
      sockets.remove(socketBase);
    } finally {
      lock.unlock();
    }
  }

  // Lazy singleton pattern to avoid double lock checking
  private static class ContextHolder {
    private static final ManagedContext INSTANCE = new ManagedContext();
  }

  static ManagedContext getInstance() {
    return ContextHolder.INSTANCE;
  }

  /*
   * This should only be called when SIGINT is received
   */
  private void close() {
    lock.lock();
    try {
      for (SocketBase s : sockets) {
        try {
          s.setSocketOpt(ZMQ.ZMQ_LINGER, 0);
          s.close();
        } catch (Exception ignore) {
        }
      }
      sockets.clear();
    } finally {
      lock.unlock();
    }
  }

  static {
    // Release ManagedSocket resources when catching SIGINT
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        getInstance().close();
      }
    });
  }
}
