package PRO_Problem.Pro_둘만의암호;

import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] alphaArr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] skipArr = skip.toCharArray();
        int[] arr = {4,3,5,2,6};

        Arrays.sort(skipArr);


        for(int i=0; i<skipArr.length; i++){
            System.out.println(skipArr[i]);
        }

        return answer;
    }
}
