import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int priority: priorities){
            q.offer(priority);
        }
        
        int answer = 0;
        int i = 0;
        
        while(!q.isEmpty()){
            if(priorities[i] == q.peek()){
                q.poll();
                answer++;
                
                if(i == location){
                    return answer;
                }
            }
            i++;
            
            if(i==priorities.length){
                i = 0;
            }
        }
        
        return answer;
    }
}