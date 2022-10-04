package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int nodeCount;   //노드의 개수
    private LinkedList<Integer> nodeList[]; //인접 리스트

    public BFS(int nodeCount) {
        this.nodeCount = nodeCount;
        this.nodeList = new LinkedList[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            nodeList[i] = new LinkedList<>();
        }
    }

    void add(int index1, int index2){
        nodeList[index1].add(index2);
    }

    public void BFS_Breadth_First_Search(){
        // 큐 생성 = queue;
        Queue<Integer> queue = new LinkedList<Integer>();
        // 방문체크 배열 생성
        boolean[] visited = new boolean[nodeCount];

        // 루트노드 방문체크 후 큐에 queue.offer;
        visited[0] = true;
        queue.offer(0);

        while(!queue.isEmpty()){
            // 큐의 첫 번째 원소 반환
            int nowNode = queue.poll();
            System.out.print(nowNode + " ");

            // 인접 리스트 개수 만큼 반복문
            for (int i = 0; i < nodeList[nowNode].size(); i++) {
                // 인접 리스트 변수 생성
                int adjNode = nodeList[nowNode].get(i);
                // 방문 하지 않았으면 방문 체크 후 queue에 삽입
                if (!visited[adjNode]){
                    visited[adjNode] = true;
                    queue.offer(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS graph = new BFS(9);

        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(0, 3);
        graph.add(1, 4);
        graph.add(1, 5);
        graph.add(3, 6);
        graph.add(3, 7);
        graph.add(3, 8);

        graph.BFS_Breadth_First_Search();

    }
}
