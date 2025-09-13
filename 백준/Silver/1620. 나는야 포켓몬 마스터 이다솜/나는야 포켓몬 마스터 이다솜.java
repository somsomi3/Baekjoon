import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName[i] = name;
        }

        for (int i = 0; i < M; i++) {
            String q = br.readLine();

            if (Character.isDigit(q.charAt(0))) {
                sb.append(numToName[Integer.parseInt(q)]).append("\n");
            } else {
                sb.append(nameToNum.get(q)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
