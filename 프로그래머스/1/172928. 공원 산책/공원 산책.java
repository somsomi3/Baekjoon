import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int x = 0;
        int y = 0;
        
        for(int i = 0; i< park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                if(park[i].charAt(j)== 'S'){
                    x = i;
                    y = j;
                }
            }
        }
        
        for(String r : routes){
            String[] arr = r.split(" ");
            
            char dir = arr[0].charAt(0);
            int dist = Integer.parseInt(arr[1]);
            
            int nx = x;
            int ny = y;
            
            boolean flag = true;
            
            for(int j = 1; j<=dist; j++){
                if (dir == 'E') ny++;
                else if (dir == 'W') ny--;
                else if (dir == 'S') nx++;
                else if (dir == 'N') nx--;

                if (nx < 0 || nx >= park.length || ny < 0 || ny >= park[0].length() || park[nx].charAt(ny) == 'X') {
                    flag = false;
                    break;
                }
            }
                
            if (flag) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}