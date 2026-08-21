import java.util.*;

class Solution {
    int answer = 0;
    int[] info;
    List<Integer>[] tree;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        tree = new ArrayList[info.length];
        
        for(int i = 0; i < info.length; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges){
            tree[edge[0]].add(edge[1]);
        }

        List<Integer> n = new ArrayList<>();
        n.add(0);

        dfs(0, 0, n);

        return answer;
    }
    void dfs(int sheep, int wolf, List<Integer> n) {

        for (int node : n) {

            int nSheep = sheep;
            int nWolf = wolf;

            if (info[node] == 0) {
                nSheep++;
            } else {
                nWolf++;
            }

            if (nWolf >= nSheep) {
                continue;
            }

            answer = Math.max(answer, nSheep);

            List<Integer> nNext = new ArrayList<>(n);
            nNext.remove(Integer.valueOf(node));
            nNext.addAll(tree[node]);

            dfs(nSheep, nWolf, nNext);
        }
    }
}