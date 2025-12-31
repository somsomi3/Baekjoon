import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

	    int[] score = new int[3];
    	for (int i = 0; i < 3; i++) {
    		score[i] = Integer.parseInt(st.nextToken());
        }
	    
    	int sum = score[0]+score[1]+score[2];
    	

        if (sum >= 100) {
            System.out.println("OK");
            return;
        }
        
        //그게 아니라면
        int minIdx = 0;
        for(int i =1; i<3; i++) {
        	if(score[i]<score[minIdx]) {
        		minIdx = i;
        	}
        }
        
        String[] nara  = {"Soongsil", "Korea", "Hanyang"};
        System.out.println(nara[minIdx]);
        
    	
	 }
}