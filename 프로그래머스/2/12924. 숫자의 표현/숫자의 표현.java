class Solution {
    public int solution(int n) {
        int sum = 1;
        int cnt = 0;

        int start = 1;
        int end = 1;
        while (start <= n) {
            if (sum == n) {
                cnt++;
                sum -= start;
                start++;
            } else if (sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        return cnt;
    }
}