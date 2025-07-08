import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> posHeap = new PriorityQueue<>(); // 양수 최소힙
        PriorityQueue<Integer> negHeap = new PriorityQueue<>(Collections.reverseOrder()); // 음수 최대힙

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (posHeap.isEmpty() && negHeap.isEmpty()) {
                    System.out.println(0);
                } else if (posHeap.isEmpty()) {
                    System.out.println(negHeap.poll());
                } else if (negHeap.isEmpty()) {
                    System.out.println(posHeap.poll());
                } else {
                    int posAbs = posHeap.peek();
                    int negAbs = Math.abs(negHeap.peek());

                    if (negAbs <= posAbs) {
                        System.out.println(negHeap.poll());
                    } else {
                        System.out.println(posHeap.poll());
                    }
                }
            } else {
                if (x > 0) posHeap.offer(x);
                else negHeap.offer(x);
            }
        }
    }
}
