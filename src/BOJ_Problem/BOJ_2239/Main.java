package BOJ_Problem.BOJ_2239;

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

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < 9; j++) {
				sudocuArray[i][j] = string.charAt(j) - '0';
			}
		}
		
		//출력
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				System.out.print(sudocuArray[i][j]);
//			}
//			System.out.println();
//		}
		
		
	}

}
