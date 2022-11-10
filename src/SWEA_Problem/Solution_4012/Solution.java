package SWEA_Problem.Solution_4012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {



//10		// 총 테스트 케이스의 개수 T = 10
//4		// 첫 번째 테스트 케이스, N = 4, 본문 예제
//0 5 3 8		// S11, S12, S13, S14
//4 0 4 1
//2 5 0 3
//7 2 3 0
	private static int foodQuantity;
	private static int[][] synergyMap;
	private static int minResult;
	private static int foodA,foodB;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(4012).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			foodQuantity = Integer.parseInt(bufferedReader.readLine());
			synergyMap = new int[foodQuantity][foodQuantity];
			for (int i = 0; i < foodQuantity; i++) {
				StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < foodQuantity; j++) {
					synergyMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			
			boolean[] visited = new boolean[foodQuantity];
			minResult = Integer.MAX_VALUE;
			combination(0,0,visited, foodQuantity/2);
			
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(minResult);
			System.out.println(stringBuilder);
		}
		
	}

	private static void combination(int count,int start, boolean[] visited, int getHow) {
		if(count == getHow) {
			int interver = getinterver(visited);
//			System.out.println(" interver : "+interver);
			minResult = Math.min(minResult, interver);
			return;
		}
		
		for (int i = start; i < foodQuantity; i++) {
			visited[i] = true;
			combination(count+1, i+1, visited, getHow);
			visited[i] = false;
		}
		return;
		
	}

	private static int getinterver(boolean[] visited) {
		List<Integer> foodList1 = new ArrayList<>();
		List<Integer> foodList2 = new ArrayList<>();
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i]) {
				foodList1.add(i);
			}
			else foodList2.add(i);
		}
		//출력
//		System.out.print("foodA : " + synergyMap[foodList1.get(0)][foodList1.get(1)] + " " + synergyMap[foodList1.get(1)][foodList1.get(0)]);
//		System.out.print(" foodB : " + synergyMap[foodList2.get(0)][foodList2.get(1)] + " " + synergyMap[foodList2.get(1)][foodList2.get(0)]);
		
		foodA = 0;
		makeFoodA(0,0,new boolean[foodQuantity/2], foodList1);
		foodB = 0;
		makeFoodB(0,0,new boolean[foodQuantity/2], foodList2);
//		int foodA = synergyMap[foodList1.get(0)][foodList1.get(1)] + synergyMap[foodList1.get(1)][foodList1.get(0)];
//		int foodB = synergyMap[foodList2.get(0)][foodList2.get(1)] + synergyMap[foodList2.get(1)][foodList2.get(0)];
		
		return Math.abs(foodA-foodB);
	}

	private static void makeFoodB(int count, int start, boolean[] visited, List<Integer> foodList) {
		if(count == 2) {
			List<Integer> foodList3 = new ArrayList<>();
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					foodList3.add(foodList.get(i));
				}
			}
			foodB += synergyMap[foodList3.get(0)][foodList3.get(1)] + synergyMap[foodList3.get(1)][foodList3.get(0)];
			return;
		}
		
		for (int i = start; i < foodList.size(); i++) {
			visited[i] = true;
			makeFoodB(count+1, i+1, visited, foodList);
			visited[i] = false;
		}
		return;
		
	}

	private static void makeFoodA(int count, int start, boolean[] visited, List<Integer> foodList) {
		if(count == 2) {
			List<Integer> foodList3 = new ArrayList<>();
			for (int i = 0; i < visited.length; i++) {
				if(visited[i]) {
					foodList3.add(foodList.get(i));
				}
			}
			foodA += synergyMap[foodList3.get(0)][foodList3.get(1)] + synergyMap[foodList3.get(1)][foodList3.get(0)];
			return;
		}
		
		for (int i = start; i < foodList.size(); i++) {
			visited[i] = true;
			makeFoodA(count+1, i+1, visited, foodList);
			visited[i] = false;
		}
		return;
		
	}



}
