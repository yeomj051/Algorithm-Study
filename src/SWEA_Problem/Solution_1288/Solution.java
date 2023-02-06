package SWEA_Problem.Solution_1288;

import java.io.*;

public class Solution {
    private static int N = 0;
    private static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/sample_input(1288).txt"));
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            input();
            int result = logic();

            StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(result);
            System.out.println(stringBuilder);
        }

    }

    private static int logic() {
        int total = (1 << 10) -1;   //이진수로 1111111111(2) 0~9까지의 숫자가 모두 존재함을 의미한다.
        int now = 0;  //0~9까지의 숫자 중 존재하는 숫자 의미
        int sheep = 0;  //양의 숫자

        while(total != now){
            sheep++;
//            System.out.println(N+ " * " + sheep + " = " + N * sheep);
            char[] numberArray = String.valueOf(N * sheep).toCharArray();
            for (int i = 0; i < numberArray.length; i++) {
                int number = 1 << (numberArray[i] -'0');
//                System.out.println("number = " + (numberArray[i] -'0'));
                now = now | number;
            }
        }

        return sheep*N;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
    }
}
