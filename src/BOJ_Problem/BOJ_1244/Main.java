package BOJ_Problem.BOJ_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
		
		//스위치 개수
		int switchNum = Integer.parseInt(in.readLine());
		//스위치 배열
		String [] switchArr = in.readLine().split(" ");
		
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
			
			if (studentNumArr[0] == 1) {
				for (int j = (studentNumArr[1]-1); j < switchNum; j = j+studentNumArr[1]) {
					if (switchArr[j].equals("1")) {
						switchArr[j] = "0";
					}else {
						switchArr[j] = "1";
					}
				}
			}
			else if (studentNumArr[0] == 2) {
				if (switchArr[studentNumArr[1]-2].equals(switchArr[studentNumArr[1]])) {
					int max =0;
					int count0 =0;
					int count1 =0;
					int changeIndex = 0;
					
					for (int j = 0; j < switchNum; j++) {
						if (switchArr[j].equals("0")) {
							if (max <count0) {
								changeIndex = j-count0;
								max = count0;
								
							}
							count0 =0;
						}else {
							count0++;
						}
						if (switchArr[j].equals("1")) {
							if (max <count1) {
								changeIndex = j-count1;
								max = count1;
								
							}
							count1 =0;
						}else {
							count1++;
						}
					}
					for (int j = changeIndex-1; (j <= (changeIndex+max))&&j<switchNum; j++) {
						if (switchArr[j].equals("1")) {
							switchArr[j] = "0";
						}else {
							switchArr[j] = "1";
						}
					}
					
				}else {
					if (switchArr[studentNumArr[1]-1].equals("1")) {
						switchArr[studentNumArr[1]-1] = "0";
					}else {
						switchArr[studentNumArr[1]-1] = "1";
					}
				}
			}
		}
		
		for (int i = 0; i < switchNum; i++) {
			System.out.print(switchArr[i] + " ");
		}
		
	}

}
