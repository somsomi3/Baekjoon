import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // String answer = "";
        // return answer;
        int i = 0;
        int j = 0;
        
        for(String x : goal){
            if(i <cards1.length && x.equals(cards1[i])){
                i++;
             }else if (j <cards2.length && x.equals(cards2[j])) {
                j++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}