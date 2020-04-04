package com.bank.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Calendar;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtils {

    public static String getFutureDate(int plusDays) {
        var calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, plusDays);
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());
    }
}
