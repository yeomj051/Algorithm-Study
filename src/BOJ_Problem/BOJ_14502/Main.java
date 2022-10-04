package BOJ_Problem.BOJ_14502;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	7 7				//row cal
//	2 0 0 0 1 1 0
//	0 0 1 0 1 2 0
//	0 1 1 0 1 0 0
//	0 1 0 0 0 0 0
//	0 0 0 0 0 1 1
//	0 1 0 0 0 0 0
//	0 1 0 0 0 0 0
	
	//상항좌우
	private static int[] dx = {-1,1,0,0};		
	private static int[] dy = {0,0,-1,1};
	
	
	private static int rowSize, calSize;
	private static int[][] originMap;
	private static int[][] resultMap;
	
	private static int maxResult;
	
	private static List<Point> originV = new ArrayList<Point>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		rowSize = Integer.parseInt(stringTokenizer.nextToken());
		calSize = Integer.parseInt(stringTokenizer.nextToken());
		
		originMap = new int[rowSize][calSize];
		resultMap = new int[rowSize][calSize];
		
		for (int i = 0; i < rowSize; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < calSize; j++) {
				originMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				if(originMap[i][j] == 2) originV.add(new Point(i,j));
			}
		}
		
		getResult(0,originMap, new Point(0,0));
		
//		출력
		System.out.println("============= 결과");
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < calSize; j++) {
				System.out.print(resultMap[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(maxResult);
		
	}

	private static void getResult(int count, int[][] map, Point point) {
		if(count == 3) {
//			출력
//			System.out.println("============= 순열");
//			for (int i = 0; i < rowSize; i++) {
//				for (int j = 0; j < calSize; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			int safeArea = spreadV(map);
//			System.out.println("safeArea " + safeArea);
			if(safeArea > maxResult) {
				for (int i = 0; i < rowSize; i++) {
					for (int j = 0; j < calSize; j++) {
						resultMap[i][j] = map[i][j];
					}
				}
				maxResult = safeArea;
			}
		}
		
		int[][] newMap = new int[rowSize][calSize];
		
		for (int i = point.x; i < rowSize; i++) {
			for (int j = point.y; j < calSize; j++) {
				newMap = copyMap(map);
				
				if(newMap[i][j] == 0) {
					newMap[i][j] = 1;
					getResult(count+1, newMap, new Point(i,j));
				}
			}
		}
		
	}

	private static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[rowSize][calSize];
		
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < calSize; j++) {
				newMap[i][j] =  map[i][j];
			}
		}
		return newMap;
	}

	private static int spreadV(int[][] map) {
		Queue<Point> queue = new LinkedList<>(); 
		for (int i = 0; i < originV.size(); i++) {
			queue.offer(originV.get(i));
		}
		
		while(! queue.isEmpty()) {
			Point nowPoint = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = nowPoint.x + dx[d];
				int ny = nowPoint.y + dy[d];
				
				while(nx >=0 && nx < rowSize && ny >=0 && ny < calSize && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					queue.offer(new Point(nx,ny));
					nx += dx[d];
					ny += dy[d];
				}
			}		
		}

		int count = 0;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < calSize; j++) {
				if(map[i][j] == 0) count++;
			}
		}
		
		//출력
//		System.out.println("============= 순열");
//		for (int i = 0; i < rowSize; i++) {
//			for (int j = 0; j < calSize; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		return count;
		
	}

}
