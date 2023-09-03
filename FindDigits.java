// Problem: https://www.hackerrank.com/challenges/find-digits/problem

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
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    // Approach: Using math logic instead of String: T.C.: O(n), S.C.: O(1)
    public static int findDigits(int n) {
        // Write your code here
        int numOfDiv = 0;

        int temp = n;
        while (temp > 0) {
            int currDigit = temp % 10;
            if ((currDigit != 0) && (n % currDigit == 0)) { // 1st condition is to avoid DivideByZero Error
                numOfDiv++;
            }

            temp /= 10;
        }

        return numOfDiv;
    }

    // Approach: Using String instead of pure math: T.C.: O(n), S.C.: O(n)
    // public static int findDigits(int n) {
    // String num = "" + n;
    // int numOfDiv = 0;
    // for (int i = 0; i < num.length(); i++) {
    // int currDigit = num.charAt(i) - '0';
    // if ((currDigit != 0) && (n % currDigit == 0)) {
    // numOfDiv++;
    // }
    // }
    // return numOfDiv;
    // }
}

// Use class name Solution in HackerRank
public class FindDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
