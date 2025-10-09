import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        int n = scoville.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i : scoville) {
            pq.add(i);
        }
        int count =0; 
        
        while(pq.size()>1&&pq.peek()<K){
            int first = pq.poll();
            int second = pq.poll();
            int remix = first+(second*2);
            pq.add(remix);
            count++;
        }
    
        return pq.peek() >= K ? count : -1;
    }
}