import java.io.*;
import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long pp = 0;
        for(int i = 0; i< p.length(); i++){
            int x = p.charAt(i)- '0';
            pp = pp*10 + x;
        }
        
        for(int i = 0; i<= t.length() - p.length(); i++){//시작위치주의
            long result = 0;
            for(int j = 0; j< p.length(); j++){
                
                int x = t.charAt(i+j)-'0';
                
                result = result*10 + x;
            }
            if(result <= pp){
                answer++;
            }
        }
        
        return answer;
    }
}