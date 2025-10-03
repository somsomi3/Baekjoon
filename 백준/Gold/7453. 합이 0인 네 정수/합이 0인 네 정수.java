import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int size = n * n;
        int[] AB = new int[size];
        int[] CD = new int[size];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long ans = 0;
        int l = 0;
        int r = size - 1;

        while (l < size && r >= 0) {
            int sum = AB[l] + CD[r];
            if (sum == 0) {
                int abVal = AB[l];
                int cdVal = CD[r];

                long cntA = 0;
                while (l < size && AB[l] == abVal) {
                    cntA++;
                    l++;
                }

                long cntB = 0;
                while (r >= 0 && CD[r] == cdVal) {
                    cntB++;
                    r--;
                }

                ans += cntA * cntB;
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(ans);
    }
}
