import java.io.*; 
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count =0;
		while (true) {
		    count++;
			StringTokenizer st = new StringTokenizer(br.readLine());
		    int L = Integer.parseInt(st.nextToken());
		    int P = Integer.parseInt(st.nextToken());
		    int V = Integer.parseInt(st.nextToken());

		    if (L == 0 && P == 0 && V == 0) break;
		    
			int sum =0;
		    
		    int x = V/P;
		    int y= V%P;
		    
		    sum += x*L;
		    if(y<L) {
		    	sum+= y;
		    }else sum+=L;
		    
			System.out.println("Case "+count+": "+sum);
		}
	}
}