import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
    Arrays.sort(A); // 오름차순
    Arrays.sort(B); // 오름차순

    int sum = 0;
    for (int i = 0; i < A.length; i++) {
        sum += A[i] * B[B.length - 1 - i]; // B는 뒤에서부터 곱하기
    }
                return sum;
    }
}