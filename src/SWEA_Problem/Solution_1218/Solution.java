package SWEA_Problem.Solution_1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	private static BufferedReader bufferedReader;
	private static int test_lenth;
	private static String test;
	private static char[] test_list;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/input(1218).txt"));
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));	//입력 객체 생성

		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			init();     //test case 실행 시 변수 초기화
			input();    //입력 받는 함수
			int result = logic();

			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(result);	//출력객체 생성
			System.out.println(stringBuilder);	//출력
		}
	}

	private static void init() {
	}

	private static void input() throws IOException {
		//182
		//(({<(({{[[[[<<[[(<[[{([{{{[<[[[{<<(<[[{}[]{}{}[]]]><><>{})[]{}><>[]<>><>}][]]<>{}]>]()}()()(){}}}{}][])(){}<>()}]{}[]]>()[][][]){}]]{}[]<>><>{}[]{}<>>]]]][]{}{}[]()}}))>}<>{}()))[][]
		test_lenth = Integer.parseInt(bufferedReader.readLine());    //테스트 길이 입력
		test = bufferedReader.readLine();    //괄호 스트림 입력
	}


	private static int logic() {
		test_list = test.toCharArray();    //괄호 스트링 char배열로 변환
		Stack<Character> stack = new Stack<Character>();    // 열린 괄호 : push, 당힌 괄호 : pop
		boolean flag = true;    //유효할 경우 : true, 유효하지 않을 경우 : false

		//테스트 길이만큰 반복
		for (int i = 0; i < test_lenth; i++) {
			if (!flag) break;
			switch (test_list[i]) {
				case '(':
				case '[':
				case '{':
				case '<':
					stack.push(test_list[i]);
					break;
				case ')':
					if (stack.pop() != '(') flag = false;
					break;
				case ']':
					if (stack.pop() != '[') flag = false;
					break;
				case '}':
					if (stack.pop() != '{') flag = false;
					break;
				case '>':
					if (stack.pop() != '<') flag = false;
					break;
			}
		}
		if (flag && stack.isEmpty()) return 1;
		return 0;
	}
}

