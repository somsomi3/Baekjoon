import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum= 0;
        int test = x;
        while(test >0){
            sum += test%10;
            test /=10;
        }
        
        if(x % sum == 0){
            answer = true;
        }else answer = false;
        
        return answer;
    }
}