import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N= Integer.parseInt(br.readLine());
		
//		String[] arr = new String[N];
//		StringTokenizer st = new StringTokenizer(br.readLine());
        for (int tc = 1; tc <= N; tc++) {
            String[] arr = br.readLine().split(" ");
//			arr= st.nextToken().split(" ");
//			arr = br.readLine().split(" ");//st.nextToken()으로는 받을 수 있지만, 이게더 직관적이다.
            
            StringBuilder sb = new StringBuilder();
    		for(int i =arr.length-1; i>=0; i--) {
    			sb.append(arr[i]).append(" ");
    		}
    			
    		System.out.println("Case #"+tc+": "+sb);
		}
		
		
		//reverse()로 함수를 사용할 수는 없나..?
	}
}
