import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 길이를 3의 배수로 맞추기 (앞에 0 채우기)
        int r = s.length() % 3;
        if (r == 1) s = "00" + s;
        else if (r == 2) s = "0" + s;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += 3) {
            int num = (s.charAt(i) - '0') * 4 +
                      (s.charAt(i + 1) - '0') * 2 +
                      (s.charAt(i + 2) - '0');
            sb.append(num);
        }

        System.out.println(sb.toString());
    }
}