package BOJ_Problem.BOJ_11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int card;
    private static int[] cardPriceArr;

    //    4
//    1 5 6 7
    public static void main(String[] args) throws IOException {
        input();
        logic();
    }

    private static void logic() {


    }

    private static void input() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        card = Integer.parseInt(bufferedReader.readLine());
        cardPriceArr = new int[card];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < card; i++) {
            cardPriceArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

    }
}
