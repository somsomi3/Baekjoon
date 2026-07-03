import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        while (pq.size() >= 2){
            
            if(pq.peek()>= K)break;
            
            int x = pq.poll();
            int y = pq.poll() *2;
            
            pq.offer(x+y);
            answer++;
        }
        if (pq.peek() < K) {
            return -1;
        }
        return answer;
    }
}