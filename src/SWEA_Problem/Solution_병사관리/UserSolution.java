package SWEA_Problem.Solution_병사관리;

class UserSolution
{
    //단방향 linkedlist node 생성 id,version,next
    public class Node{
        int id;
        int versoin;
        Node next;

        public Node() {
        }

        public Node(int id, int versoin) {
            this.id = id;
            this.versoin = versoin;
            this.next = null;
        }

        public Node(int id, int versoin, Node next) {
            this.id = id;
            this.versoin = versoin;
            this.next = next;
        }
    }

    public class Team{
        Node[] head = new Node[6];
        Node[] tail = new Node[6];
    }

    public int[] version = new int[100001];
    public int[] teamNumber = new int[1000501];
    public Team[] TeamList = new Team[6];

    public Node getNewNode(int mID,Node next){
        Node newNode = new Node();
        newNode.id = mID;
        newNode.next= next;
        newNode.versoin = ++version[mID];

        return newNode;
    }

    public void init()
    {
        for (int i = 1; i <= 5; i++) {
            TeamList[i] = new Team();
            for (int j = 1; j <= 5; j++) {
                TeamList[i].tail[j] = TeamList[i].head[j] = getNewNode(0,null);
            }
        }
    }

    public void hire(int mID, int mTeam, int mScore)
    {
        Node newNode = getNewNode(mID,null);
        TeamList[mTeam].tail[mScore].next = newNode;
        TeamList[mTeam].tail[mScore] = newNode;
        teamNumber[mID] = mTeam;
    }

    public void fire(int mID)
    {
        version[mID] = -1;
    }

    public void updateSoldier(int mID, int mScore)
    {
        hire(mID,teamNumber[mID],mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore)
    {
        if(mChangeScore < 0){
            for (int i = 2; i < 6; i++) {
                int newScore = i + mChangeScore;
                newScore = newScore <= 1? 1:newScore;
                if(i == newScore) continue;;

                if(TeamList[mTeam].head[i].next == null) continue;
                TeamList[mTeam].tail[newScore].next = TeamList[mTeam].head[i].next;
                TeamList[mTeam].tail[newScore] = TeamList[mTeam].tail[i];
                TeamList[mTeam].head[i].next=null;
                TeamList[mTeam].tail[i] = TeamList[mTeam].head[i];
            }
        }
        if(mChangeScore > 0){
            for (int i = 4; i >= 1; i--) {
                int newScore = i + mChangeScore;
                newScore = newScore >= 5? 5:newScore;
                if(i == newScore) continue;

                if(TeamList[mTeam].head[i].next == null) continue;
                TeamList[mTeam].tail[newScore].next = TeamList[mTeam].head[i].next;
                TeamList[mTeam].tail[newScore] = TeamList[mTeam].tail[i];
                TeamList[mTeam].head[i].next=null;
                TeamList[mTeam].tail[i] = TeamList[mTeam].head[i];
            }
        }
    }

    public int bestSoldier(int mTeam)
    {
        for (int i = 5; i > 0; i--) {
            Node nowNode = TeamList[mTeam].head[i].next;
            if(nowNode == null) continue;
            int result =0;

            while(nowNode != null){
                if(nowNode.versoin == version[nowNode.id]){
                    result = result < nowNode.id? nowNode.id : result;
                }
                nowNode = nowNode.next;
            }
            if(result != 0) return result;
        }
        return 0;
    }
}
