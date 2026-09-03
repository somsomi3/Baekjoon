import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int xx = 0;
        for(int x = 0; x < commands.length; x++){
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            
            int[] mid = new int[j-i+1];
            int dd = 0;
            for(int y = i-1; y<j ; y++){
                mid[dd] = array[y];
                dd++;
            }
            Arrays.sort(mid);
            answer[xx] = mid[k-1];
            xx++;
        }
        
        return answer;
    }
}