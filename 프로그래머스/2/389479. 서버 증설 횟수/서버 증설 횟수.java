import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int time = 0; time < 24; time++) {
            while (!pq.isEmpty() && pq.peek() <= time) {
                pq.poll();
            }
            int need = players[time] / m;
            while (pq.size() < need) {
                pq.offer(time + k);
                answer++;
            }
        }

        return answer;
    }
}