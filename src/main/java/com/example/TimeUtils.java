package com.example;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtils {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss z");

    public static String getTime(String zoneId) {
        return ZonedDateTime.now(ZoneId.of(zoneId)).format(FORMATTER);
    }
}