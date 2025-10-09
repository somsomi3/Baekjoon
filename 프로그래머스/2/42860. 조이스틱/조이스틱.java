import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        // 알파벳 위아래 최소 이동
        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        // 좌우 이동 최소값
        int move = len - 1;
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') next++;
            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }

        return answer + move;
    }
}
