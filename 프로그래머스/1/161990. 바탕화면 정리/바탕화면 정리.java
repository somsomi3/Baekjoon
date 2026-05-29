import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        
        //어차피 적어도 하나의 파일이 있음
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int i = 0; i< wallpaper.length; i++){
            String s = wallpaper[i];
            for(int j = 0; j< s.length(); j++){
                if(s.charAt(j) == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);

                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        int[] answer = new int[4];
        
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX + 1;
        answer[3] = maxY + 1;
        
        return answer;
    }
}