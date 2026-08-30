import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        
        int one = x;
        int sum = 0;
        while(x >0){
            
            int namuge = x % 10;
            sum += namuge;
            x = x/10;
        }
        if(one%sum ==0){
            answer = true;
        }
        
        return answer;
    }
}