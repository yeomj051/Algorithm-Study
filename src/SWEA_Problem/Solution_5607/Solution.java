package SWEA_Problem.Solution_5607;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	

//1		// 전체 테스트케이스 개수
//10 2	// 첫 번째 TC의 정수 N R

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/sample_input(5607).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int N = Integer.parseInt(stringTokenizer.nextToken());
			int R = Integer.parseInt(stringTokenizer.nextToken());
			
			int result = N*(N-1) / R*(R-1);
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(result);
			System.out.println(stringBuilder);
		}
	}

}
