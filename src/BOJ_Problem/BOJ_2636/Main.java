package BOJ_Problem.BOJ_2636;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     13 12
     0 0 0 0 0 0 0 0 0 0 0 0
     0 0 0 0 0 0 0 0 0 0 0 0
     0 0 0 0 0 0 0 1 1 0 0 0
     0 1 1 1 0 0 0 1 1 0 0 0
     0 1 1 1 1 1 1 0 0 0 0 0
     0 1 1 1 1 1 0 1 1 0 0 0
     0 1 1 1 1 0 0 1 1 0 0 0
     0 0 1 1 0 0 0 1 1 0 0 0
     0 0 1 1 1 1 1 1 1 0 0 0
     0 0 1 1 1 1 1 1 1 0 0 0
     0 0 1 1 1 1 1 1 1 0 0 0
     0 0 1 1 1 1 1 1 1 0 0 0
     0 0 0 0 0 0 0 0 0 0 0 0
     */
    //상 하 좌 우
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int rowSize;
    private static int colSize;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        //행 열
        rowSize = Integer.parseInt(stringTokenizer.nextToken());
        colSize = Integer.parseInt(stringTokenizer.nextToken());

        // 치즈 입력
        map = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < colSize; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int time = 0;
        int cheese = countCheese();
        while (true){
            time++;
            getMeltingCheese();
            meltCheese();
            int cheeseCount = countCheese();
            if(cheeseCount == 0) break;
            cheese = cheeseCount;

        }

        System.out.println(time);
        System.out.println(cheese);

    }

    private static void meltCheese() {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if(map[i][j] == 2 ) map[i][j] = 0;
            }
        }
    }

    private static int countCheese() {
        int count =0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if(map[i][j] == 1 ) count++;
            }
        }
        return count;
    }

    private static void getMeltingCheese() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowSize][colSize];

        queue.offer(new Point(0,0));
        visited[0][0] = true;
        while (!queue.isEmpty()){
            Point nowPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = nowPoint.x + dx[i];
                int ny = nowPoint.y + dy[i];

                if(nx<0 || nx==rowSize || ny<0 || ny==colSize || visited[nx][ny]) continue;
                if(map[nx][ny] == 1 || map[nx][ny] == 2){
                    map[nx][ny] = 2;
                }else {
                    queue.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                }

            }
        }
    }
}
