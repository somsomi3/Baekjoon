import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = nums.length/2;
        
        for(int i = 0; i < nums.length; i++){
            // map.put(getOrdefault +1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int answer = 0;
        
        if(n > map.size()){
            answer = map.size();
        }else{
            answer = n;
        }
        
        return answer;
    }
}