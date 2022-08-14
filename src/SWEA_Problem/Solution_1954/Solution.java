package SWEA_Problem.Solution_1954;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input(1954).txt"));
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int boxSize = Integer.parseInt(bufferedReader.readLine());

            int [][] box = new int[boxSize][boxSize];

            int indexR =-1;
            int indexC =0;
            int number =1;

            while (boxSize>0) {

                for (int i = 0; i < boxSize; i++) {
                    box[indexC][++indexR]=number++;
                }
                boxSize--;
                for (int i = 0; i < boxSize; i++) {
                    box[++indexC][indexR]=number++;
                }
                for (int i = 0; i < boxSize; i++) {
                    box[indexC][--indexR]=number++;
                }
                boxSize--;
                for (int i = 0; i < boxSize; i++) {
                    box[--indexC][indexR]=number++;
                }
            }

            for (int i = 0; i < box.length; i++) {
                for (int j = 0; j < box.length; j++) {
                    System.out.print(box[i][j]+ " ");
                }
                System.out.println();
            }


            System.out.println("#" + test_case + " " );
        }

    }

}

