import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int sum = 0;
        int cnt = 0;
        
        for (int n : list) {
            sum += n;
            cnt++;
            if (sum >= k) break;
        }
        return cnt;
    }
}