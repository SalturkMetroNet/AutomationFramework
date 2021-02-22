package com.metronet.mis.utilities.common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeUtilities
{

    /**
     * This method returns current date as a string.
     * Provide a format as a parameter
     * <p>
     * MM - to specify month like: 01, 02, 03,
     * MMM - to specify month like: Jan, Feb, Mar
     * <p>
     * dd - to specify day, like 01, 02, 03
     * <p>
     * yyyy - to specify year like: 2010, 2020
     *
     * @param format for example: MMM dd, yyyy = Mar 29, 2020
     * @return current date as a string
     * <p>
     * https://www.journaldev.com/17899/java-simpledateformat-java-date-format
     */
    public static String getCurrentDate(String format)
    {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * This method returns difference between end and start time
     *
     * @param start  time
     * @param end    time
     * @param format like h:m a --> 5:15 AM, 8:07 PM
     * @return difference between end time and start time as a long
     */
    public static long getTimeDifference(String start, String end, String format)
    {
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(startTime, endTime);
    }

    public static String formatDuration(Duration duration)
    {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d:%02d:%02d",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}
