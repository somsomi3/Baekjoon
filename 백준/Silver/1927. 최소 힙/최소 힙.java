import java.io.*;

public class Main {
    static int[] heap = new int[100001];
    static int size = 0;

    public static void insert(int val) {
        heap[++size] = val;
        int i = size;
        while (i > 1 && heap[i] < heap[i / 2]) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    public static int delete() {
        if (size == 0) return 0;
        int min = heap[1];
        heap[1] = heap[size--];
        int i = 1;
        while (true) {
            int left = i * 2, right = i * 2 + 1, minIdx = i;
            if (left <= size && heap[left] < heap[minIdx]) minIdx = left;
            if (right <= size && heap[right] < heap[minIdx]) minIdx = right;
            if (minIdx == i) break;
            swap(i, minIdx);
            i = minIdx;
        }
        return min;
    }

    public static void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(delete()).append("\n");
            } else {
                insert(x);
            }
        }
        System.out.print(sb);
    }
}
