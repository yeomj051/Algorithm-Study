package SWEA_Problem.Solution_병사관리;// author: 류호석(rhs0266)

class 병사_관리 {
    public class Node {
        int id;
        int v;
        Node nxt;

        Node() {}

        Node(int id, int v) {
            this.id = id;
            this.v = v;
            this.nxt = null;
        }

        Node(int id, int v, Node nxt) {
            this.id = id;
            this.v = v;
            this.nxt = nxt;
        }
    }

    public Node[] node = new Node[200055];
    public int cnt = 0;
    public int[] version = new int[100055];
    public int[] num = new int[100055];

    public Node getNewNode(int id, Node nxt) {
        Node ret = node[cnt++];
        ret.id = id;
        ret.nxt = nxt;
        ret.v = ++version[id];
        return ret;
    }

    public class Team {
        Node[] head = new Node[6];
        Node[] tail = new Node[6];
    }

    public Team[] t = new Team[6];

    public void init() {
        cnt = 0;
        for (int i = 0; i < 200055; i++) {
            if (node[i] == null) node[i] = new Node();
        }
        for (int i = 1; i <= 5; i++) {
            t[i] = new Team();
            for (int j = 1; j <= 5; j++) {
                t[i].tail[j] = t[i].head[j] = getNewNode(0, null);
            }
        }

        for (int i = 0; i <= 100000; i++) {
            version[i] = 0;
            num[i] = 0;
        }
    }

    public void hire(int mID, int mTeam, int mScore) {
        Node newNode = getNewNode(mID, null);
        t[mTeam].tail[mScore].nxt = newNode;
        t[mTeam].tail[mScore] = newNode;
        num[mID] = mTeam;
    }

    public void fire(int mID) {
        version[mID] = -1;
    }

    public void updateSoldier(int mID, int mScore) {
        hire(mID, num[mID], mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        if (mChangeScore < 0) {
            for (int j = 1; j <= 5; j++) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (t[mTeam].head[j].nxt == null) continue;
                t[mTeam].tail[k].nxt = t[mTeam].head[j].nxt;
                t[mTeam].tail[k] = t[mTeam].tail[j];
                t[mTeam].head[j].nxt = null;
                t[mTeam].tail[j] = t[mTeam].head[j];
            }
        }
        if (mChangeScore > 0) {
            for (int j = 5; j >= 1; j--) {
                int k = j + mChangeScore;
                k = k < 1 ? 1 : (k > 5 ? 5 : k);
                if (j == k) continue;

                if (t[mTeam].head[j].nxt == null) continue;
                t[mTeam].tail[k].nxt = t[mTeam].head[j].nxt;
                t[mTeam].tail[k] = t[mTeam].tail[j];
                t[mTeam].head[j].nxt = null;
                t[mTeam].tail[j] = t[mTeam].head[j];
            }
        }
    }

    public int bestSoldier(int mTeam) {
        for (int j = 5; j >= 1; j--) {
            Node node = t[mTeam].head[j].nxt;
            if (node == null) continue;

            int ans = 0;
            while (node != null) {
                if (node.v == version[node.id]) {
                    ans = ans < node.id ? node.id : ans;
                }
                node = node.nxt;
            }
            if (ans != 0) return ans;
        }
        return 0;
    }
}