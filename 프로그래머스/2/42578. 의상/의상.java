import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] x : clothes) {
            String type = x[1];
            map.put(type, map.getOrDefault(type, 0) +1);
        }
        
        int result = 1;
        
        for (int cnt : map.values()) {
            result *= (cnt +1);
        }     
        return result -1;
    }
}