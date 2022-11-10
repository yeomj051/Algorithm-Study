package SWEA_Problem.Solution_4014;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

//10				//test_case
//6 2				//지도크기 x길이
//3 3 3 2 1 1		//지도 정보
//3 3 3 2 2 1
//3 3 3 3 3 2
//2 2 3 2 2 2
//2 2 3 2 2 2
//2 2 2 2 2 2
	private static int mapSize;		//지도 크기
	private static int x;			//활주로 x길이
	private static int[][] map;		//지도

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(4014).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			
			//지도크기 활주로 x 크기
			mapSize = Integer.parseInt(stringTokenizer.nextToken());
			x = Integer.parseInt(stringTokenizer.nextToken());
			
			//지도 입력
			map = new int[mapSize][mapSize];
			for (int i = 0; i < mapSize; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < mapSize; j++) {
					map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			
			int count = 0;
			
			for (int i = 0; i < mapSize; i++) {
				//가로 확인
				if(checkCol(i)) count++;
				//세로 확인
				if(checkRow(i)) count++;
			}
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(count);
			System.out.println(stringBuilder);
		}
	}

	private static boolean checkRow(int j) {
		int count = 1;
		int height = map[0][j];
		
		for (int i = 1; i < mapSize; i++) {
			if(height == map[i][j]) count++;
			else if(height+1 == map[i][j]) {
				height++; 
				if(count < x) return false;
				count = 1;
			}
			else if(height-1 == map[i][j]) {
				height--;
				for (int k = 1; k < x; k++) {
					if(i+k == mapSize || map[i+k][j] != height)return false;
				}
				count = 0;
				i += x-1;
			}
			else return false;
		}
		
		return true;
	}

	private static boolean checkCol(int i) {
		int count = 1;
		int height = map[i][0];
		
		for (int j = 1; j < mapSize; j++) {
			if(height == map[i][j]) count++;
			else if(height+1 == map[i][j]) {
				height++; 
				if(count < x) return false;
				count = 1;
			}
			else if(height-1 == map[i][j]) {
				height--;
				for (int k = 1; k < x; k++) {
					if(j+k == mapSize || map[i][j+k] != height) return false;
				}
				count = 0;
				j += x-1;
			}
			else return false;
		}
		
		return true;
	}


}
