import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int idx;   // 사람 번호
        int d;
        int h;
        int line;  // 몇 번째 줄인지

        Node(int idx, int d, int h, int line) {
            this.idx = idx;
            this.d = d;
            this.h = h;
            this.line = line;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] people = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            people[i] = new Node(i, d, h, i % M);
        }
        
//        pq는 뽑아낼 수 있는데
//        list는 찾아서 뽑아내야 하는구나
        
        
     // 우선순위 기준을 람다로 정의하고,
     // 최우선 원소를 꺼내기 위해 list((a, b)->)말고 pq를 사용한다.
     // pq.poll()로 항상 최우선 원소를 꺼낸다
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.d != b.d) return Integer.compare(b.d, a.d);
                if (a.h != b.h) return Integer.compare(b.h, a.h);
                return Integer.compare(a.line, b.line);
            }
        );

        int[] next = new int[M];

        int init = Math.min(M, N);
        // 초기 M명인데 안전한 범위
        for (int i = 0; i < init; i++) {
            pq.add(people[i]);
            next[i] = i + M;
        }
        //여기서 M에 대한 제한 없이 무작위로 잡아넣고 있어서

        int count = 0;

        while (true) {
            Node cur = pq.poll();
            //지금 화장실 들어갈 사람 한명을 pq에 있는 규칙 대로 뽑는다.
            count++;

            if (cur.idx == K) {
                System.out.println(count - 1);
                return;
            }


            int line = cur.line;

            if (next[line] < N) {//여기서 next의 범위를 
                pq.add(people[next[line]]);
                next[line] += M;
            }
        }
    }
}