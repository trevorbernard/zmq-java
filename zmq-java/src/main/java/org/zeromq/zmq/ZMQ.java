package org.zeromq.zmq;

import java.nio.charset.Charset;

public class ZMQ {
  /* Version macros for compile-time API version detection */
  public static final int ZMQ_VERSION_MAJOR = 3;
  public static final int ZMQ_VERSION_MINOR = 2;
  public static final int ZMQ_VERSION_PATCH = 5;

  /* Context options */
  public static final int ZMQ_IO_THREADS = 1;
  public static final int ZMQ_MAX_SOCKETS = 2;

  /* Default for new contexts */
  public static final int ZMQ_IO_THREADS_DFLT = 1;
  public static final int ZMQ_MAX_SOCKETS_DFLT = 1024;

  /* Socket types. */
  public static final int ZMQ_PAIR = 0;
  public static final int ZMQ_PUB = 1;
  public static final int ZMQ_SUB = 2;
  public static final int ZMQ_REQ = 3;
  public static final int ZMQ_REP = 4;
  public static final int ZMQ_DEALER = 5;
  public static final int ZMQ_ROUTER = 6;
  public static final int ZMQ_PULL = 7;
  public static final int ZMQ_PUSH = 8;
  public static final int ZMQ_XPUB = 9;
  public static final int ZMQ_XSUB = 10;

  /* Deprecated aliases */
  @Deprecated
  public static final int ZMQ_XREQ = ZMQ_DEALER;
  @Deprecated
  public static final int ZMQ_XREP = ZMQ_ROUTER;

  /* Socket options. */
  public static final int ZMQ_AFFINITY = 4;
  public static final int ZMQ_IDENTITY = 5;
  public static final int ZMQ_SUBSCRIBE = 6;
  public static final int ZMQ_UNSUBSCRIBE = 7;
  public static final int ZMQ_RATE = 8;
  public static final int ZMQ_RECOVERY_IVL = 9;
  public static final int ZMQ_SNDBUF = 11;
  public static final int ZMQ_RCVBUF = 12;
  public static final int ZMQ_RCVMORE = 13;
  public static final int ZMQ_FD = 14;
  public static final int ZMQ_EVENTS = 15;
  public static final int ZMQ_TYPE = 16;
  public static final int ZMQ_LINGER = 17;
  public static final int ZMQ_RECONNECT_IVL = 18;
  public static final int ZMQ_BACKLOG = 19;
  public static final int ZMQ_RECONNECT_IVL_MAX = 21;
  public static final int ZMQ_MAXMSGSIZE = 22;
  public static final int ZMQ_SNDHWM = 23;
  public static final int ZMQ_RCVHWM = 24;
  public static final int ZMQ_MULTICAST_HOPS = 25;
  public static final int ZMQ_RCVTIMEO = 27;
  public static final int ZMQ_SNDTIMEO = 28;
  public static final int ZMQ_IPV4ONLY = 31;
  public static final int ZMQ_LAST_ENDPOINT = 32;
  public static final int ZMQ_ROUTER_MANDATORY = 33;
  public static final int ZMQ_TCP_KEEPALIVE = 34;
  public static final int ZMQ_TCP_KEEPALIVE_CNT = 35;
  public static final int ZMQ_TCP_KEEPALIVE_IDLE = 36;
  public static final int ZMQ_TCP_KEEPALIVE_INTVL = 37;
  public static final int ZMQ_TCP_ACCEPT_FILTER = 38;
  public static final int ZMQ_DELAY_ATTACH_ON_CONNECT = 39;
  public static final int ZMQ_XPUB_VERBOSE = 40;
  // TODO: more constants
  public static final int ZMQ_ROUTER_HANDOVER = 56;

  /* Custom options */
  public static final int ZMQ_ENCODER = 1001;
  public static final int ZMQ_DECODER = 1002;

  /* Message options */
  public static final int ZMQ_MORE = 1;

  /* Send/recv options. */
  public static final int ZMQ_DONTWAIT = 1;
  public static final int ZMQ_SNDMORE = 2;

  /* Deprecated aliases */
  public static final int ZMQ_NOBLOCK = ZMQ_DONTWAIT;
  public static final int ZMQ_FAIL_UNROUTABLE = ZMQ_ROUTER_MANDATORY;
  public static final int ZMQ_ROUTER_BEHAVIOR = ZMQ_ROUTER_MANDATORY;

  /******************************************************************************/
  /* 0MQ socket events and monitoring */
  /******************************************************************************/

  /* Socket transport events (tcp and ipc only) */
  public static final int ZMQ_EVENT_CONNECTED = 1;
  public static final int ZMQ_EVENT_CONNECT_DELAYED = 2;
  public static final int ZMQ_EVENT_CONNECT_RETRIED = 4;

  public static final int ZMQ_EVENT_LISTENING = 8;
  public static final int ZMQ_EVENT_BIND_FAILED = 16;

  public static final int ZMQ_EVENT_ACCEPTED = 32;
  public static final int ZMQ_EVENT_ACCEPT_FAILED = 64;

  public static final int ZMQ_EVENT_CLOSED = 128;
  public static final int ZMQ_EVENT_CLOSE_FAILED = 256;
  public static final int ZMQ_EVENT_DISCONNECTED = 512;
  public static final int ZMQ_EVENT_MONITOR_STOPPED = 1024;

  public static final int ZMQ_EVENT_ALL = ZMQ_EVENT_CONNECTED | ZMQ_EVENT_CONNECT_DELAYED
      | ZMQ_EVENT_CONNECT_RETRIED | ZMQ_EVENT_LISTENING | ZMQ_EVENT_BIND_FAILED
      | ZMQ_EVENT_ACCEPTED | ZMQ_EVENT_ACCEPT_FAILED | ZMQ_EVENT_CLOSED | ZMQ_EVENT_CLOSE_FAILED
      | ZMQ_EVENT_DISCONNECTED | ZMQ_EVENT_MONITOR_STOPPED;

  public static final int ZMQ_POLLIN = 1;
  public static final int ZMQ_POLLOUT = 2;
  public static final int ZMQ_POLLERR = 4;

  public static final int ZMQ_STREAMER = 1;
  public static final int ZMQ_FORWARDER = 2;
  public static final int ZMQ_QUEUE = 3;

  public static final byte[] MESSAGE_SEPARATOR = new byte[0];

  public static final byte[] SUBSCRIPTION_ALL = new byte[0];

  public static final Charset CHARSET = Charset.forName("UTF-8");

  private ZMQ() {}

}
