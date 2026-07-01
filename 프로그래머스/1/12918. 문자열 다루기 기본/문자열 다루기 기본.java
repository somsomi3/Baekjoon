import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        for(int i = 0; i< s.length(); i++){
            char x = s.charAt(i);
            
            if(!Character.isDigit(x)){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}