package BOJ_Problem.BOJ_17135;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	//가로, 세로, 공격거리
	static int N, M, attackDistance;
	//게임 맵 큐
	static int[][] gameMap;
	
	//죽인 적의 수 최댓값
	static int maxKill = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		//가로, 세로, 공격거리 입력
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		attackDistance = Integer.parseInt(stringTokenizer.nextToken());
		
		//게임맵 큐 등록
		gameMap = new int[N][M];
		for (int i = N-1; i >= 0; i--) { 
			stringTokenizer =new StringTokenizer(bufferedReader.readLine());
			
			for (int j = 0; j < M; j++) {
				gameMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		
		getArcherPosition(0, 0, new boolean[M]);

	}
	
	private static void getArcherPosition(int count, int index, boolean[] isVisit) {
		
		if (count == 3) {
			//gameMap 복사
			int[][] gameMapClone = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				gameMapClone[i] = gameMap[i].clone();
				for (int j = 0; j < gameMapClone[i].length; j++) {
				}
			}
			
			//해당 궁수 조합으로 게임 실행
			playGame(isVisit, gameMapClone, 0);
			
			return;
		}
		
		if (index >= isVisit.length) return;
		
		isVisit[index] = true;
		getArcherPosition(count+1, index+1, isVisit);
		isVisit[index] = false;
		getArcherPosition(count, index+1, isVisit);
		
	}
	
	private static void playGame(boolean[] isVisit, int[][] gameMapClone, int gameTurn) {
		if (gameTurn == N) {
			int count = 0;
			//죽인 적 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (gameMapClone[i][j] == 2) count++;
				}
			}
			System.out.println(count);
			if (count > maxKill) maxKill = count;
			
			return;
		}
		
		kill(gameMapClone, gameTurn, isVisit);
		
		playGame(isVisit, gameMapClone, gameTurn+1);
	}
	
	private static void kill(int[][] gameMapClone, int gameTurn, boolean[] isVisit) {
		List<Point> points = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			if (isVisit[i]) {
				for (int k = gameTurn; k < gameTurn + attackDistance && k< N; k++) {
					
					for (int j = i-attackDistance+1; j <= i + attackDistance-1; j++) {
						
						if (j >= 0 && j < M && gameMapClone[k][j] == 1) {
							Point point = new Point(k, j);
							points.add(point);
							
							return;
						}
						
					}
					
				}
			}
		}
		
		for (Point point : points) {
			gameMapClone[point.x][point.y] = 2;
		}

	}

}
