import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> q = new ArrayDeque<>();
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();
        
        for(int i = 0; i< goal.length; i++){
            q.offer(goal[i]);
        }
        
        for(int i = 0; i< cards1.length; i++){
            q1.offer(cards1[i]);
        }
        
        for(int i = 0; i< cards2.length; i++){
            q2.offer(cards2[i]);
        }
        int i = q.size();
        boolean flag = true;
        while(i> 0){
            // if(q.peek()== q1.peek()){
            if(!q1.isEmpty() && q.peek().equals(q1.peek())){
                q.poll();
                q1.poll();
                i--;
            // }else if(q.peek()== q2.peek()){
            }else if(!q2.isEmpty() && q.peek().equals(q2.peek())){
                q.poll();
                q2.poll();
                i--;
            }else{
                flag = false;
                break;
            }
        }
        
        if(flag){
            answer = "Yes";
        }else{
            answer = "No";
        }
        
        return answer;
    }
}