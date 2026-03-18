import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] count = new int[4]; // A, C, G, T
        int ans = 0;
        
        // 초기 윈도우
        for(int i = 0; i < P; i++) {
            char ch = s.charAt(i);
            if(ch == 'A') count[0]++;
            else if(ch == 'C') count[1]++;
            else if(ch == 'G') count[2]++;
            else if(ch == 'T') count[3]++;
        }
        
        // 초기 조건 체크
        if(count[0] >= A && count[1] >= C && count[2] >= G && count[3] >= T) {
            ans++;
        }
        
        // 슬라이딩 윈도우: 한칸식 이동하기.
        for(int i = P; i < S; i++) {
            char add = s.charAt(i);
            char remove = s.charAt(i - P);
            
            if(add == 'A') count[0]++;
            else if(add == 'C') count[1]++;
            else if(add == 'G') count[2]++;
            else if(add == 'T') count[3]++;

            if(remove == 'A') count[0]--;
            else if(remove == 'C') count[1]--;
            else if(remove == 'G') count[2]--;
            else if(remove == 'T') count[3]--;
            
            // 조건 체크
            if(count[0] >= A && count[1] >= C && count[2] >= G && count[3] >= T) {
                ans++;
            }
        }
        
        System.out.println(ans);
    }
}