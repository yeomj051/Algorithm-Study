package BOJ_Problem.BOJ_17478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int number = Integer.parseInt(bufferedReader.readLine());

    stringBuilder.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

    answer(0,number,stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void answer(int count, int number, StringBuilder stringBuilder){
        StringBuilder underBar = new StringBuilder();
        for (int i = 0; i < count; i++) {
            underBar.append("____");
        }
        if(count == number){
            stringBuilder.append(underBar).append("\"재귀함수가 뭔가요?\"\n");
            stringBuilder.append(underBar).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            stringBuilder.append(underBar).append("라고 답변하였지.\n");
            return;
        }

        stringBuilder.append(underBar).append("\"재귀함수가 뭔가요?\"\n");
        stringBuilder.append(underBar)
                .append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
                .append(underBar)
                .append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
                .append(underBar)
                .append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        answer(count+1,number,stringBuilder);
        stringBuilder.append(underBar).append("라고 답변하였지.\n");
    }

}
