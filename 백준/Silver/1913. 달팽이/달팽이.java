import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
//방향수정
    static int[] dx = {-1, 0, 1, 0}; // 위, 오른, 아래, 왼
    static int[] dy = {0, 1, 0, -1};
	static int N, M;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		// 시작 위치: 중앙
		int x = N / 2;
		int y = N / 2;
		int num = 1;
		arr[x][y] = num;

		int len = 1;  // 한 방향으로 이동할 칸 수
		int dir = 0;  // 0: 하, 1: 우, 2: 상, 3: 좌
		
		while (num < N * N) {
			for (int i = 0; i < 2; i++) { // 같은 거리로 두 번 이동
				for (int j = 0; j < len; j++) {
                    if (num == N * N) break;
					x += dx[dir];
					y += dy[dir];
					num++;
//범위제한 제거
					arr[x][y] = num;
//
				}
				dir = (dir + 1) % 4; // 방향 전환 (하→우→상→좌)
			}
			len++; // 이동 거리 증가
		}

		// 출력 및 M의 좌표 찾기
		StringBuilder sb = new StringBuilder();
		int nX = 0, nY = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
				if (arr[i][j] == M) {
					nX = i + 1;
					nY = j + 1;
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		System.out.println(nX + " " + nY);
	}
}
