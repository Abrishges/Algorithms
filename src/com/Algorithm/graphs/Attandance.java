/**
 *
 */
package com.Algorithm.graphs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author aberehamwodajie
 *
 *         Jan 26, 2017
 */
public class Attandance {


  private static String format = "dd/MM/yyyy";
  private static String currenttime = "01/25/2017";

  public static void main(final String[] args) {

    currenttime = "01/25/2017";
    final SimpleDateFormat sdf = new SimpleDateFormat(format);
    final Timetest de = new Timetest();
    final Date date = de.formatDate(currenttime, sdf);

    final long epoch = date.getTime();
    System.out.println(epoch);

    // Scanner in = new Scanner(System.in);

  }

  public Date formatDate(final String dateStr, final SimpleDateFormat sdf) {
    Date date = null;
    try {
      date = sdf.parse(dateStr);
    } catch (final ParseException e) {
      e.printStackTrace();
    }
    return date;
  }

}
