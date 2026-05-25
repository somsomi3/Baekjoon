import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int[] arr= new int[order.length];
        for(int i = 0; i<order.length; i++){
            arr[i] = i+1;
        }
        
        Stack<Integer> stack = new Stack<>();
        int idx =0; 
        
        
        for(int i = 0; i< order.length; i++){
            if(order[idx]== arr[i]){
                answer++;
                idx++;
            
            } else {
                stack.push(arr[i]);
            }
            
            while (!stack.isEmpty() &&
                   stack.peek() == order[idx]) {

                stack.pop();
                answer++;
                idx++;

                if (idx == order.length) break;
            }          
        }        
        return answer;
    }
}