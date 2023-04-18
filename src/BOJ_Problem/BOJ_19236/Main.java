package BOJ_Problem.BOJ_19236;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//            7 6 2 3 15 6 9 8
//            3 1 1 8 14 7 10 1
//            6 1 13 6 4 3 11 4
//            16 1 8 7 5 2 12 2

//    ↑, ↖, ←, ↙, ↓, ↘, →, ↗

    static class Fish{
        int fishNum;
        Point point;
        int dict;

        public Fish(int fishNum, Point point, int dict) {
            this.fishNum = fishNum;
            this.point = point;
            this.dict = dict;
        }

        public Fish(int fishNum) {
            this.fishNum = fishNum;
        }
    }
    private static int[][] delta = {{},{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
    private static int[][] map;
    private static Fish[] fishArr = new Fish[17];
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        fishArr[0] = new Fish(0 );
        //물고기 입력
        for (int i = 0; i < 4; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 4; j++) {
                Fish fish = new Fish(Integer.parseInt(stringTokenizer.nextToken()),new Point(i,j),Integer.parseInt(stringTokenizer.nextToken()));
                map[i][j] = fish.fishNum;
                fishArr[fish.fishNum] = fish;
            }
        }
        fishArr[0].dict = fishArr[map[0][0]].dict;
        fishArr[0].point = new Point(0,0);
        fishArr[map[0][0]] = null;
        max = map[0][0];
        map[0][0] = 0;
        dfs(map.clone(),fishArr.clone());

        StringBuilder stringBuilder = new StringBuilder(max);
    }

    private static void dfs(int[][] map, Fish[] fishArr) {
        moveFish(map,fishArr);

        int nx = fishArr[0].point.x + delta[fishArr[0].dict][0];
        int ny = fishArr[0].point.y + delta[fishArr[0].dict][1];
        while(nx > 0 && nx < 4 && ny > 0 && ny < 4){
            if(map[nx][ny] != 0){
                Fish nowFish = fishArr[map[nx][ny]];
                fishArr[0].point = nowFish.point;
                fishArr[0].dict = nowFish.dict;
                fishArr[nowFish.fishNum] = null;

            }

        }

//        Fish nowFish = fishArr[map[x][y]];
//        fishArr[nowFish.fishNum] = null;
//        max = Math.max(max,max+nowFish.fishNum);
//        map[x][y] = -1;




    }

    private static void moveFish(int[][] map, Fish[] fishArr) {
        for(int i=0; i< 16; i++){
            if(fishArr == null) continue;
            Fish nowFish = fishArr[i];
            int nx = nowFish.point.x + delta[nowFish.dict][0];
            int ny = nowFish.point.y + delta[nowFish.dict][1];

            if(nx < 0 && nx > 4 && ny <0 && ny > 4 && nx == fishArr[0].point.x && ny == fishArr[0].point.y) continue;

            map[nowFish.point.x][nowFish.point.y] = map[nx][ny];
            map[nx][ny] = nowFish.fishNum;
        }

    }


}
