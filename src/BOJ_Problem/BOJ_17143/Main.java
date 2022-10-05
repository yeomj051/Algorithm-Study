package BOJ_Problem.BOJ_17143;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

//	4 5 4			//행 열 마리수
//	4 1 3 3 8		//x좌표 y좌표 속도 이동방향(상 하 우 좌) 크기
//	1 3 5 2 9
//	2 4 8 4 1
//	4 5 0 1 4
	private static int[] dx = {0,-1,1,0,0};
	private static int[] dy = {0,0,0,1,-1};
	
	private static int rowSize;
	private static int calSize;
	private static int fishCount;
	
	private static int result = 0;
	
	private static List<Fish> fishList = new ArrayList<Fish>();

	private static class Fish{
		Point point;
		int speed;
		int direction;
		int size;
		
		public Fish(Point point, int speed, int direction, int size) {
			super();
			this.point = point;
			this.speed = speed;
			this.direction = direction;
			this.size = size;
		}

		@Override
		public String toString() {
			return "Fish [point=" + point + ", speed=" + speed + ", direction=" + direction + ", size=" + size + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		rowSize = Integer.parseInt(stringTokenizer.nextToken());		//행
		calSize = Integer.parseInt(stringTokenizer.nextToken());		//열
		fishCount = Integer.parseInt(stringTokenizer.nextToken());		//마리수
		
		fishList.add(new Fish(new Point(),0,0,0));
		for (int i = 0; i < fishCount; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			
			int r = Integer.parseInt(stringTokenizer.nextToken());
			int c = Integer.parseInt(stringTokenizer.nextToken());
			int speed = Integer.parseInt(stringTokenizer.nextToken());
			int direction = Integer.parseInt(stringTokenizer.nextToken());
			int size = Integer.parseInt(stringTokenizer.nextToken());
			
			Fish fish = new Fish(new Point(r, c), speed, direction, size);
			
			fishList.add(fish);
		}
		
//		System.out.println("=============잡기 전");
//		for (Fish fish : fishList) {
//			System.out.println(fish.toString());
//		}
		
		for (int i = 1; i <= calSize; i++) {
//			System.out.println();
			fish(i);
		}
		
		System.out.println(result);
		
	}

	private static void fish(int cal) {
		
		//낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
		fishing(cal);
		
//		System.out.println("=============잡은 후");
//		for (Fish fish : fishList) {
//			System.out.println(fish.toString());
//		}
		
		//상어가 이동한다.
		fishMove();
//		System.out.println("=============이동 후");
//		for (Fish fish : fishList) {
//			System.out.println(fish.toString());
//		}
		

	}

	private static void fishMove() {
		for (Fish fish : fishList) {
			move(fish);
		}
		
		int[][] array = new int[rowSize+1][calSize+1];
		
		for (int i = 1; i < fishList.size(); i++) {
			Fish fish1 = fishList.get(i);
			
			if(array[fish1.point.x][fish1.point.y] == 0) {
				array[fish1.point.x][fish1.point.y] = i;
				continue;
			}
			
			int fishIdx2 = array[fish1.point.x][fish1.point.y];
			array[fish1.point.x][fish1.point.y] = compare(i, fishIdx2);
			i--;
		}
		
	}

	private static int compare(int fishIdx1, int fishIdx2) {
		Fish fish1 = fishList.get(fishIdx1);
		Fish fish2 = fishList.get(fishIdx2);
		
		if(fish1.size > fish2.size) {
			fishList.remove(fishIdx2);
			return fishIdx1;
		}else {
			fishList.remove(fishIdx1);
			return fishIdx2;
		}
	}

	//상 하 우 좌
	private static void move(Fish fish) {
		int direction = fish.direction;
		
		int count = 0;
		while(count < fish.speed) {
			int nx = fish.point.x + dx[direction];
			int ny = fish.point.y + dy[direction];
			
			if(nx <= 0) nx = fish.point.x + dx[++direction];
			else if(nx > rowSize) nx = fish.point.x + dx[--direction];
			else if(ny <= 0) ny = fish.point.y + dy[--direction];
			else if(ny > calSize) ny = fish.point.y + dy[++direction];
			
			fish.point.x = nx;
			fish.point.y = ny;
			count++;
		}

		fish.direction = direction;
	}

	private static void fishing(int cal) {
		int minRowIndex = 0;
		
		for (int i = 1; i < fishList.size(); i++) {
			Fish fish = fishList.get(i);
			if(fish.point.y == cal) {
				if(minRowIndex == 0) {
					minRowIndex = i;
				}
				else if(fishList.get(minRowIndex).point.x > fish.point.x) minRowIndex = i;
			}
		}
		if(minRowIndex != 0) {
			result += fishList.get(minRowIndex).size;
			fishList.remove(minRowIndex);
		}
		
	}
	
}

