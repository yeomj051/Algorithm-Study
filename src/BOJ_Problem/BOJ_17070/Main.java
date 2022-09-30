package BOJ_Problem.BOJ_17070;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

public class Main {
	static int homeSize;
	static int[][] homeArray;
	
	//0:가로 1:세로 2:대각선
	static int[][] deltaX = {{0,1},{1,1},{0,1,1}};	//{가로, 대각선}{세로, 대각선}{가로, 대각선, 세로}
	static int[][] deltaY = {{1,1},{0,1},{1,1,0}};
	
	
	
	public class Info{
		int horizon;
		int vertical;
		int cross;
		Point point;
		
		public Info(int horizon, int vertical, int cross, Point point) {
			super();
			this.horizon = horizon;			//가로
			this.vertical = vertical;		//세로
			this.cross = cross;				//대각선
			this.point = point;				//포인트
		}
		
		

		public Info(int horizon, int vertical, int cross) {
			super();
			this.horizon = horizon;
			this.vertical = vertical;
			this.cross = cross;
		}



		@Override
		public String toString() {
			return "Info [horizon=" + horizon + ", vertical=" + vertical + ", cross=" + cross + ", point=" + point
					+ "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		homeSize = Integer.parseInt(bufferedReader.readLine());
		homeArray = new int[homeSize][homeSize];
		
		for (int i = 0; i < homeSize; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < homeSize; j++) {
				homeArray[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		
		
	}
	
	//Info(horizon:가로, vertical:세로, cross:대각선)
	private int getPipeCase() {
		Info[][] dpArray = new Info[homeSize][homeSize];
		
		dpArray[0][0] = new Info(0, 0, 0, new Point(0,0));
		dpArray[0][1] = new Info(1, 0, 0, new Point(0,1));
		dpArray[0][2] = new Info(0, 0, 0, new Point(0,2));
		
		Queue<Info> queue = new LinkedList();
		
		queue.offer(dpArray[0][2]);
		
		while(queue.size() != 0) {
			Info nowInfo = queue.poll();
			
			int bx = nowInfo.point.x;
			int by = nowInfo.point.y-1;
			if( bx > 0 && by > 0 && bx < homeSize && by < homeSize
					&& dpArray[bx][by].horizon != 0 && dpArray[bx][by].vertical != 0 && dpArray[bx][by].cross != 0 ) checkCase(0, dpArray[bx][by]);


if(nowInfo.horizon != 0) {
	for (int i = 0; i < 2; i++) {
		int nx = nowInfo.point.x + deltaX[0][i];
		int ny = nowInfo.point.y + deltaY[0][i];
		Info newInfo = new Info(0, 0, 0,new Point(nx,ny));
		queue.offer(newInfo);
	}
}
			
		}
		
		
		return 0;
	}

	//0:가로 1:세로 2:대각선
	private Info checkCase(int pipeType, Info bforInfo) {
		Info info = new Info(0,0,0);
		switch (pipeType) {
		case 0:
			if(bforInfo.horizon != 0) {
				info.horizon += bforInfo.horizon;
			}
			if(bforInfo.vertical != 0) {
				info.vertical += bforInfo.vertical;
			}
			if(bforInfo.cross != 0) {
				info.cross += bforInfo.cross;
			}
			
			break;
		case 1:
			
			break;
		case 2:
			
			break;
		}

		return info;
	}

}

