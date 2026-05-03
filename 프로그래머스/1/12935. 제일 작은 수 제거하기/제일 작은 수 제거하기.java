import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
      
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        int[] answer = new int[arr.length-1];
        int idx = 0;
        
        for(int x : arr){
            if(x != min){
                answer[idx++] = x;
            }
        }
        if(idx == 0) return new int[]{-1};
        return answer;
    }
}