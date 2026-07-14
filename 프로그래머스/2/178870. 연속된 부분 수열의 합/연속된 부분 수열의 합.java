import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int left = 0;
        int right = 0;
        int sum = sequence[0];

        int bestL = 0;
        int bestR = sequence.length - 1;
        int minLen = Integer.MAX_VALUE;

        while (right < sequence.length) {

            if (sum < k) {
                right++;
                if (right == sequence.length) break;
                sum += sequence[right];
            }
            else if (sum > k) {
                sum -= sequence[left];
                left++;
            }
            else {

                if (right - left < minLen) {
                    minLen = right - left;
                    bestL = left;
                    bestR = right;
                }

                sum -= sequence[left];
                left++;
            }
        }

        return new int[]{bestL, bestR};
    }
}