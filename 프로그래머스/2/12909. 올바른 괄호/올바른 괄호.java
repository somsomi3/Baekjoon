import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        boolean answer = true;
        
        for(int i = 0; i<s.length(); i++){
            char x = s.charAt(i);
            
            if(stack.size()==0){
                if(x== '('){
                    stack.push(x);
                }
                else{
                    answer = false;
                    break;
                }
            }
            else{
                if(stack.peek() == '('){
                    if(x ==')'){
                        stack.pop();
                    }else if(x =='('){
                        stack.push(x);
                    }
                }else{
                    answer = false;
                    break;
                }
                
            }
            
        }
        if(stack.size()!=0)answer = false;

        return answer;
    }
}