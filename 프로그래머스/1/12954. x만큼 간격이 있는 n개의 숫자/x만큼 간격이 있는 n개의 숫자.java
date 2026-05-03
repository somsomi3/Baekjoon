import java.io.*;
import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        // long[] answer = {};
        long[] answer = new long[n];
        
        answer[0] = x;
        
        //배열 인덱스는 항상 int 타입
        for(int i = 1; i< n; i++){
            answer[i] = answer[i-1]+ x;
        }
        
        return answer;
    }
}