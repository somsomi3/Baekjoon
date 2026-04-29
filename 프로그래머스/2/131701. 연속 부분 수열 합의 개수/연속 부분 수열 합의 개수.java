import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        
        int[] arr = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            arr[i] = elements[i % n];
        }
        
        Set<Integer> sum = new HashSet<>();
        
        for (int start = 0; start < n; start++) {
            int cur = 0;
            for (int len = 1; len <= n; len++) {
                cur += arr[start + len - 1];
                sum.add(cur);
            }
        }  
        return sum.size();
    }
}