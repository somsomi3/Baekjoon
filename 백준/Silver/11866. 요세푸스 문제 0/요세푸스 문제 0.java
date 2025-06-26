import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] queue;
    static int front = 0;
    static int rear = 0;
    static int size = 0;
    static int capacity;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        capacity = N;
        queue = new int[N];

        for (int i = 1; i <= N; i++) {
            enqueue(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (size > 0) {
            for (int i = 0; i < K - 1; i++) {
                enqueue(dequeue());  // 앞에서 꺼내 뒤로 보냄
            }
            sb.append(dequeue());
            if (size > 0) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);
    }

    static void enqueue(int x) {
        queue[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
    }

    static int dequeue() {
        int val = queue[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }
}
