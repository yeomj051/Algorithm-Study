package BOJ_Problem.BOJ_2178;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
//	4 6			//행 열
//	101111		//1:길 2:벽
//	101010
//	101011
//	111011

	private static int rowSize;
	private static int colSize;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		rowSize = Integer.parseInt(bufferedReader.readLine());
		colSize = Integer.parseInt(bufferedReader.readLine());
		
		map = new int[rowSize+1][colSize+1];
		
		for (int i = 1; i <= rowSize; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 1; j <= colSize; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		
		BFS();
	}

	private static void BFS() {
		Queue<Point> queue = new LinkedList<Point>();
		int[][] visited = new int[rowSize+1][colSize+1];
		
	}

}
