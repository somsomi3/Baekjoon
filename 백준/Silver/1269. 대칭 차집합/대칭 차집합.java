import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: A와 B의 원소 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        // 집합 A 입력
        Set<Integer> A = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        // 집합 B 입력
        Set<Integer> B = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        // A - B
        Set<Integer> diffAB = new HashSet<>(A);
        diffAB.removeAll(B);

        // B - A
        Set<Integer> diffBA = new HashSet<>(B);
        diffBA.removeAll(A);

        // 대칭 차집합의 크기
        int result = diffAB.size() + diffBA.size();
        System.out.println(result);
    }
}
