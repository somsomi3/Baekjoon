import java.io.*;
import java.util.*;

public class Main {
	static class Score{
		int idx, val;
		Score(int idx, int val){
			this.idx = idx;
			this.val = val;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		List<Score> list = new ArrayList<>();
		
		for(int i =1; i<=8; i++) {
			list.add(new Score(i, Integer.parseInt(br.readLine())));
			
		}
	
		list.sort((a, b)-> b.val-a.val);
		
		int sum = 0;
		List<Integer>ans = new ArrayList<>();
		
		for(int i =0; i<5; i++) {
			sum+= list.get(i).val;
			ans.add(list.get(i).idx);
		}
        Collections.sort(ans);

        System.out.println(sum);
        for (int x : ans) System.out.print(x + " ");
    }
}
