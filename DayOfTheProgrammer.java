// Problem: https://www.hackerrank.com/challenges/day-of-the-programmer/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    // Approach: Involves manual calculation
    // public static String dayOfProgrammer(int year) {
    // // Write your code here
    // String dayOfProgrammer = "";
    // String ddmm = "";
    // if (year < 1918) {
    // // Julian Calender
    // // Programmer Day = (if leap year: 366 days) -> 12th September (Programmer's
    // Day
    // // = 256th day: 244 till Sept + 12 from Sept)
    // // Programmer Day = +1 day (non-leap year: 365 days: 1 day less in Feb, so +1
    // // day to include from Sept) -> 13th September
    // ddmm = (year % 4 == 0) ? "12.09." : "13.09.";
    // } else if (year > 1918) {
    // // Gregorian Calender
    // // Same as Julian, but Leap Year considered in different manner
    // ddmm = ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) ?
    // "12.09." : "13.09.";
    // } else {
    // // 1918: Shifting from Julian to Gregorian, and is Non-Leap
    // // Lost 13 days from Feb, so +13 in Sept Non-Leap. Programmer Day: 26th
    // // September
    // ddmm = "26.09.";
    // }
    // dayOfProgrammer = ddmm + year;
    // return dayOfProgrammer;
    // }

    // Alternate Approach: Less manual calculation
    public static String dayOfProgrammer(int year) {
        int[] daysOfMonths = new int[] { 31, 28, 31, 30, 31, 30, 31, 31 }; // Non-leap : Jan-Aug : Not including 30 of
                                                                           // Sept as it will cross sum 256 i.e.
                                                                           // Programmer Day
        int programmerDay = 256;
        int daysTillSept = 0, daysOfSept = 0;

        if (year < 1918) {
            // Julian Calender
            if (year % 4 == 0) {
                daysOfMonths[1] = 29; // 29 days in Feb in leap year
            } // else it will be as it is i.e. 28 days
        } else if (year > 1918) {
            // Gregorian Calender
            // Same as Julian, but Leap Year considered in different manner
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                daysOfMonths[1] = 29;
            }
        } else {
            // 1918: Shifting from Julian to Gregorian, and is Non-Leap
            // Lost 13 days from Feb, so +13 in Sept Non-Leap. Programmer Day: 26th
            // September
            return "26.09." + year;
        }
        for (int days : daysOfMonths) {
            daysTillSept += days;
        }
        daysOfSept = programmerDay - daysTillSept; // remaining days will be included from Sept
        return Integer.toString(daysOfSept) + ".09." + Integer.toString(year);
    }

}

// Use class name Solution in HackerRank
public class DayOfTheProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
