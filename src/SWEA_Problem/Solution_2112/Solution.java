package SWEA_Problem.Solution_2112;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	//10            	총 테스트 케이스 개수 T=10
	//6 8 3         	테스트 케이스 1, D=6, W=8, K=3
	//0 0 1 0 1 0 0 1	1번째 막 AABABAAB(0:A 1:B)
	//0 1 0 0 0 1 1 1	2번째 막 ABAAABBB
	//0 1 1 1 0 0 0 0
	//1 1 1 1 0 0 0 1
	//0 1 1 0 1 0 0 1
	//1 0 1 0 1 1 0 1
	
	private static int D;
	private static int W;
	private static int K;
	private static int[][] film;

	private static int minMedi;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(2112).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			D = Integer.parseInt(stringTokenizer.nextToken());
			W = Integer.parseInt(stringTokenizer.nextToken());
			K = Integer.parseInt(stringTokenizer.nextToken());
			
			film = new int[D][W];
			for (int i = 0; i < D; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			minMedi = Integer.MAX_VALUE;
			getSubset(0, new boolean[D]);
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(minMedi);
			System.out.println(stringBuilder);
		}
	}


	private static void getSubset(int count, boolean[] visited) {
		if(count == D) {
			List<Integer> mediArray = new ArrayList<>();
			for (int i = 0; i < D; i++) {
				if(visited[i]) mediArray.add(i);
			}

			int[] AorBArray = new int[mediArray.size()];
			Arrays.fill(AorBArray, 2);
			//A할지 B할지 결정
			decideAorB(0, AorBArray, mediArray);
			
			return;
		}
		
		visited[count] = false;
		getSubset(count+1, visited);
		visited[count] = true;
		getSubset(count+1, visited);

	}


	private static void decideAorB(int count, int[] aorBArray, List<Integer> mediArray) {

		if(count == aorBArray.length) {
			int[][] filmCopy = new int[D][W];
			for (int i = 0; i < D; i++) {
				filmCopy[i] = film[i].clone();
			}

			for (int i = 0; i < aorBArray.length; i++) {
				if(aorBArray[i] == 0) {
					Arrays.fill(filmCopy[mediArray.get(i)],0);
				}else{
					Arrays.fill(filmCopy[mediArray.get(i)],1);
				}
			}

			//검증
			if(test(filmCopy) && mediArray.size() < minMedi){
				minMedi = mediArray.size();
			}
			return;
		}
		aorBArray[count] = 1;
		decideAorB(count+1,aorBArray,mediArray);
		aorBArray[count] = 0;
		decideAorB(count+1,aorBArray,mediArray);
		
	}

	private static boolean test(int[][] filmCopy) {
		for (int i = 0; i < W; i++) {
			int count = 0;
			int now = 2;
			for (int j = 0; j < D; j++) {
				if(now != filmCopy[j][i]){
					count =1;
					now = filmCopy[j][i];
				}else{
					count++;
					//카운트가 K보다 크면 break
					if(count >= K) break;
				}
			}
			if(count < K) return false;
		}
		return true;
	}


}
