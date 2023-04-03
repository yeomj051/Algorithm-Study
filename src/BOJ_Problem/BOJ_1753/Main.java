package BOJ_Problem.BOJ_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int node;
	private static int line;
	private static int startNode;
	private static int[][] map;

	//		5 6		정점개수 간선개수
//		1		시작정점
//		5 1 1	정점부터 정점까지 가중치
//		1 2 2
//		1 3 3
//		2 3 4
//		2 4 5
//		3 4 6
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		node = Integer.parseInt(stringTokenizer.nextToken());
		line = Integer.parseInt(stringTokenizer.nextToken());
		startNode = Integer.parseInt(bufferedReader.readLine());
		map = new int[node+1][node+1];

		for (int i = 0; i < line; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			map[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())] = Integer.parseInt(stringTokenizer.nextToken());
		}

		//출력
		for (int i = 0; i < node; i++) {
			for (int j = 0; j < node; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		

	}

}
