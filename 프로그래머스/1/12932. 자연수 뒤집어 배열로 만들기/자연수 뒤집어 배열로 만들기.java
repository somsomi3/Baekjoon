import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long n) {
        //reverse해도되고, 아니면 sb만들어서 toString해도될듯.
        // new StringBuilder(String.valueOf(n)).reverse()
        
        //근데 왜 return 배열은 int이다. 숫자n와 리턴은 숫자의길이 길이의 배열

        StringBuilder sb = new StringBuilder();
        
        while(n > 0){//n값이 계속 변화하므로 while문 사용하기
            long x = n%10;
            n /=10;
            sb.append(x);
        }
        String ans = sb.toString();
        
        int[] answer = new int[ans.length()];
        
        for(int i = 0; i< ans.length(); i++){
            answer[i] = ans.charAt(i) -'0';
        }
        
        return answer;
    }
}