import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        //각 수 ≤ 1,000,000
        //개수 제한 없음
        long sum = 0;

        for (String s : arr) {
            sum += Long.parseLong(s);
        }

        System.out.println(sum);
    }
}
