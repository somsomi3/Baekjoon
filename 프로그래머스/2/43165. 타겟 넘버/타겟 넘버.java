class Solution {
    static int cnt = 0;
    
    public int solution(int[] arr, int t) {
        dfs(arr, t, 0, 0);
        return cnt;
    }
    
    static void dfs(int[] arr, int t, int idx, int sum) {
        if (idx == arr.length) {
            if (sum == t) cnt++;
            return;
        }
        
        dfs(arr, t, idx + 1, sum + arr[idx]);
        dfs(arr, t, idx + 1, sum - arr[idx]);
    }
}