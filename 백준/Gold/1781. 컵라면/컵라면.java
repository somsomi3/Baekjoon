import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem> {
        int deadline;
        int ramen;

        public Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Problem o) {
            return this.deadline - o.deadline; // 데드라인 오름차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Problem[] problems = new Problem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(d, r);
        }

        Arrays.sort(problems); // 데드라인 기준 오름차순 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소힙

        for (Problem p : problems) {
            pq.offer(p.ramen); // 현재 컵라면 수를 큐에 추가

            // 데드라인보다 선택한 문제 수가 많으면, 최소 라면 제거
            if (pq.size() > p.deadline) {
                pq.poll();
            }
        }

        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}
