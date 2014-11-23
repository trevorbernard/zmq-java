/*
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.zeromq.zmq;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Message implements Collection<Frame> {
  private final Deque<Frame> frames;

  public Message() {
    frames = new ArrayDeque<Frame>();
  }

  /**
   * Constructs a ZMessge containing the elements of the specified collection, in the order they are
   * returned by the collection's iterator. (The first element returned by the collection's iterator
   * becomes the first element, or <i>front</i> of the ZMessage.)
   * 
   * @param c the collection whose elements are to be placed into the {@code ZMessage}
   */
  public Message(Collection<? extends Frame> c) {
    frames = new ArrayDeque<Frame>(c);
  }

  public Frame pop() {
    try {
      return frames.pop();
    } catch (NoSuchElementException e) {
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterator<Frame> iterator() {
    return frames.iterator();
  }

  @Override
  public int size() {
    return frames.size();
  }

  @Override
  public boolean isEmpty() {
    return frames.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return frames.contains(o);
  }

  @Override
  public Object[] toArray() {
    return null;
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return frames.toArray(a);
  }

  @Override
  public boolean add(Frame e) {
    return frames.add(e);
  }

  @Override
  public boolean remove(Object o) {
    return frames.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return frames.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends Frame> c) {
    return frames.addAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return frames.removeAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return frames.retainAll(c);
  }

  @Override
  public void clear() {
    frames.clear();
  }

  public void send(Socket socket) {
    for (Frame frame : this) {
      // frame.send(socket);
    }
  }
}
