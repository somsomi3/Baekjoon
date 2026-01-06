import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int lcount = 0;//왼쪽에서 봣을때
		int rcount = 0;//오른쪽에서 봣을때
		int lmax =0;//시야를 방해하는 중간에 솟은 값
		int rmax =0;//시야를 방해하는 중간에 솟은 값
		for(int i =0; i<N; i++) {
			if(lmax<arr[i]) {
				lcount++;
				lmax = Math.max(lmax, arr[i]);
			}
		}
//		for(int i =N-1; i>0; i--) {		
		for(int i = N-1; i >= 0; i--) {// 0을 봐야함!!
			if(rmax<arr[i]) {
				rcount++;
				rmax = Math.max(rmax, arr[i]);
			}
		}
		System.out.println(lcount);
		System.out.println(rcount);		
	}
}
