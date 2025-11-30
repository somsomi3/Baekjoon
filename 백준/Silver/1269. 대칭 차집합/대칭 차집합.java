import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;

        for (int x : aSet) {
            if (!bSet.contains(x)) count++;
        }
        for (int y : bSet) {
            if (!aSet.contains(y)) count++;
        }

        System.out.println(count);
    }
}
