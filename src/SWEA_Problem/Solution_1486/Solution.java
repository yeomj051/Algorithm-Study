package SWEA_Problem.Solution_1486;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int people;
    private static int height;
    private static int[] peopleArr;
//    private static int total;
    private static int minTotal;
    private static boolean[] visited;


    //    1
//            5 16
//            1 3 3 5 6
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input(1486).txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            //입력
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            people = Integer.parseInt(stringTokenizer.nextToken());
            height = Integer.parseInt((stringTokenizer.nextToken()));

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            peopleArr = new int[people];
            for (int i = 0; i < people; i++) {
                peopleArr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            //부분 조합
//            total = 0;
            minTotal = Integer.MAX_VALUE;
            visited = new boolean[people];
            subset(0,0);

            StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(minTotal - height);
            System.out.println(stringBuilder);
        }
    }

    private static void subset(int count, int total) {
        if(count == people){
            if(total >= height && total < minTotal) minTotal = total;
            return;
        }
        subset(count+1, total+peopleArr[count]);
        subset(count+1, total);

    }


}
