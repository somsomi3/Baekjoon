class Solution {
    public int solution(int[][] signals) {
        int max = 1;

        for (int[] s : signals) {
            int sum = s[0] + s[1] + s[2];
            max = max / gcd(max,sum)* sum;
        }

        for (int t = 1; t <= max; t++) {
            boolean flag =true;

            for (int[] s : signals) {
                int sum = s[0] + s[1] +s[2];
                int now = (t - 1) % sum;

                if (now < s[0] || now >= s[0] + s[1]) {
                    flag = false;
                    break;
                }
            }

            if (flag) return t;
        }

        return -1;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}