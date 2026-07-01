import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        int sum = 0;
        for(int i = 0; i< d.length; i++){
            sum += d[i];
            answer++;
            if(sum == budget){
                break;
            }else if(sum > budget){
                answer--;
                break;
            }
        }
        
        return answer;
    }
}