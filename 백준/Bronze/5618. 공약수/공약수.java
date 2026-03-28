import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = 0;

        if(n == 2) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g = gcd(a, b);
        } else {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g = gcd(gcd(a, b), c);
        }
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i * i <= g; i++) {
            if(g % i == 0) {
                list.add(i);
                if(i != g / i) list.add(g / i);
            }
        }

        Collections.sort(list);

        for(int x : list) {
            sb.append(x).append("\n");
        }

        System.out.print(sb);
    }
	static int gcd(int a, int b) {
	    while (b != 0) {
	        int temp = a % b;
	        a = b;
	        b = temp;
	    }
	    return a;
	}
}