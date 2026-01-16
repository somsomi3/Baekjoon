import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] maxPrev = new int[3];
        int[] minPrev = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            int v = Integer.parseInt(st.nextToken());
            maxPrev[j] = v;
            minPrev[j] = v;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[] maxCur = new int[3];
            int[] minCur = new int[3];

            maxCur[0] = Math.max(maxPrev[0], maxPrev[1]) + a;
            maxCur[1] = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]) + b;
            maxCur[2] = Math.max(maxPrev[1], maxPrev[2]) + c;

            minCur[0] = Math.min(minPrev[0], minPrev[1]) + a;
            minCur[1] = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]) + b;
            minCur[2] = Math.min(minPrev[1], minPrev[2]) + c;

            maxPrev = maxCur;
            minPrev = minCur;
        }

        int maxAns = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]);
        int minAns = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]);

        System.out.println(maxAns + " " + minAns);
    }
}
