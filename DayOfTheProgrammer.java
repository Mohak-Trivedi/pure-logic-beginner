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

    public static String dayOfProgrammer(int year) {
        // Write your code here
        String dayOfProgrammer = "";
        String ddmm = "";
        if (year < 1918) {
            // Julian Calender
            // Programmer Day = (if leap year: 366 days) -> 12th September (Programmer's Day
            // = 256th day: 244 till Sept + 12 from Sept)
            // Programmer Day = +1 day (non-leap year: 365 days: 1 day less in Feb, so +1
            // day to include from Sept) -> 13th September
            ddmm = (year % 4 == 0) ? "12.09." : "13.09.";
        } else if (year > 1918) {
            // Gregorian Calender
            // Same as Julian, but Leap Year considered in different manner
            ddmm = ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) ? "12.09." : "13.09.";
        } else {
            // 1918: Shifting from Julian to Gregorian, and is Non-Leap
            // Lost 13 days from Feb, so +13 in Sept Non-Leap. Programmer Day: 26th
            // September
            ddmm = "26.09.";
        }
        dayOfProgrammer = ddmm + year;
        return dayOfProgrammer;
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
