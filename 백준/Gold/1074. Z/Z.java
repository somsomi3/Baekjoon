import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int count = 0; // 방문 순서
    static int r, c;      // 찾을 위치
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        
        z(size, 0, 0);
        
        System.out.println(result);
    }

    // 분할정복 함수
    static void z(int size, int row, int col) {
        if (size == 1) {
            // 1x1이면 현재 count가 답
            result = count;
            return;
        }

        int half = size / 2;

        // r, c가 어느 사분면에 있는지 확인
        if (r < row + half && c < col + half) {
            // 1사분면 (왼쪽 위)
            z(half, row, col);
        } else if (r < row + half && c >= col + half) {
            // 2사분면 (오른쪽 위)
            count += half * half * 1;
            z(half, row, col + half);
        } else if (r >= row + half && c < col + half) {
            // 3사분면 (왼쪽 아래)
            count += half * half * 2;
            z(half, row + half, col);
        } else {
            // 4사분면 (오른쪽 아래)
            count += half * half * 3;
            z(half, row + half, col + half);
        }
    }
}
