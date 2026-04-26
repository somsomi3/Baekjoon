import java.util.*;

class Solution {
    public int solution(int num) {
        Map<Long, Integer> dp = new HashMap<>();
        dp.put(1L, 0);
        
        long n = num;
        int cnt = 0;
        
        List<Long> path = new ArrayList<>();
        
        while (!dp.containsKey(n)) {
            path.add(n);
            
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
        }
        
        cnt = dp.get(n);
        
        for (int i = path.size() - 1; i >= 0; i--) {
            cnt++;
            dp.put(path.get(i), cnt);
        }
        
        int res = dp.get((long) num);
        return res > 500 ? -1 : res;
    }
}