

import java.io.*;
import java.util.*;

public class Main {
    static int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) <= 32); // 공백, 줄바꿈 무시
        boolean minus = c == '-';
        if (minus) c = System.in.read();
        do {
            n = n * 10 + (c & 15); // c - '0' 대신 비트 연산
        } while ((c = System.in.read()) > 32);
        return minus ? -n : n;
    }

    static long readLong() throws IOException {
        int c;
        long n = 0;
        while ((c = System.in.read()) <= 32);
        boolean minus = c == '-';
        if (minus) c = System.in.read();
        do {
            n = n * 10 + (c & 15);
        } while ((c = System.in.read()) > 32);
        return minus ? -n : n;
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();

        long[][] towns = new long[N][2];
        long total = 0;

        for (int i = 0; i < N; i++) {
            towns[i][0] = readLong(); // 위치
            towns[i][1] = readLong(); // 인구 수
            total += towns[i][1];
        }

        Arrays.sort(towns, Comparator.comparingLong(a -> a[0]));

        long sum = 0;
        long half = (total + 1) >> 1; // 비트연산으로 절반 이상 판단

        for (int i = 0; i < N; i++) {
            sum += towns[i][1];
            if (sum >= half) {
                System.out.println(towns[i][0]);
                return;
            }
        }
    }
}
