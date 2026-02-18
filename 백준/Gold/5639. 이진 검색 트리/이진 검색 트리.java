import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null) {
            list.add(Integer.parseInt(s));
        }

        solve(0, list.size() - 1);
        System.out.print(sb);
    }

    static void solve(int start, int end) {
        if (start > end) return;
        int root = list.get(start);
        int cut = start + 1;
             
        //왼쪽 subtree가 끝나는 지점 찾는 코드
        while (cut <= end && list.get(cut) < root) {//배열범위와 경계
            cut++;
        }

        solve(start + 1, cut - 1);
        solve(cut, end);
        sb.append(root).append("\n");
    }
}
