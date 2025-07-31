import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 중심 거리 제곱
            int dx = x1 - x2;
            int dy = y1 - y2;
            int distSq = dx * dx + dy * dy;

            int rSum = r1 + r2;
            int rDiff = Math.abs(r1 - r2);
            int rSumSq = rSum * rSum;
            int rDiffSq = rDiff * rDiff;

            int result = 0;

            if (distSq == 0 && r1 == r2) {
                // 두 원이 완전히 겹침
                result = -1;
            } else if (distSq > rSumSq || distSq < rDiffSq) {
                // 멀리 떨어져 있거나, 한 원이 다른 원 안에 있음 (교점 0개)
                result = 0;
            } else if (distSq == rSumSq || distSq == rDiffSq) {
                // 외접 또는 내접 (교점 1개)
                result = 1;
            } else {
                // 두 점에서 만남
                result = 2;
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
