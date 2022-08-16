package BOJ_Problem.BOJ_2164;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> cardQ = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            cardQ.add(i+1);
        }

        while (cardQ.size() > 1){
            cardQ.poll();
            int temp = cardQ.poll();
            cardQ.add(temp);
        }

        System.out.println(cardQ.poll());
    }
}
