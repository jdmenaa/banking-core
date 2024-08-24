package org.banking.account.test.infraestructure.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class UtilDates {

    final private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static LocalDateTime converterStringToLocalDateTimeBegin(String date) {
        return LocalDateTime.parse(date + " 00:00:00", dtf);
    }

    public static LocalDateTime converterStringToLocalDateTimeEnd(String date) {
        return LocalDateTime.parse(date + " 23:59:59", dtf);
    }

    public static Date getNowTodayDate() {
        Instant now = Instant.now();
        ZonedDateTime zoneGuayaquil = now.atZone(ZoneId.of(Constants.ZONA_LOCAL));
        return Date.from(zoneGuayaquil.toInstant());
    }

    public static LocalDateTime converterLocalDateToLocalDateTimeBegin(LocalDate date) {
        return date.atStartOfDay();
    }

    public static LocalDateTime converterLocalDateToLocalDateTimeEnd(LocalDate date) {
        return date.atTime(23,59, 59);
    }

    public static LocalDateTime getCurrentDate() {
        return LocalDateTime.now(ZoneId.of(Constants.ZONA_LOCAL));
    }


}
