import java.io.*;
import java.util.*;

public class Main {
    static class Line implements Comparable<Line> {
        int a, b;

        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line other) {
            return this.a - other.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a, b);
        }

        //정렬
        Arrays.sort(lines);


        int[] bArr = new int[N];
        for (int i = 0; i < N; i++) bArr[i] = lines[i].b;


        int[] lis = new int[N];
        int[] pos = new int[N]; 
        int len = 0;

        for (int i = 0; i < N; i++) {
            int b = bArr[i];
            int idx = lowerBound(lis, 0, len, b);
            lis[idx] = b;
            pos[i] = idx;
            if (idx == len) len++;
        }

        boolean[] isInLIS = new boolean[N];
        int target = len - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (pos[i] == target) {
                isInLIS[i] = true;
                target--;
                if (target < 0) break;
            }
        }

        bw.write((N - len) + "\n");

        ArrayList<Integer> removeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!isInLIS[i]) {
                removeList.add(lines[i].a);
            }
        }

        Collections.sort(removeList);
        for (int a : removeList) {
            bw.write(a + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    //이분 탐색
    static int lowerBound(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}
