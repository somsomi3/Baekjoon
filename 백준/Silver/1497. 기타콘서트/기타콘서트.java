import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static long[] guitar;
    static int maxSong = 0;
    static int minGuitar = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        guitar = new long[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            String s = st.nextToken();


            //비트마스크
            long mask = 0;
            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == 'Y') {
                	//연주가능한 자리를 1로 만들기
                    mask |= (1L << j);
                }
            }
            //기타에 저장
            guitar[i] = mask;
        }

        //인덱스, 상태, 기타수
        dfs(0, 0L, 0);

        if(maxSong == 0) System.out.println(-1);
        else System.out.println(minGuitar);
    }

    static void dfs(int idx, long mask, int cnt) {

    	//모든 기타를 확인하면 종료.
        if(idx == N) {
        	int song = 0;

            for(int i = 0; i < M; i++){
                if((mask & (1L << i)) != 0){
                    song++;
                }
            }

            if(song > maxSong) {
                maxSong = song;
                minGuitar = cnt;
            }
            else if(song == maxSong) {
                minGuitar = Math.min(minGuitar, cnt);
            }

            return;
        }

        dfs(idx + 1, mask | guitar[idx], cnt + 1);
        dfs(idx + 1, mask, cnt);
    }
}
