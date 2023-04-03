package BOJ_Problem.BOJ_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int M;
    private static int N;
    private static int[] result;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        result = new int[M];
        logic(0, 1);

        System.out.print(stringBuilder);
    }

    private static void logic(int count, int start) {
        if(count == M){
            for (int i = 0; i < M; i++) {
                stringBuilder.append(result[i]).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            result[count] = i;
            logic(count+1, i);
        }
    }
}
