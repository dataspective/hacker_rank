import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        final int HOURGLASS_LENGTH = 3;
        final int HOURGLASS_HEIGHT = 3;
        int max, sum;

        // setup initial max value as 1st element
        max = arr[0][0];
        max += arr[0][1];
        max += arr[0][2];
        max += arr[1][1];
        max += arr[2][0];
        max += arr[2][1];
        max += arr[2][2];


        // select the hourglass
        for(int i = 0; i <= HOURGLASS_HEIGHT; i++){ // rows
            for(int j = 0; j <= HOURGLASS_LENGTH; j++){ // columns
                sum = arr[i][j]; // top hourglass
                sum += arr[i][j+1];
                sum += arr[i][j+2];
                sum += arr[i+1][j+1]; // middle hourglass
                sum += arr[i+2][j]; // bottom hourglass
                sum += arr[i+2][j+1];
                sum += arr[i+2][j+2];
                if(sum > max) // check for max
                    max = sum;
            }
        }
        return max; // return max
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
