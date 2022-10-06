package SWEA_Problem.Solution_3307;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	//	2
	//	5
	//	1 3 2 5 4 
	private static int numCount;
	private static int[] numArray;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(3307).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			numCount = Integer.parseInt(bufferedReader.readLine());
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			numArray = new int[numCount];
			for (int i = 0; i < numCount; i++) {
				numArray[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			int[] resultArray = new int[numCount];
			int size = 0;
			
			for (int i : numArray) {
				int position = Arrays.binarySearch(resultArray, 0, size, i);
				if(position >= 0) continue;
				
				position = Math.abs(position)-1;
				resultArray[position] = i;
				if(position == size) size++;
			}
			
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(size);
			System.out.println(stringBuilder);
		}
	}

}
