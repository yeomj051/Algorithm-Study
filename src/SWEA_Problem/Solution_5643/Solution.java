package SWEA_Problem.Solution_5643;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

//	1		//test case
//	6		//사람 수
//	6		//비교 횟수
//	1 5
//	3 4
//	5 4
//	4 2
//	4 6
//	5 2
	
	private static int manQuantity;
	private static int compareCount;
	private static Man[] manArray;
	
	private static class Man{
		List<Integer> smallerMan = new ArrayList<>();
		List<Integer> biggerMan = new ArrayList<>();

		public String toString(int i) {
			return "Man" +i+" [smallerMan=" + smallerMan + ", biggerMan=" + biggerMan + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/sample_input(5643).txt"));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			manQuantity = Integer.parseInt(bufferedReader.readLine()); 
			compareCount = Integer.parseInt(bufferedReader.readLine());

			manArray = new Man[manQuantity+1];
			for (int i = 1; i <= manQuantity; i++) {
		 		manArray[i] = new Man();
			}
			
			for (int i = 0; i < compareCount; i++) {
				StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				int man1 = Integer.parseInt(stringTokenizer.nextToken());
				int man2 = Integer.parseInt(stringTokenizer.nextToken());
				
				manArray[man1].biggerMan.add(man2);
				manArray[man2].smallerMan.add(man1);
				
			}
			int count  = 0;
			//출력
//			for (int i = 1; i <= manQuantity; i++) {
//				System.out.println(manArray[i].toString(i));
//			}
			
			//순서 찾을 수 있는지 찾기
			for (int i = 1; i <= manQuantity; i++) {
				if(searchPriority(i)) {
					count++;
				}
			}
			
			//결과 출력
			StringBuilder stringBuilder = new StringBuilder("#").append(test_case).append(" ").append(count);
			System.out.println(stringBuilder);
		}

	}

	private static boolean searchPriority(int serchMan) {
		Queue<Man> queue = new LinkedList<>();
		boolean[] visited = new boolean[manQuantity+1];
		
		queue.offer(manArray[serchMan]);
		visited[serchMan]=true;
		
		smallerCheck(visited, queue);
		
		queue.offer(manArray[serchMan]);
		biggerCheck(visited, queue);
		
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}

	private static void smallerCheck(boolean[] visited, Queue<Man> queue) {
		while(queue.size() != 0) {
			Man nowMan = queue.poll();
			
			for (int i = 0; i < nowMan.smallerMan.size(); i++) {
				int comparedMan = nowMan.smallerMan.get(i);
				if(visited[comparedMan]) continue;
				
				visited[comparedMan] = true;
				queue.offer(manArray[comparedMan]);
			}
		}
		
	}

	private static void biggerCheck(boolean[] visited, Queue<Man> queue) {
		while(queue.size() != 0) {
			Man nowMan = queue.poll();
			
			for (int i = 0; i < nowMan.biggerMan.size(); i++) {
				int comparedMan = nowMan.biggerMan.get(i);
				if(visited[comparedMan]) continue;
				
				visited[comparedMan] = true;
				queue.offer(manArray[comparedMan]);
			}
		}
	}

}
