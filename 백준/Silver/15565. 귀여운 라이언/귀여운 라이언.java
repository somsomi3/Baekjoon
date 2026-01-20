import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        int minmin = 1_000_001;

        while (true) {
//        	int num = arr[right];
            if (count < K) { //K개 미만이면 오른쪽 확장
                if (right == N) break; //확장 불가 → 종료
                if (arr[right] == 1) count++;
                right++;
            } 
            else { // K개 이상이면 최소길이갱신 및 왼쪽축소
                minmin = Math.min(minmin, right - left);
                if (arr[left] == 1) count--;
                left++;
            }
        }

        System.out.println(minmin == 1_000_001 ? -1 : minmin);
    }
}
