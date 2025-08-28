import java.io.*;
import java.util.*;

public class Main {
    static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (list.get(mid) < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> lis = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            int idx = lowerBound(lis, x);
            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x); //기존값대체
            }
        }

        System.out.println(lis.size());
    }
}
