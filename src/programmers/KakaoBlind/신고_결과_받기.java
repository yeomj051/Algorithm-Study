package programmers.KakaoBlind;

import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 신고_결과_받기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;		
		
        int[] answer = new int[id_list.length];
        
        boolean[][] reportArr = new boolean[id_list.length][];
        
        for(int i=0; i < id_list.length; i++){
            reportArr[i] = new boolean[id_list.length];
        }
        
        for(int i=0; i < report.length; i++){
            StringTokenizer string = new StringTokenizer(report[i]);
            String reportArrMan = string.nextToken();
            String reportArredMan = string.nextToken();
            
            reportArr[Arrays.asList(id_list).indexOf(reportArredMan)][Arrays.asList(id_list).indexOf(reportArrMan)] = true;
        }
        
        
        
        for(int i=0; i < id_list.length; i++){
        	for (int j = 0; j < reportArr.length; j++) {
        		System.out.println(reportArr[i][j]);
        		 
			}
            if(Collections.frequency(Arrays.asList(reportArr[i]), true) >= k){
                for(int j=0; j < id_list.length ; j++){
                    answer[j]++;
                }
            }
        }
        
        for (int i = 0; i < reportArr.length; i++) {
        	System.out.println(answer[i]);
		}
        
        
//        return answer;
    }
}

