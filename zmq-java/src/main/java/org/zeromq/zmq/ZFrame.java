/*
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.zeromq.zmq;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Working with single message frames.
 * <p>
 * A frame corresponds to one {@code Msg}. When you read a frame from a socket, the hasMore() method
 * indicates if the frame is part of an unfinished multipart message.
 * </p>
 */
public class ZFrame {
  private static final ByteOrder BYTE_ORDER = ByteOrder.BIG_ENDIAN;
  private ByteBuffer byteBuffer;
  private boolean hasMore;

  public ZFrame() {
    this(0);
  }

  /**
   * Creates a new frame of size
   * 
   * @param size the size
   */
  public ZFrame(int size) {
    byteBuffer = ByteBuffer.allocate(size).order(BYTE_ORDER);
  }

  /**
   * Indicates whether the {@code ZFrame} is part of an unfinished multipart message.
   * <p>
   * Set when reading a frame from a socket or explicitly set
   * </p>
   * 
   * @return true if is part of an unfinished multipart message.
   */
  public boolean hasMore() {
    return hasMore;
  }

  public void wrap(byte[] b) {
    wrap(b, 0, b.length);
  }

  public void wrap(byte[] b, int off, int len) {
    byteBuffer = ByteBuffer.wrap(b, off, len).order(BYTE_ORDER);
  }

  public void wrap(ByteBuffer byteBuffer) {
    this.byteBuffer = byteBuffer;
  }

  /**
   * Reads a {@code long} at the given index
   * 
   * @param index The index from which the bytes will be read
   * @return The long value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public long getLong(final int index) {
    return byteBuffer.getLong(index);
  }

  /**
   * Reads an {@code int} at the given index
   * 
   * @param index The index from which the bytes will be read
   * @return The int value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public int getInt(final int index) {
    return byteBuffer.getInt(index);
  }

  /**
   * Reads a {@code short} at the given index
   * 
   * @param index The index from which the bytes will be read
   * @return The short value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public short getShort(final int index) {
    return byteBuffer.getShort(index);
  }

  /**
   * Reads a {@code double} at the given index
   * 
   * @param index The index from which the bytes will be read
   * @return The double value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public double getDouble(final int index) {
    return byteBuffer.getDouble(index);
  }

  /**
   * Reads a {@code float} at the given index
   * 
   * @param index The index from which the bytes will be read
   * @return The float value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public float getFloat(final int index) {
    return byteBuffer.getFloat(index);
  }

  public int getBytes(final int index, byte[] dst) {
    return getBytes(index, dst, 0, dst.length);
  }

  public int getBytes(final int index, byte[] dst, int off, int len) {
    final int lastPosition = byteBuffer.position();
    try {
      byteBuffer.position(index);
      byteBuffer.get(dst, off, len);
      return byteBuffer.position() - lastPosition;
    } finally {
      byteBuffer.position(lastPosition);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((byteBuffer == null) ? 0 : byteBuffer.hashCode());
    result = prime * result + (hasMore ? 1231 : 1237);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ZFrame other = (ZFrame) obj;
    if (byteBuffer == null) {
      if (other.byteBuffer != null) {
        return false;
      }
    } else if (!byteBuffer.equals(other.byteBuffer)) {
      return false;
    }
    if (hasMore != other.hasMore) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ZFrame [byteBuffer=" + byteBuffer + ", hasMore=" + hasMore + "]";
  }
}
