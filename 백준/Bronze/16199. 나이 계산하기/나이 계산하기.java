import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N= 2;
		
		int[] year = new int[N];
		int[] month = new int[N];
		int[] day = new int[N];
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			year[i] = Integer.parseInt(st.nextToken());
			month[i] = Integer.parseInt(st.nextToken());
			day[i]= Integer.parseInt(st.nextToken());
		}

		
		//만나이
		if(month[1]<month[0]||month[1]==month[0]&&day[1]<day[0]) {
			System.out.println(year[1]-year[0]-1);
		}else {
			System.out.println(year[1]-year[0]);
		}
		
		//세는나이
		System.out.println(year[1]-year[0]+1);
		
		//연나
		System.out.println(year[1]-year[0]);
	}
}
