class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int round = -1;

        for (int i = 0; i < dartResult.length(); i++) {
            char current = dartResult.charAt(i);


            if (Character.isDigit(current)) {
                round++;

                if (current == '1'&& i + 1 < dartResult.length()&& dartResult.charAt(i + 1) == '0') 
                {
                    scores[round] = 10;
                    i++;
                } else {
                    scores[round] = current - '0';
                }
            }

            else if (current == 'D') {
                scores[round] *= scores[round];
            }

            else if (current == 'T') {
                scores[round] = scores[round] * scores[round] * scores[round];
            }

            else if (current == '#') {
                scores[round] *= -1;
            }

            else if (current == '*') {
                scores[round] *= 2;

                if (round > 0) {
                    scores[round - 1] *= 2;
                }
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}