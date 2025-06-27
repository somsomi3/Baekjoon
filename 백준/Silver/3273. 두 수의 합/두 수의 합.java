import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        int x = read();

        System.out.println(solution(arr, x));
    }

    private static int solution(int[] arr, int x) {
        int count = 0;

        // 사전 필터링: x보다 작은 수만 수집
        int[] filtered = Arrays.stream(arr)
                               .filter(i -> i < x)
                               .toArray();

        // 정렬
        Arrays.sort(filtered);

        // 투 포인터
        int left = 0;
        int right = filtered.length - 1;

        while (left < right) {
            int sum = filtered[left] + filtered[right];
            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    // 입력 빠르게 읽기
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
