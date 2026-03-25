import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            if (s == null || s.isEmpty()) break;
            list.add(Integer.parseInt(s));
        }
        postOrder(0, list.size() - 1);
    }

    static void postOrder(int start, int end) {
        if (start > end) return;

        int root = list.get(start);

        int idx = start + 1;

        // 오른쪽시작지점 찾기
        while (idx <= end && list.get(idx) < root) {
            idx++;
        }

        // 왼쪽
        postOrder(start + 1, idx - 1);

        // 오른쪽
        postOrder(idx, end);

        // 루트 출력
        System.out.println(root);
    }
}