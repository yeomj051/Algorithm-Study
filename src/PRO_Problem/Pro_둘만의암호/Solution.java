package PRO_Problem.Pro_둘만의암호;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public class Light implements Comparable<Light>{
        int number;
        int linkedCount;
        LinkedList<Integer> list;

        public Light(int number){
            this.number = number;
            this.linkedCount = 0;
            this.list = new LinkedList<Integer>();
        }

        public void addLinked(int number){
            this.linkedCount++;
            this.list.add(number);
        }

        @Override
        public int compareTo(Light o)
        {
            return this.linkedCount - o.linkedCount;
        }
    }

    public int solution(int n, int[][] lighthouse) {
        int answer = 0;

        Light[] lightList = new Light[n+1];

        for(int i=0; i<lighthouse.length;i++ ){
            int number1 = lighthouse[i][0];
            int number2 = lighthouse[i][1];

            if(lightList[number1] == null){
                lightList[number1] = new Light(number1);
            }
            lightList[number1].addLinked(number2);

            if(lightList[number2] == null){
                lightList[number2] = new Light(number2);
            }
            lightList[number2].addLinked(number1);
        }


        Arrays.sort(lightList);

        System.out.println(lightList[2].number);

        return answer;
    }


}
