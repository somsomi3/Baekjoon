import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int idx1 = -1;
        int idx2 = -1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("KBS1")) idx1 = i;
            if (s.equals("KBS2")) idx2 = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < idx1; i++) sb.append("1");
        for (int i = 0; i < idx1; i++) sb.append("4");

        if (idx2 < idx1) idx2++;

        for (int i = 0; i < idx2; i++) sb.append("1");
        for (int i = 0; i < idx2 - 1; i++) sb.append("4");

        System.out.println(sb.toString());
    }
}