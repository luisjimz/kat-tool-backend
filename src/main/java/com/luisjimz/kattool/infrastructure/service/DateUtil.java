package com.luisjimz.kattool.infrastructure.service;

public class DateUtil {
    public static int[] getYearAndMonth(String monthYearSlug) {
        String[] parts = monthYearSlug.split("-");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);
        return new int[] { year, month };
    }
}

