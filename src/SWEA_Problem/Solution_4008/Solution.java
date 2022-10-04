package SWEA_Problem.Solution_4008;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
//	10			테스트 케이스 수
//	5			숫자 개 수
//	2 1 0 1		 '+' 2 개, '-' 1 개, '*' 0 개, '/' 1 개
//	3 5 3 7 9	수식에 사용되는 숫자
	
	private static int numCount;
	private static int[] OperatorArr = new int[4]; //[+, !, *, /]
	private static int[] numberArr;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(4008)"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			numCount = Integer.parseInt(bufferedReader.readLine());
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			
			for (int i = 0; i < 4; i++) {
				OperatorArr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			numberArr = new int[numCount];
			for (int i = 0; i < numCount; i++) {
				numberArr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ");
		}
	}

}
