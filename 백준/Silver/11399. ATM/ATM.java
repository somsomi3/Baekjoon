import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int sum = 0;
        int ans = 0;
        for(int i = 0; i < N; i++) {
            sum += array[i];
            ans += sum;
        }

        // 출력
        bw.write(String.valueOf(ans));
        bw.newLine();  // 줄바꿈 (옵션)
        bw.flush();    // 반드시 flush!
        bw.close();    // 자원 반납 (권장)
    }
}
