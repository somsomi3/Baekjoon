import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =5;
		int[] cnt = new int[10];
		
		for(int i =0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(cnt[x]==0)cnt[x]++;
			else cnt[x]--;
		}
		
		for(int i=0; i<10; i++) {
			if(cnt[i]==1)System.out.println(i);
		}
		
	}
}
