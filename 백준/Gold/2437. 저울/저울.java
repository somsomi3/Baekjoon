import java.io.*;
import java.util.*;

public class Main {
    public static int solve(int[] weight) {
        Arrays.sort(weight);
        int result = 1;
        for (int w : weight) {
            if (result < w) {
                break;
            }
            result += w;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(weight));
    }
}
