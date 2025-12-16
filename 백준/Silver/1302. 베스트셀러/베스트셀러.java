import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        int max = 0;
        String answer = "";

        for (String key : map.keySet()) {
            int cnt = map.get(key);

            if (cnt > max || (cnt == max && key.compareTo(answer) < 0)) {
                max = cnt;
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
