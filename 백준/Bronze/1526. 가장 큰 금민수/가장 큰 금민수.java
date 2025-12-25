import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean flag;
		
		for(int i=N; i>0; i--) {
			int x = i;
			flag = true;
			while(x>0) {
				if(x%10!=4 && x%10!=7) {
					flag = false;
					break;
				}
				x = x/10;
			}
            if (flag) {
                System.out.println(i);
                break;
            }
			
		}

	}
}