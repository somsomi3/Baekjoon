import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
        int answer = 0;

		while(T-->0) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] count = new int[7];
			
			for(int j =0; j<4; j++) {
				int a = Integer.parseInt(st.nextToken());
				count[a]++;
			}
				
			int result =0;
//			int cnt =0;
//			int x = 0;			
//			int max =0;
			
			for(int i=1; i<=6; i++) {
				if(count[i]==4) {
					result+= (50000+i*5000);
					break;
				}
				if(count[i]==3) {
					result+= (10000+i*1000);
					break;
				}
			}
			
            if (result == 0) {
                int pairCount = 0;
                int sum = 0;
                int max = 0;

                for (int i = 1; i <= 6; i++) {
                    if (count[i] == 2) {
                        pairCount++;
                        sum += i;
                    }
                    if (count[i] == 1) {
                        max = Math.max(max, i);
                    }
                }

                if (pairCount == 2) {
                    result = 2000 + sum * 500;
                } else if (pairCount == 1) {
                    result = 1000 + sum * 100;
                } else {
                    result = max * 100;
                }
            }

            answer = Math.max(answer, result);
        }

        System.out.println(answer);
    }
}
