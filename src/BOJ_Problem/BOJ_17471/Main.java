package BOJ_Problem.BOJ_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//	6				//구역 수
//	5 2 3 4 1 2		//구역별 인구 수
//	2 2 4			//구역별 인접 구역
//	4 1 3 6 5
//	2 4 2
//	2 1 3
//	1 2
//	1 2

	private static class Area{
		int people;									//인구 수
		List<Integer> adjAreas = new ArrayList<>();	//인접 구역
		
		public Area(int people) {
			super();
			this.people = people;
		}

		public String toString(int i) {
			return "Area"+i+" [people=" + people + ", adjAreas=" + adjAreas + "]";
		}

	}
	
	private static int areaQuantity;
	private static Area[] areaArray;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//구역 개수
		areaQuantity = Integer.parseInt(bufferedReader.readLine());
		
		//구역 배열 생성
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		areaArray = new Area[areaQuantity+1];
		for (int i = 1; i <= areaQuantity; i++) {
			areaArray[i] = new Area(Integer.parseInt(stringTokenizer.nextToken()));
		}
		
		//구역 별 인접 구역 입력
		for (int i = 1; i <= areaQuantity; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			//인접 구역 개수
			int adjQuantity= Integer.parseInt(stringTokenizer.nextToken());
			
			//인접 구역 입력
			for (int j = 0; j < adjQuantity; j++) {
				int adjArea = Integer.parseInt(stringTokenizer.nextToken());
				areaArray[i].adjAreas.add(adjArea);
			}
		}
		
		//출력
		for (int i = 1; i <= areaQuantity; i++) {
			if(areaArray[i].adjAreas == null )	continue;
			System.out.println(areaArray[i].toString(i));
		}
		
		List<int[]> combiList = new ArrayList<>();
		
		//count visited
		getCombi(0, 1,new boolean[areaQuantity+1], combiList);

		//출력
//		for (int i = 0; i < combiList.size(); i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(combiList.get(i)[j] + " ");
//			}
//			System.out.println();
//		}
		
		for (int[] combi : combiList) {
			baekBFS(combi);
		}
		
		
		
	}

	private static void baekBFS(int[] combi) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[areaQuantity+1];
		
		
		
	}

	private static void getCombi(int count,int start, boolean[] visited, List<int[]> combiList) {
		
		if(count == 2) {
			int idx = 0;
			int[] combi = new int[2];
			for (int i = 1; i <= areaQuantity; i++) {
				if(visited[i]) {
					combi[idx] = i;
					idx++;
				}
			}
			combiList.add(combi);
		}
		
		for (int i = start; i <= areaQuantity; i++) {
			visited[i] = true;
			getCombi(count+1, i+1, visited, combiList);
			visited[i] = false;
		}
	}


}
