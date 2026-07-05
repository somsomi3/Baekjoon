import java.util.*;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {

        int answer = 0;

        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }
        
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        boolean possibleA = true;
        for (int num : arrayB) {
            if (num % gcdA == 0) {
                possibleA = false;
                break;
            }
        }

        boolean possibleB = true;
        for (int num : arrayA) {
            if (num % gcdB == 0) {
                possibleB = false;
                break;
            }
        }

        if (possibleA) {
            answer = Math.max(answer, gcdA);
        }
        if (possibleB) {
            answer = Math.max(answer, gcdB);
        }
        return answer;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}