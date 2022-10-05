package BOJ_Problem.BOJ_1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	//	1 7			//행 열
	//	f0.F..1		//map
	private static int rowSize;
	private static int colSize;
	private static char[][] originMap;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		
		rowSize = Integer.parseInt(stringTokenizer.nextToken());
		colSize = Integer.parseInt(stringTokenizer.nextToken());
		
		originMap = new char[rowSize][colSize];
		for (int i = 0; i < rowSize; i++) {
			String string = bufferedReader.readLine();
			for (int j = 0; j < colSize; j++) {
				originMap[i][j] = string.charAt(j);
			}
		}

		//Map 출력
//		for (int i = 0; i < rowSize; i++) {
//			for (int j = 0; j < colSize; j++) {
//				System.out.print(originMap[i][j]);
//			}
//			System.out.println();
//		}
		
		if('a' == ('A'|' '))	System.out.println("true");
		else System.out.println("false");

	}

}
