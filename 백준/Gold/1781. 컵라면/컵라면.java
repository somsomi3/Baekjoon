import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemCount = Integer.parseInt(br.readLine());

        // 문제를 데드라인 오름차순, 같은 데드라인이면 라면 수 내림차순으로 정렬
        PriorityQueue<int[]> problemQueue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; // 라면 수 내림차순
            return a[0] - b[0]; // 데드라인 오름차순
        });

        // 문제 입력 받기
        for (int i = 0; i < problemCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramenCount = Integer.parseInt(st.nextToken());
            problemQueue.offer(new int[]{deadline, ramenCount});
        }

        // 선택한 문제의 라면 수를 저장할 최소 힙 (가장 적은 라면 수 제거용)
        PriorityQueue<Integer> selectedRamenQueue = new PriorityQueue<>();

        // 문제를 하나씩 처리하며 최적 선택
        while (!problemQueue.isEmpty()) {
            int[] currentProblem = problemQueue.poll();
            int deadline = currentProblem[0];
            int ramenCount = currentProblem[1];

            selectedRamenQueue.offer(ramenCount);
            if (selectedRamenQueue.size() > deadline) {
                selectedRamenQueue.poll(); // 가장 적은 라면 수 제거
            }
        }

        // 총 라면 수 계산
        int totalRamen = 0;
        for (int ramen : selectedRamenQueue) {
            totalRamen += ramen;
        }

        System.out.println(totalRamen);
    }
}
