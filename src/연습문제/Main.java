package 연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());

        int[] dp = new int[size+1];
        dp[1] = 9;
        dp[2] = 17;
        for (int i = 3; i <= size; i++) {
            dp[i] = dp[i-1] + (11-i) + (10-i);
        }

        System.out.println(dp[size] % 1000000000);
    }
}
