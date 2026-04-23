class Solution {
    public String solution(String p, String a, String[] logs) {
        int T = sec(p), A = sec(a);
        long[] d = new long[T + 1];

        for (String log : logs) {
            int s = sec(log.substring(0, 8));
            int e = sec(log.substring(9));
            d[s] += 1;
            if (e <= T) d[e] -= 1;
        }

        for (int i = 1; i < T; i++) d[i] += d[i - 1];
        for (int i = 1; i < T; i++) d[i] += d[i - 1];

        long max = d[A - 1];
        int idx = 0;

        for (int i = A; i < T; i++) {
            long cur = d[i] - d[i - A];
            if (cur > max) {
                max = cur;
                idx = i - A + 1;
            }
        }

        return str(idx);
    }

    static int sec(String t) {
        return (t.charAt(0) - '0') * 36000 +
               (t.charAt(1) - '0') * 3600 +
               (t.charAt(3) - '0') * 600 +
               (t.charAt(4) - '0') * 60 +
               (t.charAt(6) - '0') * 10 +
               (t.charAt(7) - '0');
    }

    static String str(int x) {
        int h = x / 3600;
        int m = (x % 3600) / 60;
        int s = x % 60;

        return (h < 10 ? "0" : "") + h + ":" +
               (m < 10 ? "0" : "") + m + ":" +
               (s < 10 ? "0" : "") + s;
    }
}