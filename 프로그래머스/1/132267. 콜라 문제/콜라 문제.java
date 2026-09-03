import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int x = n;
        while(x>=a){
            // if(x%a==0){
            //     x = x/a;
            //     answer+=x;
            // }else{
            //     x = x/a;
            //     answer+=x;
            //     x+= (x%a);
            // }
            int get = (x / a) * b;
            
            answer += get;
            x = get + (x % a);
        }
        // answer*=b;
        return answer;
    }
}