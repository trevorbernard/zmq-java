package org.zeromq.zguide;

import static org.zeromq.zmq.ZMQ.ZMQ_REQ;

import org.zeromq.zmq.Socket;

public class hwclient {
  public static void main(String[] args) throws Exception {
    try (final Socket requester = new Socket(ZMQ_REQ)) {
      requester.connect("tcp://127.0.0.1:5555");
      for (int i = 0; i < 10; i++) {
        System.out.printf("Sending Hello %d…\n", i);
        requester.send("Hello".getBytes());
        byte[] buffer = requester.receive();
        System.out.printf("Received World %d\n", i);
      }
    }
  }
}
