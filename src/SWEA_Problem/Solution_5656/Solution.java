package SWEA_Problem.Solution_5656;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

//5							// T = 5
//3 10 10					// #1, N = 3, W = 10, H = 10
//0 0 0 0 0 0 0 0 0 0
//1 0 1 0 1 0 0 0 0 0
//1 0 3 0 1 1 0 0 0 1
//1 1 1 0 1 2 0 0 0 9
//1 1 4 0 1 1 0 0 1 1
//1 1 4 1 1 1 2 1 1 1
//1 1 5 1 1 1 1 2 1 1
//1 1 6 1 1 1 1 1 2 1
//1 1 1 1 1 1 1 1 1 5
//1 1 7 1 1 1 1 1 1 1

	//상항좌우
	private static int[] dx = {-1,1,0,0};		
	private static int[] dy = {0,0,-1,1};		
	
	private static int bullet;
	private static int rowSize, calSize;
	private static int[][] gameMap;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/sample_input(5656).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			 
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
			bullet = Integer.parseInt(stringTokenizer.nextToken());		//총알 개수
			calSize = Integer.parseInt(stringTokenizer.nextToken());	//열 수
			rowSize = Integer.parseInt(stringTokenizer.nextToken());	//행 수
			
			gameMap = new int[rowSize][calSize];
			for (int i = 0; i < rowSize; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < calSize; j++) {
					gameMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			
			
		
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ");
			System.out.println();
		}

	}
	
	
	public static void remove(int row, int cal, int[][] map) {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.offer(new Point(row, cal));
		
		while(!queue.isEmpty()) {
			Point nowBrick = queue.poll();
			int count = 0;
			if(map[nowBrick.x][nowBrick.y] > 0) count = map[nowBrick.x][nowBrick.y]-1;
			
			for (int i = 0; i < 4; i++) {
				int nx = nowBrick.x;
				int ny = nowBrick.y;
				for (int j = 0; j < count; j++) {
					nx += dx[i];
					ny += dy[i];
					if(nx >= 0 && nx < rowSize && ny >= 0 && ny < calSize) {
						if ( map[nx][ny] == 1 || map[nx][ny] == 0) {
							map[nx][ny] = 0;
							continue;
						}
						queue.offer(new Point(nx, ny));
					}
				}
			}
			
			map[nowBrick.x][nowBrick.y] = 0;
		}
		
		//빈 공간에 별돌 떨어뜨리기
		for (int i = 0; i < calSize; i++) {
			Queue<Integer> moveQueue = new LinkedList<Integer>();
			for (int j = rowSize-1; j >= 0; j--) {
				if(map[j][i] > 0) moveQueue.offer(map[j][i]);
				map[j][i] = 0;
			}
			int idx = rowSize-1;
			while(!moveQueue.isEmpty()) map[idx--][i] = moveQueue.poll();
		}
		
		
//		System.out.println("============== remove " + nowBrick.x + " " + nowBrick.y);
//		for (int i = 0; i < rowSize; i++) {
//			for (int j = 0; j < calSize; j++) {
//				System.out.print(gameMap[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
	}

}
