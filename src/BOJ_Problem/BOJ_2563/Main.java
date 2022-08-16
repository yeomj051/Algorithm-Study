package BOJ_Problem.BOJ_2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //색종이 갯수
        int paperCount = Integer.parseInt(bufferedReader.readLine());
        //흰도화지 배열 생성
        int[][] whitePaperArr = new int[100][100];

        for (int i = 0; i < paperCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int xNum = Integer.parseInt(stringTokenizer.nextToken());
                int yNum = Integer.parseInt(stringTokenizer.nextToken());

                //색종이에 해당하는 부분은 1로 입력
                for (int x = xNum; x < xNum + 10; x++) {
                    for (int y = yNum; y < yNum + 10; y++) {
                        whitePaperArr[x][y] =1;

                    }
                }

        }

        int count =0;
        //흰도화지 배열에서 1의 개수 세기
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                if (whitePaperArr[j][k] ==1) count++;
//                System.out.print(whitePaperArr[j][k]);
            }
//            System.out.println();
        }
        System.out.println(count);

    }
}
