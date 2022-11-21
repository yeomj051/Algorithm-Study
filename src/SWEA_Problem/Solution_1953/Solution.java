package SWEA_Problem.Solution_1953;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

private static int rowSize;
private static int colSize;
private static int manholeX;
private static int manholeY;
private static int time;
private static int count;
private static int[][] map;
private static Point manholePoint;

//1:상하좌우 2:상하 3:좌우 4:상우 5:하우 6:좌하 7:좌상
private static int[][] deltaX = {{},{-1,1,0,0},{-1,1},{0,0},{-1,0},{1,0},{0,1},{0,-1}};
private static int[][] deltaY = {{},{0,0,-1,1},{0,0},{-1,1},{0,1},{0,1},{-1,0},{-1,0}};

//5              
//5 6 2 1 3      세로  가로  멘홀row  맨홀col  시간
//0 0 5 3 6 0
//0 0 2 0 2 0
//3 3 1 3 7 0
//0 0 0 0 0 0
//0 0 0 0 0 0

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(1953).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			rowSize = Integer.parseInt(stringTokenizer.nextToken());
			colSize = Integer.parseInt(stringTokenizer.nextToken());
			manholeX = Integer.parseInt(stringTokenizer.nextToken());
			manholeY = Integer.parseInt(stringTokenizer.nextToken());
			manholePoint = new Point(manholeX, manholeY);
			time = Integer.parseInt(stringTokenizer.nextToken());
			
			//map 생성
			map = new int[rowSize][colSize];
			for (int i = 0; i < rowSize; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 0; j < colSize; j++) {
					map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}
			
			// 맨홀 위치에서 dfs 시작 
			count = 1;
			dfs();
			
			
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(count);
			System.out.println(stringBuilder);
			
		}

	}

	private static void dfs() {
		Deque<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rowSize][colSize];
		
		queue.add(manholePoint);
		visited[manholeX][manholeY] = true;
		
		while(queue.size() != 0 && time-- >0) {
			for (int k = 0; k < queue.size(); k++) {
				Point nowPoint = queue.poll();
				int nowType = map[nowPoint.x][nowPoint.y];
				
				for (int i = 0; i < deltaX[nowType].length; i++) {
					int nextX = nowPoint.x + deltaX[nowType][i];
					int nextY = nowPoint.y + deltaY[nowType][i];
					
					if(nextX >= 0 && nextY >=0 && nextX < rowSize && nextY < colSize) {
						if(canGo(nowPoint,new Point(nextX, nextY),visited)) {
							visited[nextX][nextY] = true;
							queue.add(new Point(nextX, nextY));
							count++;
						}
					}
				}
			}
		}
		
	}

	private static boolean canGo(Point nowPoint,Point nextPoint,boolean[][] visited) {
		int nextX = nextPoint.x;
		int nextY = nextPoint.y;
		int nextType = map[nextX][nextY];
		
			for (int i = 0; i < deltaX[nextType].length; i++) {
				int nowX = nextPoint.x + deltaX[nextType][i];
				int nowY = nextPoint.y + deltaY[nextType][i];
//				Point point = new Point(nowX, nowY);
				if(nowPoint.x == nowX && nowPoint.y == nowY && !visited[nextX][nextY]) {
					return true;
				}
			}
		return false;
	}

}
