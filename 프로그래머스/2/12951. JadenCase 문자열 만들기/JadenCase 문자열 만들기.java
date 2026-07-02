class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (i == 0 || s.charAt(i - 1) == ' ') {
                if (x >= 'a' && x <= 'z') {
                    sb.append((char)(x - 32));
                } else {
                    sb.append(x);
                }
            }

            else {
                if (x >= 'A' && x <= 'Z') {
                    sb.append((char)(x + 32));
                } else {
                    sb.append(x);
                }
            }
        }

        return sb.toString();
    }
}