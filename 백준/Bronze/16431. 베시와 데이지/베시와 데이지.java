import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//베시. 데이지. 존
		//베시: 대각선 가능
		//데이지: 대각선 불가능
		StringTokenizer st = new StringTokenizer(br.readLine());
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int j1 = Integer.parseInt(st.nextToken());
		int j2 = Integer.parseInt(st.nextToken());
		
		int bj = Math.max(Math.abs(b1-j1), Math.abs(b2-j2));
		
		int dj = Math.abs(d1-j1)+Math.abs(d2-j2);
		
		if(bj>dj)System.out.println("daisy");
		else if(dj>bj)System.out.println("bessie");
		else System.out.println("tie");
		
	}
}
