import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int x = nums.length/2;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i< nums.length; i++){
            set.add(nums[i]);
        }
        
        if(set.size() >= x){
            answer = x;
        }else answer = set.size();
        
        return answer;
    }
}