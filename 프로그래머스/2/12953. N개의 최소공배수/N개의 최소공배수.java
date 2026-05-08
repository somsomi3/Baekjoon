class Solution {

    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }

        return x;
    }

    static int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    public int solution(int[] arr) {

        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
}