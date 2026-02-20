import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long x = Long.parseLong(br.readLine());
		
		long xx = 1;
		for(int i =1; i<=x; i++) {
			xx*=i;
		}
		
		long ans = xx/604800;
		
		System.out.println(ans);
	}
}
