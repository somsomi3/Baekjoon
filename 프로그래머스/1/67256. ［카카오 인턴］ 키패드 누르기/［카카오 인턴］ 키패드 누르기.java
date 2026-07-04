class Solution {
    public String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        int left = 10;   //*
        int right = 12;  //#

        for (int number : numbers) {

            if (number == 0) {
                number = 11;
            }

            //왼쪽
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = number;
            }
            //오른쪽
            else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = number;
            }
            //가운데
            else {

                int leftDistance =
                        Math.abs((left - 1) / 3 - (number - 1) / 3)
                      + Math.abs((left - 1) % 3 - (number - 1) % 3);

                int rightDistance =
                        Math.abs((right - 1) / 3 - (number - 1) / 3)
                      + Math.abs((right - 1) % 3 - (number - 1) % 3);

                if (leftDistance < rightDistance) {
                    answer.append("L");
                    left = number;
                } else if (leftDistance > rightDistance) {
                    answer.append("R");
                    right = number;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = number;
                    } else {
                        answer.append("R");
                        right = number;
                    }
                }
            }
        }

        return answer.toString();
    }
}