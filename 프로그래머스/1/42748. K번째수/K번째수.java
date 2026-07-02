import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int x= 0; x<commands.length; x++){


            int i = commands[x][0];
            int j = commands[x][1];
            int target = commands[x][2];

            int[] ranges = new int[j-i+1];

            int index = 0;
            for (int z = i - 1; z < j; z++) {
                ranges[index] = array[z];
                index++;
            }
            
            Arrays.sort(ranges);

            answer[x] = ranges[target-1];
        }
        return answer;
    }
}