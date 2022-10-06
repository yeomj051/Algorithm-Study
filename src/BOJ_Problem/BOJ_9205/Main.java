package BOJ_Problem.BOJ_9205;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//	2
//	2
//	0 0
//	1000 0
//	1000 1000
//	2000 1000
//	2
//	0 0
//	1000 0
//	2000 1000
//	2000 2000
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		
		for (int i = 0; i < T; i++) {
			//편의점 개수
			int storeQuantity = Integer.parseInt(bufferedReader.readLine());
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			//집 위치
			Point home = new Point(Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken()));
			
			//편의점 배열
			Point[] storeArray = new Point[storeQuantity];
			for (int j = 0; j < storeQuantity; j++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				int x = Integer.parseInt(stringTokenizer.nextToken());
				int y = Integer.parseInt(stringTokenizer.nextToken());
				storeArray[j] = new Point(x,y);
			}
			
			//페스티벌 위치
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			Point festival = new Point(Integer.parseInt(stringTokenizer.nextToken()),Integer.parseInt(stringTokenizer.nextToken()));
			
			//페스티벌 참여여부
			 String isPosible = "sad";
			
			Queue<Point> queue = new LinkedList<>();
			boolean[] visited = new boolean[storeQuantity];
			queue.offer(home);
			
			while (queue.size() != 0) {
				Point nowPoint = queue.poll();
				if(canGo(nowPoint, festival)) isPosible = "happy";
				
				for (int j = 0; j < storeQuantity; j++) {
					if(!visited[j] && canGo(nowPoint, storeArray[j])) {
						visited[j] = true;
						queue.offer(storeArray[j]);
					}
				}
			}
			System.out.println(isPosible);
			
		}
		
	}

private static boolean canGo(Point nowPoint, Point nextStore) {
	int distance = Math.abs(nowPoint.x - nextStore.x) + Math.abs(nowPoint.y - nextStore.y);
	if(distance <= 1000) return true;
	
	return false;
}

}
