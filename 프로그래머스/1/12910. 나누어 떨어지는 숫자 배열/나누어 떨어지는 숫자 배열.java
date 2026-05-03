import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;
        
        Arrays.sort(arr);
        
        for(int i = 0; i< arr.length; i++){
            if( arr[i]% divisor ==0){
                cnt++;
            }
        }
        
        int[] answer = new int[cnt];
        int x = 0;
        
        for(int i  = 0; i<arr.length; i++){
            if( arr[i]% divisor ==0){
                answer[x]= arr[i];
                x++;
            }
        }
        if(answer.length==0){
            answer = new int[1];
            answer[0] =-1;
        }
        return answer;
    }
}