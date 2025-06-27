import java.io.*;
import java.util.*;

public class Main {
    static long[] count = new long[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start = 1;
        int end = n;
        int place = 1;

        while (start <= end) {
            // 끝자리가 9가 되도록 end 감소
            while (end % 10 != 9 && start <= end) {
                add(end, place);
                end--;
            }

            // 시작이 0이 되도록 start 증가
            while (start % 10 != 0 && start <= end) {
                add(start, place);
                start++;
            }

            if (start > end) break;

            // 일괄 계산
            int s = start / 10;
            int e = end / 10;

            for (int i = 0; i < 10; i++) {
                count[i] += (long)(e - s + 1) * place;
            }

            start /= 10;
            end /= 10;
            place *= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(count[i] + " ");
        }
    }

    static void add(int num, int place) {
        while (num > 0) {
            int digit = num % 10;
            count[digit] += place;
            num /= 10;
        }
    }
}
