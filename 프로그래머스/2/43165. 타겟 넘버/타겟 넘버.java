import java.io.*;
import java.util.*;

class Solution {    
    //함수를 위한 전역변수
    int answer = 0;
    int[] numbers;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
        
        return answer;
    }
    public void dfs(int idx, int sum){
        
        if(idx == numbers.length){
            if(sum ==target){
                answer++;
            }
            return;
        }
        
        dfs(idx +1, sum + numbers[idx]);
        dfs(idx +1, sum - numbers[idx]);
        
    }
    
}