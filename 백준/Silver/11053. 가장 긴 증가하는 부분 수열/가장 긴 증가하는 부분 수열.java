import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> lis = new ArrayList<>();

        for (int x : arr) {
            int pos = Collections.binarySearch(lis, x);
            if (pos < 0) pos = -(pos + 1); // lower_bound 위치
            if (pos == lis.size()) lis.add(x);
            else lis.set(pos, x);
        }

        System.out.println(lis.size());
    }
}
