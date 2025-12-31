import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) break;

            int[] values = new int[n + 1];
            int[] parentIdx = new int[n + 1];

            int curParent = -1;
            int targetIdx = 0;

            values[0] = -1;
            parentIdx[0] = -1;

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                values[i] = Integer.parseInt(st.nextToken());

                if (values[i] == k) {
                    targetIdx = i;
                }

                if (values[i] != values[i - 1] + 1) {
                    curParent++;
                }

                parentIdx[i] = curParent;
            }

            int cousinCount = 0;

            for (int i = 1; i <= n; i++) {
                if (parentIdx[i] != parentIdx[targetIdx]
                        && parentIdx[parentIdx[i]] == parentIdx[parentIdx[targetIdx]]) {
                    cousinCount++;
                }
            }

            sb.append(cousinCount).append('\n');
        }

        System.out.print(sb);
    }
}
