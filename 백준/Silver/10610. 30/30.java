import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int digitSum = 0;
        boolean hasZero = false;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';//한 자리 숫자
            digitSum += d;
            if (d == 0) hasZero = true;
            pq.add(d);
        }

        if (!hasZero || digitSum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        System.out.println(sb.toString());
    }
}
