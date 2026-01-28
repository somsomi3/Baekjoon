import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                count +=set.size();
                set.clear();
            } else {
                set.add(s);
            }
        }
        count += set.size();
        
        System.out.println(count);
    }
}
