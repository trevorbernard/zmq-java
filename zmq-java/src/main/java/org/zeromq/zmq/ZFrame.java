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
 * A frame corresponds to one {@code zmq.Msg}. When you read a frame from a socket, the hasMore()
 * method indicates if the frame is part of an unfinished multipart message.
 * </p>
 */
public class ZFrame {
  private static final ByteOrder BYTE_ORDER = ByteOrder.BIG_ENDIAN;
  private boolean hasMore;

  ByteBuffer byteBuffer; // private-package

  /**
   * Creates a new empty frame
   */
  public ZFrame() {
    this(0);
  }

  /**
   * Creates a new frame of size
   * 
   * @param size the size
   */
  public ZFrame(final int size) {
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

  /**
   * Wraps the byte array into a {@code ZFrame}.
   * 
   * @param b the array that will back the new frame
   */
  public void wrap(byte[] b) {
    wrap(b, 0, b.length);
  }

  /**
   * Wraps the byte array into a {@code ZFrame}.
   * 
   * @param b the array that will back the new frame
   * @param off The offset of the subarray to be used; must be non-negative and no larger than
   *        array.length. The new buffer's position will be set to this value.
   * @param len The length of the subarray to be used; must be non-negative and no larger than
   *        array.length - offset. The new buffer's limit will be set to offset + length.
   */
  public void wrap(byte[] b, int off, int len) {
    byteBuffer = ByteBuffer.wrap(b, off, len).order(BYTE_ORDER);
  }

  /**
   * Wraps the buffer into a {@code ZFrame}.
   * 
   * @param byteBuffer the buffer that will back the new frame
   */
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
   * Writes a {@code long} value at the given index
   * 
   * @param index The index from which the {@code long} will be read
   * @param value The long value to write
   * @return This frame
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public ZFrame writeLong(final int index, final long value) {
    byteBuffer.putLong(index, value);
    return this;
  }

  /**
   * Reads an {@code int} at the given index
   * 
   * @param index The index from which the {@code int} will be read
   * @return The int value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public int getInt(final int index) {
    return byteBuffer.getInt(index);
  }

  /**
   * Writes a {@code int} value at the given index
   * 
   * @param index The index from which the bytes will be read
   * @param value The int value to write
   * @return This frame
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public ZFrame writeInt(final int index, final int value) {
    byteBuffer.putInt(index, value);
    return this;
  }

  /**
   * Reads a {@code short} at the given index
   * 
   * @param index The index from which the {@code short} will be read
   * @return The short value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public short getShort(final int index) {
    return byteBuffer.getShort(index);
  }

  /**
   * Writes a {@code short} value at the given index
   * 
   * @param index The index from which the bytes will be read
   * @param value The short value to write
   * @return This frame
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public ZFrame writeShort(final int index, final short value) {
    byteBuffer.putShort(index, value);
    return this;
  }

  /**
   * Reads a {@code double} at the given index
   * 
   * @param index The index from which the {@code double} will be read
   * @return The double value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public double getDouble(final int index) {
    return byteBuffer.getDouble(index);
  }

  /**
   * Writes a {@code double} value at the given index
   * 
   * @param index The index from which {@code double} will be written
   * @param value The double value to write
   * @return This frame
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public ZFrame writeDouble(final int index, final double value) {
    byteBuffer.putDouble(index, value);
    return this;
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

  /**
   * Writes a {@code float} value at the given index
   * 
   * @param index The index from which {@code float} will be written
   * @param value The float value to write
   * @return This frame
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public ZFrame writeFloat(final int index, final float value) {
    byteBuffer.putFloat(index, value);
    return this;
  }

  /**
   * Reads a {@code byte} at the given index
   * 
   * @param index The index from which the bytes will be read
   * @return The byte value at the given index
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public byte getByte(final int index) {
    return byteBuffer.get(index);
  }

  /**
   * Writes a {@code byte} value at the given index
   * 
   * @param index The index from which {@code byte} will be written
   * @param value The byte value to write
   * @return This frame
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public ZFrame writeByte(final int index, byte value) {
    byteBuffer.put(index, value);
    return this;
  }

  /**
   * Reads a series of bytes at the given index
   * 
   * @param index The index from which the bytes will be read
   * @return The number of bytes read
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public int getBytes(final int index, byte[] dst) {
    return getBytes(index, dst, 0, dst.length);
  }

  /**
   * Writes a series of bytes at the given index
   * 
   * @param index The index from which the bytes will be written
   * @param src the array that will be written to the frame
   * @return This frame
   */
  public ZFrame writeBytes(final int index, byte[] src) {
    return writeBytes(index, src, 0, src.length);
  }

  /**
   * Writes a series of bytes at the given index
   * 
   * @param index The index from which the bytes will be written
   * @param src the array that will be written to the frame
   * @param off The offset of the subarray to be used; must be non-negative and no larger than
   *        array.length.
   * @param len The length of the subarray to be used; must be non-negative and no larger than
   *        array.length - offset.
   * @return This frame
   */
  public ZFrame writeBytes(final int index, byte[] src, int off, int len) {
    final int lastPosition = byteBuffer.position();
    try {
      byteBuffer.position(index);
      byteBuffer.put(src, off, len);
    } finally {
      byteBuffer.position(lastPosition);
    }
    return this;
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
   * Reads a UTF8 String at the given index, of a given size
   * 
   * @param index The index from which the String will be read
   * @param length The number of bytes to read
   * @return The resulting UTF8 String
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   */
  public String getStringUtf8(final int index, final int length) {
    byte[] dst = new byte[length];
    getBytes(index, dst, 0, length);
    return new String(dst, ZSocket.UTF8);
  }


  /**
   * Writes a UTF8 {@code String} at the given index
   * 
   * @param index The index from which {@code String} will be written
   * @param str The UTF8 String to write
   * @throws IndexOutOfBoundsException If <tt>index</tt> is negative or not smaller than the
   *         buffer's limit, minus seven
   * @return This frame
   */
  public ZFrame writeStringUtf8(final int index, String str) {
    byte[] b = str.getBytes(ZSocket.UTF8);
    writeBytes(index, b);
    return this;
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

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "ZFrame [byteBuffer=" + byteBuffer + ", hasMore=" + hasMore + "]";
  }
}
