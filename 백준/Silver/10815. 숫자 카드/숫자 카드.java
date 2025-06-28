import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> cardSet = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cardSet.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (cardSet.contains(num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        
        System.out.println(sb.toString());
    }
}
