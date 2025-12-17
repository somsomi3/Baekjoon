import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 최대 하중

        int[] t = new int[n]; // 트럭 무게
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) t[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>(); // 다리
        int time = 0;
        int weight = 0;
        int idx = 0;

        for (int i = 0; i < w; i++) q.offer(0); // 빈 다리

        while (idx < n || weight > 0) {
            time++;

            weight -= q.poll(); // 내려감

            if (idx < n && weight + t[idx] <= L) {
                q.offer(t[idx]);
                weight += t[idx];
                idx++;
            } else {
                q.offer(0);
            }
        }

        System.out.println(time);
    }
}
