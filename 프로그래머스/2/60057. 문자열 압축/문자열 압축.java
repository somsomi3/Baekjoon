class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;

        for (int len = 1; len <= n / 2; len++) {
            StringBuilder sb = new StringBuilder();

            int count = 1;
            int i = 0;

            while (i + len <= n) {
                String cur = s.substring(i, i + len);
                int j = i + len;

                while (j + len <= n && cur.equals(s.substring(j, j + len))) {
                    count++;
                    j += len;
                }

                if (count > 1) sb.append(count);
                sb.append(cur);

                i = j;
                count = 1;
            }

            if (i < n) sb.append(s.substring(i));

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}