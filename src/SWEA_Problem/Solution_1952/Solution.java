package SWEA_Problem.Solution_1952;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		
		
		
		for (int test_cast = 1; test_cast <= T; test_cast++) {
			
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			
			int day = Integer.parseInt(stringTokenizer.nextToken());
			int month = Integer.parseInt(stringTokenizer.nextToken());
			int threeMonth = Integer.parseInt(stringTokenizer.nextToken());
			int year = Integer.parseInt(stringTokenizer.nextToken());
			
			int[] priceArr = new int[4];
			
			for (int i = 0; i < 4; i++) {
				priceArr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			int[] monthPlan = new int[12];
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			
			int minPrice = Integer.MAX_VALUE;
			
			for (int i = 0; i < 12; i++) {
				monthPlan[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			
			//1일
			for (int i = 0; i < 12; i++) {
				int total = 0;
				total += monthPlan[i];
				int totalPrice = total * day;
				if (minPrice > totalPrice) minPrice = totalPrice;
			}
			
			//1달
			for (int i = 0; i < 12; i++) {
				int totalPrice = 0;
				totalPrice += month*monthPlan[i];
				if (minPrice > totalPrice) minPrice = totalPrice;
			}

			//3달
			for (int i = 0; i < 12; i++) {
				int totalPrice = 0;
				totalPrice += month*monthPlan[i];
				
				if (minPrice > totalPrice) minPrice = totalPrice;
			}
			
			
			
			
		}
		

	}
	static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}

}
