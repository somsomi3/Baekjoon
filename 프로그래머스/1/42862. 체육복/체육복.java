import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        boolean[] used = new boolean[reserve.length];

        int answer = n - lost.length;

        for (int i = 0; i < lost.length; i++) {

            int student = lost[i];

            for (int j = 0; j < reserve.length; j++) {

                if (used[j]) continue;

                if (reserve[j] == student) {
                    used[j] = true;
                    answer++;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {

            int student = lost[i];

            boolean alreadyHas = false;

            for (int j = 0; j < reserve.length; j++) {
                if (used[j] && reserve[j] == student) {
                    alreadyHas = true;
                    break;
                }
            }

            if (alreadyHas) continue;

            for (int j = 0; j < reserve.length; j++) {

                if (used[j]) continue;

                if (reserve[j] == student - 1 ||
                    reserve[j] == student + 1) {

                    used[j] = true;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}