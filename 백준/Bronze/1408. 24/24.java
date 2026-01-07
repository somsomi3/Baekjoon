import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = 0;
        int end = 0;

        for (int i = 0; i < 2; i++) {
            String[] s = br.readLine().split(":");
            int h = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int sec = Integer.parseInt(s[2]);

            int total = h * 3600 + m * 60 + sec;

            if (i == 0) start = total;
            else end = total;
        }
        
        //하루 더해주기
//        시작 시간: 23:59:59
//        끝 시간:   00:00:10

        if (end < start) {
            end += 24 * 60 * 60;
        }

        int diff = end - start;

        int hh = diff / 3600;
        diff %= 3600;
        int mm = diff / 60;
        int ss = diff % 60;

        System.out.printf("%02d:%02d:%02d", hh, mm, ss);
    }
}
