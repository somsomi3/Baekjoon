import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i< prices.length -1; i++){
            for(int j = i+1; j< prices.length; j++){
                // if(prices[i]<=prices[j]){
                //     answer[i]+=1;
                // }else{
                //     break;
                // }
                
                //가격이 떨어졌든 안 떨어졌든 일단 시간이 1초 증가
                answer[i]++;

                if (prices[j] < prices[i]) {
                    break;
                }
                
            }
        }
        
        return answer;
    }
}