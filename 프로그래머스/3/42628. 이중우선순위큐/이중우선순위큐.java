import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");

            String command = parts[0];
            int value = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                q.offer(value);
                continue;
            }

            if (q.isEmpty()) {
                continue;
            }

            if (value == -1) {
                q.poll();
            } else {
                int maxValue = Collections.max(q);
                q.remove(maxValue);
            }
        }

        if (q.isEmpty()) {
            return new int[]{0, 0};
        }

        int minValue = q.peek();
        int maxValue = Collections.max(q);

        return new int[]{maxValue, minValue};
    }
}