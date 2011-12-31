/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.everydaymetrics.shout_it.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Samuel Pichardo
 */
public class Utils {

    public static String getDateStringFromDate(Date date, String format) {
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat(format);
        return formatoDeFecha.format(date);
    }

    public static Date getDateFromString(String date, String format) {
        Date fecha = null;
        if (date != null && date.length() > 1) {
            try {
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);
                fecha = formatoDelTexto.parse(date);
            } catch (ParseException ex) {
                System.out.println("Error:[getDateFromString] " + ex.getMessage());
            }
        }
        return fecha;
    }

    public static String getDayTextFromDate(Date date) {
        String result;

        DateFormat dateFormatDay = new SimpleDateFormat("EEE", new Locale("ES"));
        result = dateFormatDay.format(date);

        return result;
    }

  
    public static String changeTimeTo24Hour(String time) {
        String result = "";
        int hour = Integer.parseInt(time.substring(0, 2));
        //int min = Integer.parseInt(time.substring(3, 5));
        String amPm = time.substring(6, 8);
        if (amPm.equalsIgnoreCase("PM")) {
            hour += 12;
            result = hour + time.substring(2, 5);
        } else {
//            result = "0"+hour + time.substring(2, 5);
            result = time.substring(0, 5);
        }
        return result;
    }

    public static void main(String[] arm) {
        String hora = changeTimeTo24Hour("02:00 PM");
        System.out.println("Hora:" + hora);
    }
}
