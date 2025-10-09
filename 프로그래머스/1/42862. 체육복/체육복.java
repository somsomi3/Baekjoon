import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        boolean[] has = new boolean[n + 1];
        Arrays.fill(has, true);
        for (int i : lost) has[i] = false;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        List<Integer> actualReserve = new ArrayList<>();
        for (int r : reserve) {
            if (!has[r]) {
                has[r] = true; // 본인 입음
            } else {
                actualReserve.add(r); // 진짜 여분만 남김
            }
        }

        for (int r : actualReserve) {
            if (r - 1 >= 1 && !has[r - 1]) {
                has[r - 1] = true;
            } else if (r + 1 <= n && !has[r + 1]) {
                has[r + 1] = true;
            }
        }


        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (has[i]) count++;
        }

        return count;
    }
}
