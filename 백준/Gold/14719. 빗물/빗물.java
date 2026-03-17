import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //인덱스 값이라서 0이랑 N-1로 하는 것이다.
        int l = 0;
        int r = W - 1;

        int leftMax = arr[l];
        int rightMax = arr[r];

        int answer = 0;

        while (l < r) {
            if (leftMax <= rightMax) {
                l++;
                if (arr[l] < leftMax) {
                    answer += leftMax - arr[l];
                } else {
                    leftMax = arr[l];
                }
            } else {
                r--;
                if (arr[r] < rightMax) {
                    answer += rightMax - arr[r];
                } else {
                    rightMax = arr[r];
                }
            }
        }
        System.out.println(answer);
    }
}