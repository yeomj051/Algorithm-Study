package PRO_Problem.Pro_이모티콘할인행사;
public class Solution {

    int[] sales;
    int[] answer;

    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        sales = new int[emoticons.length];

        dfs(users, emoticons, 0);

        return answer;
    }

    public void dfs(int[][] users, int[] emoticons, int count){
        if(count == emoticons.length){
            int member = 0;
            int totalPrice = 0;

            for(int j=0; j < users.length; j++){
                double price = 0;

                for(int i=0; i< emoticons.length; i++){
                    if(users[j][0] <= sales[i]){
                        price += getprice(sales[i], emoticons[i]);
                    }
                }

                if((int)price >= users[j][1]){member++;}
                else {totalPrice += price;}
            }

            if(member > answer[0]){
                answer[0] = member;
                answer[1] = totalPrice;
            }else if(member == answer[0]){
                answer[1] = Math.max(answer[1], totalPrice);
            }

            return;
        }

        for(int j=4; j>0; j--){
            sales[count] = j*10;
            dfs(users, emoticons, count+1);
        }

    }

    public double getprice(int sale, int emoticon){
        double result = (double)emoticon * ((100 - (double)sale)/100);
        return result;
    }
}
