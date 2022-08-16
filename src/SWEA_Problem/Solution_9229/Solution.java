package SWEA_Problem.Solution_9229;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/sample_input(9229).txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //test case 입력
        int T = Integer.parseInt(bufferedReader.readLine());
        //test case만큼 반복
        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            //과자 봉지 수
            int snackCount = Integer.parseInt(stringTokenizer.nextToken());
            //과자 봉지 배열
            int[] snackArr = new int[snackCount+1];
            //최대로 들 수 있는 무게를 과자 봉지 배열 맨 앞에 입력
            snackArr[0] = Integer.parseInt(stringTokenizer.nextToken());
            //두 봉지 조합의 최대값(조건에 만족하는 조합이 없을 시 -1 출력)
            int max = -1;

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            //과자 봉지 배열 입력
            for (int i = 1; i <= snackCount; i++) {
                snackArr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            //과자봉지 길이만큼 반복
            for (int i = 1; i < snackArr.length; i++) {
                int sum = snackArr[i];
                //i번째 봉지에 이후의 봉지 들을 반복문을 통해 더하고 조건에 만족하는지 확인
                for (int j = i+1; j < snackArr.length; j++) {
                    //i번째 봉지와 j 번째 봉지의 무게가 최대로 들 수 있는 무게보다 작으면 다음문장 실행
                    if (sum + snackArr[j]<= snackArr[0])
                        // 한빈이가 들 수 있는 무개의 최대치보다 크면 해당 무게를 max에 저장
                        if (sum +snackArr[j] > max) max = sum + snackArr[j];
                }
            }

            StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(max);
            System.out.println(stringBuilder);
        }

    }


}
