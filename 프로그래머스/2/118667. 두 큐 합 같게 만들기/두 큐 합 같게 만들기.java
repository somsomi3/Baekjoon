import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int a : queue1) {
            q1.offer(a);
            sum1 += a;
        }
        for (int a : queue2) {
            q2.offer(a);
            sum2 += a;
        }

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        int ans = 0;
        int end = (queue1.length + queue2.length) * 2;

        while (sum1 != sum2) {
            if (ans >= end) {
                return -1;
            }

            if (sum1 > sum2) {
                int x = q1.poll();
                q2.offer(x);
                sum1 -= x;
                sum2 += x;
            } else {
                int x = q2.poll();
                q1.offer(x);
                sum2 -= x;
                sum1 += x;
            }
            ans++;
        }
        return ans;
    }
}