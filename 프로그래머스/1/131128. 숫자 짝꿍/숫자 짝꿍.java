class Solution {

    public String solution(String X, String Y) {

        int[] cntX = new int[10];
        int[] cntY = new int[10];

        for (int i = 0; i < X.length(); i++) {
            cntX[X.charAt(i) - '0']++;
        }

        for (int i = 0; i < Y.length(); i++) {
            cntY[Y.charAt(i) - '0']++;
        }

        StringBuilder answer = new StringBuilder();

        for (int number = 9; number >= 0; number--) {
            int a = Math.min(cntX[number], cntY[number]);

            while (a > 0) {
                answer.append(number);
                a--;
            }
        }

        if (answer.length() == 0) {
            return "-1";
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}