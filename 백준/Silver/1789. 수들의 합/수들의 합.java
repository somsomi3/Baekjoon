import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		
		long count = 0;
		for (long i = 1; ;i++){
			if(i<=S) {
				S-=i;
				count++;
			}else {
				break;
			}
		}
		System.out.println(count);
	}

}
