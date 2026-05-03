import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxI = 0;
        int maxJ = 0;
        
        for(int i = 0; i<sizes.length; i++){
            if(sizes[i][0]>= sizes[i][1]){
                maxI = Math.max(maxI, sizes[i][0]);
                maxJ = Math.max(maxJ, sizes[i][1]);    
            }else{
                maxI = Math.max(maxI, sizes[i][1]);
                maxJ = Math.max(maxJ, sizes[i][0]); 
            }
        }
        
        answer = maxI *maxJ;
        
        return answer;
    }
}