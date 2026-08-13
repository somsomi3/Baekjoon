import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if(s<n)return new int[]{-1};
        
        int[] answer = new int[n];
        
        int base = s/n;
        int next = s%n;
        
        for (int i = 0; i < n; i++) {
            answer[i] = base;
        }
        
        for (int i = n - next; i < n; i++) {
            answer[i]++;
        }

        return answer;
    }
}