/**
 *
 */
package com.Algorithm.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author aberehamwodajie
 *
 *         Dec 19, 2016
 */
public class game {

  /**
   * @param args
   * @throws ParseException
   */

  private static final String PATTERN_ZONE_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

  public static void main(final String[] args) throws ParseException {
    // TODO Auto-generated method stub

    final String date = "2016-02-03 11:39:58.919-05:00";
    // final String date = "2018-06-12 20:00:00.000-05:00";
    // final String date = "2017-09-15 17:51:42.000-05:00";
    System.out.println("date: " + date);
    // final game game = new game();
    final String newDate = date.replaceAll("\\.\\d+$", "").replace(" ", "T");

    System.out.println("newDate: " + newDate);

    // Joda time format ex 2001-07-04T12:08:56.235-07:00
    System.out.println("conversting to date time: ");
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSXXX");
    final ZonedDateTime dateTime = ZonedDateTime.parse(date, dtf);
    final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    System.out.println("date time : " + dateTime);

    final ZonedDateTime utcDate = dateTime.withZoneSameInstant(ZoneOffset.UTC);

    System.out.println("utc date: " + utcDate.format(dtf2));

  }

  public static LocalDateTime getLocalDateTime(final String date) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSXXX");

    final LocalDateTime formatDateTime = LocalDateTime.parse(date, formatter);
    System.out.println(formatDateTime);
    return formatDateTime;
  }

  public void dateTime3(final String input) throws ParseException {

    final String newDate = this.convertSybaseDatetimeToIsoLocal(input);


    // Joda time format ex 2001-07-04T12:08:56.235-07:00
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    final ZonedDateTime dateTime = ZonedDateTime.parse(newDate, dtf);

    System.out.println("date with xxx.. " + dateTime);

    // System.out.println("ZonedDatetime Data time: " + dateTime);
    // final ZoneOffset ourOfficset = dateTime.getOffset();

    // System.out.println("offset: " + ourOfficset);

    final StringBuilder sb = new StringBuilder(newDate);
    final String str = sb.deleteCharAt(26).toString();
    System.out.println("With out colon: " + str);


    final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    final ZonedDateTime dateTimeWithoutColon = ZonedDateTime.parse(str, fmt);

    System.out.println("dateTimeWithoutColon: " + dateTimeWithoutColon);

    final DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


    final DateTimeFormatter formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    final String formattedDate = formatter.format(dateTime);
    // System.out.println("formattedDate: " + formattedDate);


    // final ZonedDateTime dateTime2 = ZonedDateTime.parse(str, fmt);
    // dateFormater.format(newDate);
    // final Date dateFormated = dateFormater.parse(newDate);

    // System.out.println("utc.." + dateTime2);

  }



  public String convertSybaseDatetimeToIsoLocal(final String date) {
    return date.replaceAll("\\.\\d+$", "").replace(" ", "T");
  }

  public LocalDateTime parseFromSybaseDatetime(final String date) {
    final String newDate = this.convertSybaseDatetimeToIsoLocal(date);

    return LocalDateTime.parse(newDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  public ZonedDateTime dateTime(final String input) {
    final String input2 = removeLastCharOptional(input);
    System.out.println("input2: " + input2);
    final String newDate = this.convertSybaseDatetimeToIsoLocal(input2);
    final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
    final ZonedDateTime utc = ZonedDateTime.parse(newDate, fmt).withZoneSameInstant(ZoneOffset.UTC);
    return utc;
  }



  public static String removeLastCharOptional(final String s) {
    return Optional
        .ofNullable(s)
        .filter(str -> str.length() != 0)
        .map(str -> str.substring(0, str.length() - 6))
        .orElse(s);
  }


  public String getUtc(final String date) {
    final String newDate = this.convertSybaseDatetimeToIsoLocal(date);
    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(PATTERN_ZONE_DATE_TIME);
    final String utcDateTime =
        ZonedDateTime.parse(newDate, dateTimeFormatter).withZoneSameInstant(ZoneOffset.UTC).format(dateTimeFormatter);
    return utcDateTime;
  }
}
