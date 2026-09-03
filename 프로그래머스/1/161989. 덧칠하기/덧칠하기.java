import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int x = 0;
        for(int i = 0; i< section.length; i++){
            if(x < section[i]){
                x = section[i]+m -1;
                answer++;
            }
        }
        return answer;
    }
}