package BOJ_Problem.BOJ_1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

//	5				숫자 개수
//	2 0 1 4 3		순열
	private static int numQuantity;
	private static int[] numArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		numQuantity = Integer.parseInt(bufferedReader.readLine());
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		numArr = new int[numQuantity];
		for (int i = 0; i < numQuantity; i++) {
			numArr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		permutate(0,new int[numQuantity], new boolean[numQuantity]);
		
	}

	private static void permutate(int count, int[] numArray, boolean[] visited) {
		if(count == numQuantity) {
			
			for (int i = 0; i < numQuantity; i++) {
				System.out.print(numArray[i] + " ");
			}
			System.out.println();
//			getChild(numArray);
			return;
		}
		
		for (int i = 0; i < numQuantity; i++) {
			if(visited[i]) continue;
			
			numArray[count] = i;
			visited[i] = true;
			permutate(count+1, numArray, visited);
			visited[i] = false;
		}
		
	}

	private static void getChild(int[] numArray) {
		int[] BArray = new int[numQuantity];
		BArray[0] =0;
		for (int i = 1; i < numQuantity; i++) {
			BArray[i] = numArray[BArray[i-1]];
		}
		
		
		
	}

}
