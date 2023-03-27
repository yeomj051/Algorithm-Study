package Algorithm;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MainCNC {
    private static int M;   //가로
    private static int N;   //세로
    private static char[][] map;
    private static int[][] delta = {{1, 0}, {0, 1}, {1, -1}, {1, 1}}; //하 우 하좌 하우
    private static int result;
//    입력
//    5 5
//    OXXXO
//    XOXXX
//    XXOXX
//    XXXOX
//    XXOXX
//    출력
//    7


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String string = bufferedReader.readLine();
            map[i] = string.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'O') {
                    Point point = new Point(i, j);
                    dfs(point);
                }
            }
        }

        System.out.println(result);
    }

    private static void dfs(Point nowPoint) {
        for (int i = 0; i < 4; i++) {
            Point nextPoint = new Point(nowPoint.x + delta[i][0], nowPoint.y + delta[i][1]);
            while (nextPoint.x >= 0 && nextPoint.y >= 0 && nextPoint.x < N && nextPoint.y < M) {
                if (map[nextPoint.x][nextPoint.y] == 'O') {
                    result++;
                    break;
                }
                ;
                nextPoint = new Point(nextPoint.x + delta[i][0], nextPoint.y + delta[i][1]);
            }

        }


    }
}

