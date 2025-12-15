import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//ArrayList 에 익숙해지자.
		ArrayList<Integer> sam = new ArrayList<>();
		for(int i =1; i<=45; i++) {
			sam.add(i*(i+1)/2);
		}
		
		int T = Integer.parseInt(br.readLine());
		
        StringBuilder sb = new StringBuilder();
		while(T-->0) {
            int K = Integer.parseInt(br.readLine());
            boolean ok = false;

			for(int i=0; i< sam.size(); i++) {
				for(int j =0; j<sam.size(); j++) {
					for(int k=0; k<sam.size(); k++) {
						if(sam.get(i)+ sam.get(j)+sam.get(k)==K) {
                            ok = true;
                            break;
						}
					}
                    if (ok) break;
				}
                if (ok) break;
			}
		  sb.append(ok ? 1 : 0).append('\n');
		}

    System.out.print(sb);
	}
}
