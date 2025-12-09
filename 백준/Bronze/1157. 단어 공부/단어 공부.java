import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int[] cnt = new int[26];
		
		for(int i =0; i<s.length(); i++) {
			int x = Character.toUpperCase(s.charAt(i)) - 'A';
			cnt[x]++;
		}
		
		int max =0;
		int bigans=0;
		boolean flag = true;
		for(int i =0; i<26;i++) {
			if(cnt[i]>max) {
				max=cnt[i];
				bigans =i;
				
			}
		}
		//밖에서 또 for을 돌려서 확인해야함. 그래야 max값이 몇개인지 찾을 수 있다.
		int maxVs = 0;
		for(int i =0; i<26;i++) {
			if(cnt[i]==max) {
				maxVs++;
			}
		}
		if(maxVs>1)System.out.println("?");
		else System.out.println((char)(bigans+'A'));
	}
}