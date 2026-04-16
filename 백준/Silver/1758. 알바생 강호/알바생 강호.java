import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Integer[] tips = new Integer[n];
        for (int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tips, Collections.reverseOrder());

        long totalTip = 0;
        for (int order = 0; order < n; order++) {
            int adjustedTip = tips[order] - order;
            if (adjustedTip > 0) totalTip += adjustedTip;
        }

        System.out.println(totalTip);
    }
}