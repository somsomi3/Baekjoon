import java.io.*;
import java.util.*;

public class Main {
    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); 
            int m = Integer.parseInt(st.nextToken()); 

            st = new StringTokenizer(br.readLine());
            Queue<Document> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 중요도 내림차순

            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(i, priority));
                pq.offer(priority);
            }

            int count = 0;
            while (!queue.isEmpty()) {
                Document doc = queue.poll();

                if (doc.priority == pq.peek()) {
                    pq.poll(); 
                    count++;
                    if (doc.index == m) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.offer(doc); // 다시 뒤로 보냄
                }
            }
        }
    }
}
