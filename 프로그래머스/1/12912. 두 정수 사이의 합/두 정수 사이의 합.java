// import java.io.*;
import java.util.*;

class Solution {
    public long solution(int a, int b) {
        
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        
        long answer = 0;
        if(x==y){
            return x;
        }
        else{
            for(int i = x; i <= y; i++){
            answer += i;
            }
            return answer;
        }
        
        

    }
}