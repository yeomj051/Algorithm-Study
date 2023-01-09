package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int count = Integer.parseInt(stringTokenizer.nextToken());

            char[] charArr = stringTokenizer.nextToken().toCharArray();

            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < charArr.length; j++) {
                for (int k = 0; k < count; k++) {
                    stringBuilder.append(charArr[j]);
                }
            }

            System.out.println(stringBuilder);
        }
    }

}
