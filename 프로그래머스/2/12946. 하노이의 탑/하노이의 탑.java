import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        ha(n, 1, 2, 3);

        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    public void ha(int n, int from, int via, int to) {
        if (n == 1) {
            list.add(new int[]{from, to});
            return;
        }
        ha(n - 1, from, to, via);
        list.add(new int[]{from, to});
        ha(n - 1, via, from, to);
    }
}