package BOJ_Problem.BOJ_15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
//	8 30 4 30		//접시개수 / 초밥종류 개수 / 연속해서 먹는 접시의 수 / 쿠폰 번호
//	7				//접시 정보
//	9
//	7
//	30
//	2
//	7
//	9
//	25
	
	private static int dishQuantity;
	private static int shushiQuantity;
	private static int sequenceDish;
	private static int coupon;
	private static int maxDish = Integer.MIN_VALUE;
	private static LinkedList<Integer> dishList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		dishQuantity = Integer.parseInt(stringTokenizer.nextToken());
		shushiQuantity = Integer.parseInt(stringTokenizer.nextToken());
		sequenceDish = Integer.parseInt(stringTokenizer.nextToken());
		coupon = Integer.parseInt(stringTokenizer.nextToken());
		
		dishList = new LinkedList<Integer>();
		for (int i = 0; i < dishQuantity; i++) {
			dishList.add(Integer.parseInt(bufferedReader.readLine()));
		}
		
		//연속해서 먹는 접시 개수만큼 추가 
		for (int i = 0; i < sequenceDish; i++) {
			dishList.add(dishList.get(i));
		}
		
		
		for (int i = 0; i < dishQuantity; i++) {
			Deque<Integer> list = new LinkedList<>();
			int count = 0;
			
			for (int j = 0; j < sequenceDish; j++) {
				int nowdish = dishList.get(i);
				if(list.contains(nowdish)) break;
				list.add(nowdish);
				dishList.remove(i);
				count++;
			}
			
			if(!list.contains(coupon)) count++;
			if(count > maxDish) maxDish = count;
			
			while(!list.isEmpty()) {
				dishList.add(i, list.pollLast());
			}
		}
		
		System.out.println(maxDish);
		
	}

}
