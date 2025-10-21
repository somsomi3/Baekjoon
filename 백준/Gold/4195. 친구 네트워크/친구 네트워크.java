import java.io.*;
import java.util.*;

public class Main {
    static int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    static void union(int a, int b, int[] parent, int[] size) {
        a = find(a, parent);
        b = find(b, parent);
        if (a != b) {
            parent[b] = a;
            size[a] += size[b];
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            int index = 0;

            int[] parent = new int[F * 2];
            int[] size = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) map.put(a, index++);
                if (!map.containsKey(b)) map.put(b, index++);

                int aa = map.get(a);
                int bb = map.get(b);

                union(aa, bb, parent, size);
                sb.append(size[find(aa, parent)]).append('\n');
            }
        }
        System.out.print(sb);
    }
}
