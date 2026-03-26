import java.io.*;
import java.util.*;

public class Main {
    static String[] Ns;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Ns = new String[N];

        for (int i = 0; i < N; i++) {
            Ns[i] = br.readLine();
        }

        Arrays.sort(Ns); // 문자열 정렬

        List<String> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String target = br.readLine();

            if (binarySearch(target)) {
                result.add(target);
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }

    static boolean binarySearch(String target) {
        int left = 0;
        int right = Ns.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int cmp = Ns[mid].compareTo(target);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}