import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        
        int answer = 0;
        for (int i = 0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
            int R = Integer.parseInt(st.nextToken());
            String doc= st.nextToken();
            
            for(char c: doc.toCharArray()) {
            	for(int k=0; k<R; k++) {
            		sb.append(c);
            	}
            }
            
            sb.append("\n");
        }
        System.out.print(sb);
    }

}