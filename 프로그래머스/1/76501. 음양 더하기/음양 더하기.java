import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        // int answer = 123456789;//원재주어진 내용
        int answer = 0;
        
        for(int i = 0; i< absolutes.length; i++){
            if(signs[i] == true){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
            
        }
        
        return answer;
    }
}