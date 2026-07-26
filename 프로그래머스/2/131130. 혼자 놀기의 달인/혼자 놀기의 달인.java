import java.util.*;

class Solution {
    boolean[] visited;
    int[] cards;

    public int solution(int[] cards) {
        this.cards = cards;
        visited = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                list.add(dfs(i));
            }
        }

        if (list.size() < 2) return 0;
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0) * list.get(1);
    }

    public int dfs(int now) {
        visited[now] = true;
        int cnt = 1;

        int next = cards[now] - 1;
        if (!visited[next]) {
            cnt += dfs(next);
        }
        return cnt;
    }
}