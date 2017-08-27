/**
 *
 */
package com.HackerRank;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author aberehamwodajie
 *
 *         Jul 8, 2017
 */
public class SockMerchant {

  static int sockMerchant(final int n, final int[] ar) {
    // Complete this function
    final Map<Integer, Integer> map = new ConcurrentHashMap<>();
    for (final int sock : ar) {

      if (map.containsKey(sock)) {
        Integer count = map.get(sock);
        count++;
        map.put(sock, count);
      } else {
        map.put(sock, 1);
      }
    }
    System.out.println(map);
    int result = 0;
    for (final Entry<Integer, Integer> entry : map.entrySet()) {
      result += entry.getValue() / 2;
    }

    return result;
  }

  public static void main(final String[] args) {

    final int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    final int result = sockMerchant(9, ar);
    System.out.println(result);
  }

}
