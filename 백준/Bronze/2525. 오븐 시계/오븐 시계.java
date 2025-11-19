import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 현재 시간 입력 (A: 시, B: 분)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 요리하는 데 필요한 시간 (C: 분)
        int C = Integer.parseInt(br.readLine());

        br.close(); // 입력 스트림 닫기

        // **분 단위 합산**
        B += C;

        // **60분 이상이면 시(hour)로 변환**
        A += B / 60;  // 시간 증가
        B = B % 60;    // 남은 분만 저장

        // **24시간 포맷으로 변환**
        if (A >= 24) {
            A -= 24;
        }

        // **출력**
        System.out.println(A + " " + B);
    }
}
