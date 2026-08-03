class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        int number = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(number, n).toUpperCase());
            number++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(sb.charAt(i));
        }

        return answer.toString();
    }
}