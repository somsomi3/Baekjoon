import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        
        Set<Integer> set = new HashSet<>();
        
        Arrays.sort(numbers);
        
        for(int i = 0; i<numbers.length; i++){
            for(int j =i+1; j<numbers.length; j++){
                int x = numbers[i]+ numbers[j];
                set.add(x);
            }
        }
        int[] answer = new int[set.size()];
        
        int idx = 0;
        for(int x : set){
            answer[idx++] = x;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}