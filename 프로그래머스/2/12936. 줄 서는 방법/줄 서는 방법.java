import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        int[] answer = new int[n];
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        k--;
        
        for (int i = 0; i < n; i++) {
            long factorial = 1;
            for (int j = 1; j < n-i; j++) {
                factorial *= j;
            }
            int index = (int)(k/factorial);
            
            answer[i] = arr.get(index);
            arr.remove(index);
            k %= factorial;
        }
        return answer;
    }
}