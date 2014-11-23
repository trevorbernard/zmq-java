/*
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of
 * the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.zeromq.zmq;

class Utils {
  private Utils() {}

  static final char[] HEX_CHARACTERS = "0123456789ABCDEF".toCharArray();

  static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int i = 0; i < bytes.length; i++) {
      int v = bytes[i] & 0xFF;
      hexChars[i * 2] = HEX_CHARACTERS[v >>> 4];
      hexChars[i * 2 + 1] = HEX_CHARACTERS[v & 0x0F];
    }
    return new String(hexChars);
  }
}
