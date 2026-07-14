import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int max = 0;
        for(int i = 0; i< times.length; i++){
            if(max<times[i])max = times[i];
        }
        
        //인덱스 아님 sum값임.
        long left = 0;
        long right = (long) max * n;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canFind(mid, n, times)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    public boolean canFind(long mid, int n, int[] times){
        long sum =  0;
        
        for(int time: times){
            sum+= mid/time;
            
            if(sum >= n)return true;
        }
        return false;
    }
    
}