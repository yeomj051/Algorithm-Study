package Algorithm;

public class LinkedNode<T> {
    public T data;
    public LinkedNode<T>[] link;

    public LinkedNode(T data) {
        super();
        this.data = data;
    }

    public LinkedNode(T data, LinkedNode<T>[] link) {
        this.data = data;
        this.link = link;
    }
    
//    public void add(T node){
//        this.link[node.data].add(node);
//    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", link=" + link + "]";
    }

}

