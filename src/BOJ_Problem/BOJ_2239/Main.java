package BOJ_Problem.BOJ_2239;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//	103000509
//	002109400
//	000704000
//	300502006
//	060000050
//	700803004
//	000401000
//	009205800
//	804000107
	private static int[][] sudocuArray = new int[9][9];
	private static int[][] resultArray = new int[9][9];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < 9; j++) {
				sudocuArray[i][j] = string.charAt(j) - '0';
			}
		}
		fillSudocu(new Point(0,0));

		//출력
//		System.out.println("완성 스도쿠");

	}

	private static void fillSudocu(Point point) {
		int nowX = point.x;
		int nowY = point.y;

		int nextY = nowY + 1;
		int nextX = nowX;
		if (nextY == 9){
			nextY = 0;
			nextX = nowX + 1;
		}

		if (nowX == 9) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					stringBuilder.append(sudocuArray[i][j]);
	//				System.out.print(resultArray[i][j]);
				}
			stringBuilder.append("\n");
			}
			System.out.println(stringBuilder);
			System.exit(0);
			return;
		}

		if (sudocuArray[nowX][nowY] == 0) {
			for (int i = 1; i < 10; i++) {
				if (isPosible(i, point)) {
					sudocuArray[nowX][nowY] = i;
					fillSudocu(new Point(nextX, nextY));
					sudocuArray[nowX][nowY] = 0;
				}
			}
			return;
		}else{
			fillSudocu(new Point(nextX,nextY));
		}
		return;
	}

	private static boolean isPosible(int number, Point point) {
		for (int i = 0; i < 9; i++) {
			if(sudocuArray[i][point.y] == number) return false;
			if(sudocuArray[point.x][i] == number) return false;
		}
		int startX = (point.x / 3) * 3;
		int startY = (point.y / 3) * 3;
		for (int i = startX; i < startX+3; i++) {
			for (int j = startY; j < startY+3; j++) {
				if(sudocuArray[i][j] == number) return false;
			}
		}
		return true;
	}

}
