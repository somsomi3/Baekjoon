import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        for (int i =0; i<n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;

        for (int i = n-2; i>=0; i--) {
            if (a[i]>= a[i+1]) {
                int t = a[i]-(a[i+1]-1);
                ans += t;
                a[i]= a[i+1]-1;
            }
        }

        System.out.println(ans);
    }
}
