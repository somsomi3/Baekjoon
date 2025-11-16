import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 1_000_000_000L*n;
        
        while(left<right){
            long mid = left+(right-left)/2;
            long total = 0;
            for(int time: times){
                total += mid/time;
            }
            if(total<n){
            left = mid+1;
            }else{
            right = mid;
            }            
        }
        return left;
    }
}