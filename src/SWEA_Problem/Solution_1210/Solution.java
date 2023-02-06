package SWEA_Problem.Solution_1210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input(1210).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T=10;

		for(int test_case = 1; test_case <= T; test_case++){
			int test = Integer.parseInt(bufferedReader.readLine());
			int [][] ladderArr = new int[100][100];
			int indexI =99;
			int indexJ =0;


			//사다리 생성
			for (int i = 99; i >= 0; i--) {
				StringTokenizer arr = new StringTokenizer(bufferedReader.readLine());

				for (int j = 0; j < 100; j++) {
					ladderArr[i][j] = Integer.parseInt(arr.nextToken());
				}
			}
			//출발위치찾기
			for (int i = 0; i < 100; i++) {
				if (ladderArr[0][i] == 2) {
					indexJ = i;
				}
			}

			// 사다리 타기
			for (int i = 0; i < 100; i++) {
				if (indexJ > 0 && ladderArr[i][indexJ-1]==1) {
					indexJ = leftMove(ladderArr, i,indexJ);
				}else if (indexJ < 99 && ladderArr[i][indexJ+1]==1) {
					indexJ = rightMove(ladderArr, i,indexJ);
				}
			}


			System.out.println("#" + test_case + " " + indexJ);
		}
	}

	private static int leftMove(int[][] arr, int indexI,int indexJ) {
		if (indexJ > 0 && arr[indexI][indexJ-1] ==1) {
			indexJ = leftMove(arr, indexI, indexJ-1);
		}
		return indexJ;
	}
	private static int rightMove(int[][] arr, int indexI,int indexJ) {
		if (indexJ < 99 && arr[indexI][indexJ+1] ==1) {
			indexJ = rightMove(arr, indexI, indexJ+1);
		}
		return indexJ;
	}


}
