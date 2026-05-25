import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {

        s = s.replace("{", "");
        s = s.replace("}", "");
        
        String[] arr = s.split(",");
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<arr.length; i++){
           
            int n = Integer.parseInt(arr[i]);
            map.put(n, map.getOrDefault(n, 0) + 1);
            
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        
        list.sort((a, b)-> 
                  map.get(b) - map.get(a));
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}