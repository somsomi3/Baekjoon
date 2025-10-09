import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int cam = Integer.MIN_VALUE;
        int count =0;
        for (int[] r : routes) {
            if (cam < r[0]) { // 현재 카메라로 커버 불가
                count++;
                cam = r[1];
            }
        }
        
        return count;
    }
}