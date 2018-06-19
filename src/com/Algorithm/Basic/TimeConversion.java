package com.Algorithm.Basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import java.util.StringJoiner;

public class TimeConversion {
  public static void main(final String args[]) {

    // what is ZonedDateTime
    // what is LocalDateTime
    // UTC
    // GMT
    // UTC comes with 24 hours with 00 offset
    final Long milliseconds = 1505515902676L;
    final Instant instant = Instant.ofEpochSecond(milliseconds / 1000);
    final ZonedDateTime utc = Instant.ofEpochSecond(milliseconds / 1000).atZone(ZoneOffset.UTC);
    System.out.println("instant : " + instant);
    System.out.println("instant : " + utc);

    // shows the offset, Zone will be passed from some where
    final ZoneId zoneId = ZoneId.of("America/New_York");
    final ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
    System.out.println("zoneDateTime: " + zdt);
    System.out.println("zone: " + zdt);
    System.out.println("hour: " + zdt.getHour());
    System.out.println("mint: " + zdt.getMinute());
    System.out.println("second: " + zdt.getSecond());


    final Integer mint = zdt.getMinute();
    final Integer second = zdt.getSecond();
    final StringJoiner sj = new StringJoiner(":");
    sj.add(mint.toString());
    sj.add(second.toString());

    // It keep it as utc but help us to get hh, mm, ss etc
    final ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);
    System.out.println("zoneDateTime2: " + zdt2);
    System.out.println("zone2: " + zdt2);
    System.out.println("hour2: " + zdt2.getHour());
    System.out.println("mint2: " + zdt2.getMinute());
    System.out.println("second2: " + zdt2.getSecond());

    System.out.println("mint second: " + sj);
    // doesn't show the offset
    final LocalDateTime here = zdt.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    System.out.println("ldt: " + here);

    // converting to eastern in am/pm format, note that simpleDateFormater is not thread safe
    final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.US);
    final String output = zdt.format(formatter);
    System.out.println("local: " + output);


    final String eventDateStr = "2017-09-15";
    final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(ZoneOffset.UTC);
    final Long epochEventDate;
    try {
      final Date eventDate = formatter1.parse(eventDateStr);
      System.out.println(eventDate.toInstant().toEpochMilli());
      final ZonedDateTime dateTime = ZonedDateTime.parse(eventDateStr, dtf);
      final Long epochEventDate2 = dateTime.toInstant().toEpochMilli();
      System.out.println(epochEventDate2);

      final LocalDateTime lDateTime = LocalDateTime.ofInstant(eventDate.toInstant(), ZoneOffset.UTC);
      final ZonedDateTime zDateTime = ZonedDateTime.of(lDateTime, ZoneOffset.UTC);
      epochEventDate = (zDateTime.toInstant().toEpochMilli());
      System.out.println(epochEventDate);
    } catch (final ParseException ex) {
    }
    // 1505448000000
  }
}
