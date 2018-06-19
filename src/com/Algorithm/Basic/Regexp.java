/**
 *
 */
package com.Algorithm.Basic;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author aberehamwodajie
 *
 *         Jun 4, 2017
 */
public class Regexp {

  public static void main(final String arg[]) {
    System.out.println("hello");

    final Pattern pattern = Pattern.compile("an.*");
    final List<String> list =
        Stream.of("crane, drain, refrain").filter(pattern.asPredicate()).collect(Collectors.toList());

    System.out.println("list of words that much: " + list);

  }
}
