package BOJ_Problem.BOJ_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(bufferedReader.readLine());
		
		System.out.println(calculation(number));

	}
	
	private static int calculation(int number) {
		
		if(number == 1 ) return 0;
		if(number == 2 || number == 3) return 1;
		
		int[] array = new int[number+1];
		Arrays.fill(array, Integer.MAX_VALUE);
		
		for (int i = 1; i < 4; i++) {
			array[i] = 1;
		}
		
		for (int i = 4; i < array.length; i++) {
			if(i%3 == 0) array[i] = 1 + array[i/3];
			
			if(i%2 == 0 && array[i] > 1 + array[i/2]) array[i] = 1 + array[i/2];
			
			if(array[i] > 1 + array[i-1] ) array[i] = 1 + array[i-1];
		}

		return array[number];
	}

}
