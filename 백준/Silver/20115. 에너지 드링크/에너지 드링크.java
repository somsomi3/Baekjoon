import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr.offer(Integer.parseInt(st.nextToken()));
        }
        
        double sum = arr.poll();
        while (!arr.isEmpty()) {
            sum += arr.poll() / 2.0;
        }
        
        System.out.println(sum);
    }
}
