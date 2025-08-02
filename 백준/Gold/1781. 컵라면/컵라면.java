import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        PriorityQueue<int[]> problems = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; // 라면 수 내림차순
            return a[0] - b[0]; // 데드라인 오름차순
        });

        for (int i = 0; i < n; i++) {
            int d = read();
            int r = read();
            problems.offer(new int[]{d, r});
        }

        PriorityQueue<Integer> selected = new PriorityQueue<>(); // 최소 힙
        while (!problems.isEmpty()) {
            int[] prob = problems.poll();
            selected.offer(prob[1]);
            if (selected.size() > prob[0]) selected.poll(); // 가장 적은 라면 수 제거
        }

        int total = 0;
        while (!selected.isEmpty()) total += selected.poll();
        System.out.println(total);
    }

    // 빠른 입력 함수 (BufferedReader + 비트 연산)
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
