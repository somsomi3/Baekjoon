import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String r = br.readLine();
		
		int[] arr = new int[26];
        Arrays.fill(arr, -1);
        
		for(int i =0; i<r.length(); i++) {
			char c = r.charAt(i);
			if(arr[c-'a']==-1) {
				arr[c-'a']=i;
			}

		}
		for(int i =0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
