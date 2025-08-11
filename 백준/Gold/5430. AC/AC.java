import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine().trim();      // 연산 문자열
            int n = Integer.parseInt(br.readLine().trim());
            String arr = br.readLine().trim();    // 예: [1,2,3] 또는 []
            ArrayDeque<Integer> dq = new ArrayDeque<>(n);

            // 배열 파싱
            if (n > 0) {
                String nums = arr.substring(1, arr.length() - 1); // 대괄호 제거
                int start = 0;
                for (int i = 0; i <= nums.length(); i++) {
                    if (i == nums.length() || nums.charAt(i) == ',') {
                        dq.add(Integer.parseInt(nums.substring(start, i)));
                        start = i + 1;
                    }
                }
            }

            boolean reversed = false;
            boolean error = false;

            // 연산 수행 (진짜 reverse 아님)
            for (int i = 0; i < p.length() && !error; i++) {
                char c = p.charAt(i);
                if (c == 'R') {
                    reversed = !reversed;
                } else { // 'D'
                    if (dq.isEmpty()) {
                        error = true;
                    } else {
                        if (!reversed) dq.pollFirst();
                        else dq.pollLast();
                    }
                }
            }

            if (error) {
                out.append("error\n");
            } else {
                out.append('[');
                if (!dq.isEmpty()) {
                    if (!reversed) {
                        Iterator<Integer> it = dq.iterator();
                        out.append(it.next());
                        while (it.hasNext()) out.append(',').append(it.next());
                    } else {
                        Iterator<Integer> it = dq.descendingIterator();
                        out.append(it.next());
                        while (it.hasNext()) out.append(',').append(it.next());
                    }
                }
                out.append(']').append('\n');
            }
        }
        System.out.print(out.toString());
    }
}
