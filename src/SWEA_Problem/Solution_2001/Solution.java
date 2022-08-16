package SWEA_Problem.Solution_2001;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input(2001).txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int[][] flyBox = new int[N][N];
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < N; j++) {
                    flyBox[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            for (int i = 0; i < N-M+1; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    int flys = 0;
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            flys += flyBox[i+k][j+l];
                        }
                    }
                    if(flys > max) max = flys;
                }
            }

            StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(max);
            System.out.println(stringBuilder);
        }

    }
}
