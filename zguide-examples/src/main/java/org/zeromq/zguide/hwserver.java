package org.zeromq.zguide;

import static org.zeromq.zmq.ZMQ.ZMQ_REP;

import org.zeromq.zmq.ZSocket;

public class hwserver {
  public static void main(String[] args) throws Exception {
    try (final ZSocket responder = new ZSocket(ZMQ_REP)) {
      boolean rc = responder.bind("tcp://*:5555");
      assert (rc);
      while (true) {
        byte[] buffer = responder.receive();
        System.out.println("Received Hello");
        Thread.sleep(1000);
        responder.send("World".getBytes());
      }
    }
  }
}
