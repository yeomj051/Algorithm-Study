package BOJ_Problem.BOJ_10026;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	5		mapSize
//	RRRBB
//	GGBBB
//	BBBRR
//	BBRRR
//	RRRRR
	//상 하 좌 우
	private static int[] dx = {-1, 1, 0, 0 }; 
	private static int[] dy = {0, 0, -1, 1 }; 
	
	private static int mapSize;
	private static char[][] map;
	private static boolean[][] visited;

	private static int common=0;
	private static int colorWeak=0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		mapSize = Integer.parseInt(bufferedReader.readLine());
		map = new char[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			String string =bufferedReader.readLine();
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = string.charAt(j);
			}
		}
		
		char[][] commontMap = copyMap(true);
		char[][] colorWeakMap = copyMap(false);
		
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				char color = commontMap[i][j];
				if (color == 'R' || color == 'G' ||color == 'B') {
					getSection(new Point(i, j),commontMap);
					common++;
				}
				
				color = colorWeakMap[i][j];
				if (color == 'R'||color == 'B') {
					getSection(new Point(i, j),colorWeakMap);
					colorWeak++;
				}
			}
		}
		
		System.out.println(common + " " + colorWeak);
		
	}


	//true:일반 false:적록색약
	private static char[][] copyMap(boolean isCommon) {
		char[][] newMap = new char[mapSize][mapSize];
		
		//일반인
		if(isCommon) {
			for (int i = 0; i < mapSize; i++) {
				for (int j = 0; j < mapSize; j++) {
					newMap[i][j] = map[i][j];
				}
			}
		}
		//적록색약
		else {
			for (int i = 0; i < mapSize; i++) {
				for (int j = 0; j < mapSize; j++) {
					if(map[i][j] == 'G') newMap[i][j] = 'R';
					else newMap[i][j] = map[i][j];
				}
			}
		}
		
		return newMap;
	}


	private static void getSection(Point point, char[][] map) {
		char color = map[point.x][point.y];
		
		Queue<Point> queue = new LinkedList<Point>();
		visited = new boolean[mapSize][mapSize];
		
		queue.offer(point);
		visited[point.x][point.y] = true;
		
		while (!queue.isEmpty()) {
			Point nowPoint = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = nowPoint.x + dx[i];
				int ny = nowPoint.y + dy[i];
				
				// map 범위를 벗어나거나 방문한 곳이면 넘기기
				if(nx<0 || nx==mapSize || ny<0 || ny==mapSize || visited[nx][ny] ) continue;
				if(map[nx][ny] != color) continue;
				
				visited[nx][ny] = true;
				map[nx][ny] = 'F';
				queue.offer(new Point(nx,ny));
			}
		}
	}

}
