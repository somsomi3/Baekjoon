import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        for(int i = 1; i<=yellow; i++){
            if(yellow%i ==0){
                int x = i;
                int y = yellow/i;
                
                if((x+2)*(y+2)== sum){
                    return new int[]{y+2, x+2};
                }
            }
        }
        
        return answer;
    }
}