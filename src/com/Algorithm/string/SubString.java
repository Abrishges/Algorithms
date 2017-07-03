/**
 *
 */
package com.Algorithm.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// import org.apache.commons.lang3.StringUtils;

/**
 * @author aberehamwodajie
 *
 *         Jun 6, 2017
 *
 *         Occurrences of substring in a string
 */
public class SubString {

  public static void main(final String args[]) {

    // First approach
    final String str = "helloslkhellodjladfjhello";
    final String findStr = "hello";
    int lastIndex = 0;
    int count = 0;

    while (lastIndex != -1) {

      lastIndex = str.indexOf(findStr, lastIndex);

      if (lastIndex != -1) {
        count++;
        lastIndex += findStr.length();
      }
    }
    System.out.println(count);


    // Second Approach
    final Pattern p = Pattern.compile("hello");
    final Matcher m = p.matcher(str);
    int count2 = 0;
    while (m.find()) {
      count2 += 1;
    }
    System.out.println(count2);

    // Third Approach
    // System.out.println(StringUtils.countMatches(str, findStr));


  }
}
