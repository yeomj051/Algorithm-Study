package SWEA_Problem.Solution_1249;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	//상하좌우 델타
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};

	//지도 크기 변수
	private static int mapSize;
	//지도 배열
	private static int[][] mapArray;

	//최솟값 변수
	private static int minResult;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input(1249).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		//테스트 케이스 입력
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			//지도 크게 입력 + 지도 크기 배열
			mapSize = Integer.parseInt(bufferedReader.readLine());
			mapArray = new int[mapSize][mapSize];

			//지도 입력
			for (int i = 0; i < mapSize; i++) {
				String string = bufferedReader.readLine();
				for (int j = 0; j <mapSize; j++) {
					mapArray[i][j] = string.charAt(j) - '0';
				}
			}

			//bfs 메소드 호출 결과 받기
			minResult = bfs();

			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(minResult);
			System.out.println(stringBuilder);

		}

	}

	private static int bfs(){
		// dp 배열 생성
		int[][] dpArray = new int[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			Arrays.fill(dpArray[i],Integer.MAX_VALUE);
		}
		//Queue 생성
		Queue<Point> queue = new LinkedList<Point>();
		//큐에 출발점 삽입
		queue.offer(new Point(0,0));
		dpArray[0][0] = 0;

		while(!queue.isEmpty()){
			Point nowPoint = queue.poll();

			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				//delta를 통해 다음 노드 위치 받기
				int nx = nowPoint.x + dx[i];
				int ny = nowPoint.y + dy[i];

				if(nx >= 0 && nx < mapSize && ny >= 0 && ny < mapSize){
					int goNext = dpArray[nowPoint.x][nowPoint.y] + mapArray[nx][ny];
					if (goNext < dpArray[nx][ny]) {
						dpArray[nx][ny] = goNext;
						queue.offer(new Point(nx,ny));
					}
				}

			}
		}

	return dpArray[mapSize-1][mapSize-1];
	}

	//digkstra 탐색
	
}
