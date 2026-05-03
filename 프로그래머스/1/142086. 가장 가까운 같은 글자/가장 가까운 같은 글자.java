import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
        for(int i = 0; i< s.length(); i++){
            int x = s.charAt(i) - 'a';
            if(arr[x] ==-1){
                arr[x] = i;
                answer[i] = -1;
            }else{
                answer[i] = i-arr[x];
                arr[x]= i;
            }
        }
        
        return answer;
    }
}