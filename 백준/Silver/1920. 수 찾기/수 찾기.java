import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);  // 이분 탐색 위해 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (binarySearch(arr, x)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.print(sb);
    }

    static boolean binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) 
                return true;
            else if (arr[mid] < target) 
                left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
