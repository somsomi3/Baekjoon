import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //시작 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); //종료 시간
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]); //시작시간기준 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i][0]) pq.poll(); //가장 빨리 끝나는 강의실이 비면 재사용
            pq.add(arr[i][1]); //새 강의 배정
        }

        System.out.println(pq.size());
    }
}
