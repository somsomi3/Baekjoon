import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        int len = s.length();

        // 앞에 남는 자리 처리
        int first = len % 3;

        if (first == 1) {
            sb.append(s.charAt(0));
        } 
        else if (first == 2) {
            int num = (s.charAt(0) - '0') * 2
                    + (s.charAt(1) - '0');
            sb.append(num);
        }

        // 3자리씩 처리
        for (int i = first; i < len; i += 3) {
            int num =
                    (s.charAt(i) - '0') * 4 +
                    (s.charAt(i + 1) - '0') * 2 +
                    (s.charAt(i + 2) - '0');

            sb.append(num);
        }

        System.out.println(sb);
    }
}
