// Problem: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

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
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER i
     * 2. INTEGER j
     * 3. INTEGER k
     */
    public static int getReverse(int num) {
        int revNum = 0;

        while (num > 0) {
            int lastDigit = num % 10;
            revNum = revNum * 10 + lastDigit;

            num /= 10;
        }

        return revNum;
    }

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int count = 0;
        for (int num = i; num <= j; num++) {
            int revNum = getReverse(num);
            int diff = Math.abs(num - revNum);
            boolean isBeautifulDay = (diff % k == 0);
            if (isBeautifulDay == true) {
                count++;
            }
        }
        return count;
    }

}

// Use class name Solution in Hackerrank
public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
