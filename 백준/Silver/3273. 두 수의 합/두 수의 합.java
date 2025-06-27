import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();         // 수열 길이
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();    // 수열 입력
        }
        int x = sc.nextInt();         // 찾을 합

        Arrays.sort(arr);             // 투 포인터를 위해 정렬

        int left = 0;
        int right = n - 1;
        int count = 0;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == x) {
                count++;
                left++;
                right--;
            } else if(sum < x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
