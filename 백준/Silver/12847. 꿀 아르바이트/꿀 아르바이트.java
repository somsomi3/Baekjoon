import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for(int i=0; i<m; i++) sum += arr[i];

        long maxSum = sum;

        for(int i=m; i<n; i++) {
            sum += arr[i] - arr[i-m];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
