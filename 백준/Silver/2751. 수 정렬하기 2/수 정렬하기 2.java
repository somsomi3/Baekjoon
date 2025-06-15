import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] arr = new int[N]; // 입력 수를 저장할 배열

        // N번 숫자 입력
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // O(N log N) 정렬 수행 (기본: Dual-Pivot QuickSort)

        // 정렬된 결과 출력
        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush(); // 버퍼 비우기
        bw.close(); // 닫기
    }
}
