import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Soongsil", Integer.parseInt(st.nextToken()));
        map.put("Korea", Integer.parseInt(st.nextToken()));
        map.put("Hanyang", Integer.parseInt(st.nextToken()));

        int sum = 0;
        for (int v : map.values()) {
            sum += v;
        }

        if (sum >= 100) {
            System.out.println("OK");
            return;
        }

        String minSchool = "";
        int minScore = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() < minScore) {
                minScore = entry.getValue();
                minSchool = entry.getKey();
            }
        }

        System.out.println(minSchool);
    }
}
