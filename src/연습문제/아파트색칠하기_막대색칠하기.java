package 연습문제;

import java.awt.Paint;

public class 아파트색칠하기_막대색칠하기 {

	public static void main(String[] args) {
		
		//아파트 색칠하기
		System.out.println(paintApt(8));
		
		//
	}
	
	private static int paintApt(int n) {
		
		if(n == 1) return 2;
		
		if(n == 2) return 3;
		
		int[] array = new int[n];
		array[0] = 2;
		array[1] = 3;
		
		for (int i = 2; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				array[i] += array[j]; 
			}
		}
		
		return array[n-1];
	}
	


}
