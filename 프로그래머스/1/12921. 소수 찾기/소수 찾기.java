import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        //0과 1은 소수가 아니다.
        for(int i = 2; i<=n; i++){
            int cnt = 0;
            
            for(int x = 2; x*x<=i; x++){
                if(i % x==0){
                    cnt++;
                    break;   
                }
            }

            if (cnt == 0) {
                answer++;
            }
        }

        return answer;
    }
}