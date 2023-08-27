
// Problem: https://www.hackerrank.com/challenges/kangaroo/problem
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
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. INTEGER x1
     * 2. INTEGER v1
     * 3. INTEGER x2
     * 4. INTEGER v2
     */

    // Approach 1: Fails for 6/30 test cases.
    // public static String kangaroo(int x1, int v1, int x2, int v2) {
    // // Write your code here
    // if (x2 > x1 && v2 > v1) {
    // return "NO";
    // }
    // if (x1 > x2 && v1 > v2) {
    // return "NO";
    // }
    // while (x1 != x2 && x1 < Integer.MAX_VALUE && x2 < Integer.MAX_VALUE) {
    // x1 += v1;
    // x2 += v2;
    // }
    // if (x1 == x2) {
    // return "YES";
    // } else {
    // return "NO";
    // }
    // }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x2 > x1 && v2 > v1) {
            return "NO";
        }
        if (x1 > x2 && v1 > v2) {
            return "NO";
        }

        int gap = Math.abs(x2 - x1);
        while (x1 != x2) {
            x1 += v1;
            x2 += v2;
            int newGap = Math.abs(x2 - x1);
            if (newGap >= gap) { // gap b/w Kangaroos must keep strictly decreasing if they are supposed to meet
                return "NO";
            }
        }
        return "YES";
    }
}

// Use class name Solution in HackerRank
public class NumberLineJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x1 = Integer.parseInt(firstMultipleInput[0]);

        int v1 = Integer.parseInt(firstMultipleInput[1]);

        int x2 = Integer.parseInt(firstMultipleInput[2]);

        int v2 = Integer.parseInt(firstMultipleInput[3]);

        String result = Result.kangaroo(x1, v1, x2, v2);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
