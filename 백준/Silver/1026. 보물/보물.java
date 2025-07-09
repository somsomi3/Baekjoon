import java.util.*;

public class Main {

    static class Pair {
        int value; // B 배열 값
        int index; // B 배열 원래 인덱스

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < N; i++) B[i] = sc.nextInt();

        // A 배열 오름차순 정렬
        Arrays.sort(A);

        // B 배열 (값, 인덱스) 쌍으로 힙에 넣기 (값 기준 내림차순)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (o1, o2) -> o2.value - o1.value
        );
        for (int i = 0; i < N; i++) {
            pq.offer(new Pair(B[i], i));
        }

        // A 값에서 작은 값부터 꺼내 B 원래 순서에 맞게 배치
        int[] assignedA = new int[N];

        for (int i = 0; i < N; i++) {
            Pair p = pq.poll(); // B의 큰 값부터 꺼냄
            assignedA[p.index] = A[i]; // B 원래 인덱스 위치에 배치
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += assignedA[i] * B[i];
        }

        System.out.println(sum);
    }
}
