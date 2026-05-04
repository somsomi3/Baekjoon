import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] ans = new int[commands.length];
        
        for(int i = 0; i< commands.length; i++){
            
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            int[] answer = new int[end - start + 1];
            
            int idx = 0;
            for(int j = start; j <= end; j++){
                answer[idx++] = array[j];
            }
            
            Arrays.sort(answer);
            
            ans[i] = answer[k];      
        }
        
        return ans;
    }
}