import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] prev = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }
        
        //LIS의 마지막 자리 찾기
        int maxLen = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                idx = i;
            }
        }

        //마지막 자리인 idx부터 prev로 앞자리 다 찾아서 stack에 넣기.
        Stack<Integer> stack = new Stack<>();
        while (idx != -1) {
            stack.push(arr[idx]);
            idx = prev[idx];
        }

        //stack출력
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(maxLen);
        System.out.println(sb.toString().trim());
    }
}