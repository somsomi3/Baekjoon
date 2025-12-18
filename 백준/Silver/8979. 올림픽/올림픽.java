import java.io.*;
import java.util.*;

public class Main {
    static class Medal {
        int id;
        int gold;
        int silver;
        int bronze;

        Medal(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Medal> list = new ArrayList<>();
        Medal target = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Medal m = new Medal(id, g, s, b);
            list.add(m);

            if (id == K) target = m;
        }

        int rank = 1;

        for (Medal m : list) {
            if (m.id == K) continue;

            if (m.gold > target.gold ||
               (m.gold == target.gold && m.silver > target.silver) ||
               (m.gold == target.gold && m.silver == target.silver && m.bronze > target.bronze)) {
                rank++;
            }
        }

        System.out.println(rank);
    }
}
