package BOJ_Problem.BOJ_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));

		
		//스위치 개수
		int switchNum = Integer.parseInt(in.readLine());
		//스위치 배열
		int[] switchArr = new int[switchNum];
		StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
		for (int i = 0; i < switchNum; i++) {
			switchArr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		//학생 수
		int studentNum = Integer.parseInt(in.readLine());

		for (int i = 0; i < studentNum; i++) {
			//학생 정보
			String [] student = in.readLine().split(" ");
			//학생 정보 숫자로 전환
			int [] studentNumArr = new int[2];
			for (int j = 0; j < 2; j++) {
				studentNumArr[j] = Integer.parseInt(student[j]);
			}

			//남학생일 경우
			if (studentNumArr[0] == 1) {
				for (int j = (studentNumArr[1]-1); j < switchNum; j = j+studentNumArr[1]) {
					if (switchArr[j] == 1) {
						switchArr[j] = 0;
					}else {
						switchArr[j] = 1;
					}
				}
			}

			//여학생일 경우
			else if (studentNumArr[0] == 2) {
				int girlsNumber = studentNumArr[1]-1;
				int j=0;
				//학생의 번호 부터 양쪽 값이 같을 때까지 반복
				while(girlsNumber+(j+1)<switchNum && girlsNumber-(j+1) >=0 && switchArr[girlsNumber-(j+1)] == switchArr[girlsNumber+(j+1)]) {
					j++;
				}
				for (int k = girlsNumber-j; k <= girlsNumber+j; k++) {
					if (switchArr[k]== 1) {
						switchArr[k] = 0;
					}else {
						switchArr[k] = 1;
					}
				}
			}
		}


		for (int i = 0; i < switchNum; i++) {
			System.out.print(switchArr[i]+" ");
			if ((i+1)%20 == 0) {
				System.out.println();
			}
		}

		
	}

}
