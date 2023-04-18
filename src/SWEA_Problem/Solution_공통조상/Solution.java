package SWEA_Problem.Solution_공통조상;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input_공통조상.txt"));

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer stringTokenizer= new StringTokenizer(bufferedReader.readLine());
            int V = Integer.parseInt(stringTokenizer.nextToken());
            int E = Integer.parseInt(stringTokenizer.nextToken());
            StringBuilder stringBuilder = new StringBuilder("#").append(" ");

        }
    }
}
