import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        
        int pCount = 0;
        int yCount = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // Character.isUpperCase(c);
            c = Character.toUpperCase(c);
            if(c == 'P'){
                pCount++;
            }else if(c =='Y'){
                yCount++;
            }
        }
        
        // if(pCount==yCount || pCount==0 && yCount==0 ){
        if(pCount==yCount){
            answer = true;
        }

        return answer;
    }
}