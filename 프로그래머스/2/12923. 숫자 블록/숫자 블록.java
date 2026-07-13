import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {

        int[] answer = new int[(int)(end - begin + 1)];
        int a = 0;

        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                answer[a++] = 0;
                continue;
            }

            answer[a] = 1;
            for (long x = 2; x * x <= i; x++) {
                if (i % x == 0) {
                    if (i / x <= 10000000) {
                        answer[a] = (int)(i / x);
                        break;
                    } else {
                        answer[a] = (int)x;
                    }
                }
            }
            a++;
        }
        return answer;
    }
}