import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 뒤에서부터 증가가 깨지는 지점 찾기
        int i = N - 2;
        while(i >= 0 && arr[i] >= arr[i + 1]) {
        	i--;
        }

        // 예외: 전체가 내림차순이면 -1
        if(i < 0) {
            System.out.println(-1);
            return;
        }

        // arr[i]보다 큰 값 중 가장 작은 값 찾기
        int j = N - 1;
        while(arr[i] >= arr[j]) j--;

        // swap
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        //증가가 깨지는 지점을 찾았기 때문에
        //reverse하면 자동으로 오름차순이 됨.
        
        // i+1부터 끝까지 뒤집기
        int left = i + 1;
        int right = N - 1;

        while(left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < N; k++) {
            sb.append(arr[k]).append(" ");
        }
        System.out.println(sb);
    }
}