package programmers.KakaoBlind;

import java.util.ArrayList;
import java.util.List;

public class k진수에서_소수_갯수_구하기 {

	public static void main(String[] args) {
		solution(437674, 3);
	}
	
	public static int solution(int n, int k) {
        int answer = 0;
        List<Integer> convertNum = convertKbinary(n, k);
 
        int j = 0;
        for (int i = convertNum.size() - 1; i >= 0; i = j) {
            for (j = i - 1; j >= 0 && convertNum.get(j) != 0; j--) ;
            if (isPrime(convertNum.subList(j, i)))
                answer++;
        }
        return answer;
    }
    
    private static boolean isPrime(List convertNum) {
    	
    	int num = (int) convertNum.get(convertNum.size()-1);
    	int count = 10;
    	for (int i = convertNum.size()-2; i <= 0; i--) {
			num += i*count;
			count *= 10;
		}
    	
        if (num <= 1) return false;
 
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
 
    private static List convertKbinary(int n, int k) {
        List<Integer> convertArr = new ArrayList<>();
        
        StringBuilder str = new StringBuilder();
 
        while (n > 0) {
        	convertArr.add(n % k);
            n /= k;
        }
 
        return convertArr;
    }
}
