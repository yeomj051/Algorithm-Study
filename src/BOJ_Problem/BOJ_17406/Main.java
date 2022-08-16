package BOJ_Problem.BOJ_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int columnSize= Integer.parseInt(stringTokenizer.nextToken());
        int rowSize = Integer.parseInt(stringTokenizer.nextToken());
        int ordeerSize = Integer.parseInt(stringTokenizer.nextToken());

        int [][] array = new int[columnSize][rowSize];

        for (int i = 0; i < columnSize; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < rowSize; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < ordeerSize; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            int s = Integer.parseInt(stringTokenizer.nextToken());

            int r_s = r-s-1;  //column
            int c_s = c-s-1;  //row
            int rs = r+s-1;   //column
            int cs = c+s-1;   //row

            for (int j = 0; j < Math.min(rs-r_s, cs-c_s)/2; j++) {
                int temp = array[r_s+j][c_s+j];
                for (int k = r_s+j; k < rs-j; k++) {
                    array[k][c_s+j] = array[k+1][c_s+j];
                }
                for (int k = c_s+j; k < cs-j; k++) {
                    array[rs-j][k] = array[rs-j][k+1];
                }
                for (int k = rs-j; k > r_s+j; k--) {
                    array[k][cs-j] = array[k-1][cs-j];
                }
                for (int k = cs-j; k > c_s+j+1; k--) {
                    array[r_s+j][k] = array[r_s+j][k-1];
                }
                array[r_s+j][c_s+j+1]=temp;
            }


        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < columnSize; i++) {
            int sum =0;
            for (int j = 0; j < rowSize; j++) sum += array[i][j];
            if (min > sum) min = sum;
        }

        System.out.println(min);

    }
}

