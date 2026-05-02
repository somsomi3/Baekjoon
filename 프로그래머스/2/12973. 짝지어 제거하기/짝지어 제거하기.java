import java.io.*;
import java.util.*;

class Solution
{
    public int solution(String s)
    {

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else stack.push(c);
            
        }
        
        if(stack.size()>0) return 0;
        else return 1;

    }
}