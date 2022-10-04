package Algorithm;

public class Graph<T> {
    public T data;
    //인접 리스트
    public LinkedNode<T> nodeList;

    public Graph(T data) {
        this.data = data;
    }

    public Graph(T data, LinkedNode<T> nodeList) {
        this.data = data;
        this.nodeList = nodeList;
    }

    @Override
    public String toString() {
        return "Graph{" + "data=" + data + ", nodeList=" + nodeList + '}';
    }
}
