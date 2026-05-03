import java.util.*;

class Solution {
    public long solution(long n) {
        
        // 1. 자리수 개수 구하기
        long temp = n;
        int len = 0;
        while (temp > 0) {
            len++;
            temp /= 10;
        }
        
        // 2. 배열 생성
        int[] arr = new int[len];
        
        // 3. 자리수 저장
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(n % 10);
            n /= 10;
        }
        
        // 4. 정렬 (오름차순)
        Arrays.sort(arr);
        
        // 5. 뒤에서부터 이어붙이기 (내림차순)
        long answer = 0;
        for (int i = len - 1; i >= 0; i--) {
            answer = answer * 10 + arr[i];
        }
        
        return answer;
    }
}