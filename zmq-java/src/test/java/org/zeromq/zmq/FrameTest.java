package org.zeromq.zmq;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FrameTest {
  @Test
  public void putLongAndGetLongTest() {
    ZFrame f1 = new ZFrame(8);
    f1.writeLong(0, 1L);
    assertEquals(1L, f1.getLong(0));
  }

  @Test
  public void putIntAndGetIntTest() {
    ZFrame f1 = new ZFrame(4);
    f1.writeInt(0, 1);
    assertEquals(1, f1.getInt(0));
  }

  @Test
  public void putShortAndGetShortTest() {
    ZFrame f1 = new ZFrame(2);
    f1.writeShort(0, (short) 1);
    assertEquals(1, f1.getShort(0));
  }

  @Test
  public void putDoubleAndGetDoubleTest() {
    ZFrame f1 = new ZFrame(8);
    f1.writeDouble(0, 1.1);
    assertEquals(Double.doubleToLongBits(1.1), Double.doubleToLongBits(f1.getDouble(0)));
  }

  @Test
  public void putFloatAndGetFloatTest() {
    ZFrame f1 = new ZFrame(4);
    f1.writeFloat(0, (float) 1.1);
    assertEquals(Float.floatToIntBits((float) 1.1), Float.floatToIntBits((float) f1.getFloat(0)));
  }

  @Test
  public void putBytesAndGetBytesTest() {
    ZFrame f1 = new ZFrame(5);
    byte[] expected = new byte[] {'a', 'b', 'c', 'd', 'e'};
    f1.writeBytes(0, expected);
    byte[] actual = new byte[5];
    f1.getBytes(0, actual);
    assertTrue(Arrays.equals(expected, actual));
  }
}
