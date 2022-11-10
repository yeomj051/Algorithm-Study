package SWEA_Problem.Solution_4008;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
//	10			테스트 케이스 수
//	5			숫자 개 수
//	2 1 0 1		 '+' 2 개, '-' 1 개, '*' 0 개, '/' 1 개
//	3 5 3 7 9	수식에 사용되는 숫자
	
	private static int numCount;
	private static int[] OperatorArr = new int[4]; //[+, !, *, /]
	private static int[] numberArr;
	private static int minResult, maxResult;
	private static Deque<Integer> selectOperator ;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(4008).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			minResult = Integer.MAX_VALUE;
			maxResult = Integer.MIN_VALUE;
			
			numCount = Integer.parseInt(bufferedReader.readLine());
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			
			for (int i = 0; i < 4; i++) {
				OperatorArr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			numberArr = new int[numCount];
			for (int i = 0; i < numCount; i++) {
				numberArr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			selectOperator = new ArrayDeque<>();
			bfs(0);
			
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(maxResult = minResult);
			System.out.println(stringBuilder);
		}
	}

	private static void bfs(int count) {
		if(count == numCount-1) {
			int result = getResult();
			System.out.println("result :" + result);
			minResult = Math.min(result, minResult);
			maxResult = Math.max(maxResult, result);
		}
		
		for (int i = 0; i < 4; i++) {
			if(OperatorArr[i] > 0) {
				selectOperator.add(i);
				OperatorArr[i]--;
				bfs(count+1);
				OperatorArr[i]++;
				selectOperator.pollLast();
			}
		}
		
	}

	private static int getResult() {
		int result = numberArr[0];
		for (int i = 1; i < numCount; i++) {
			int operator = selectOperator.poll();
			switch (operator) {
			case 0:
				result += numberArr[i];
				break;
			case 1:
				result -= numberArr[i];		
				break;
			case 2:
				result *= numberArr[i];
				break;
			case 3:
				result /= numberArr[i];
				break;

			default:
				break;
			}
		}
		return result;
	}

}
