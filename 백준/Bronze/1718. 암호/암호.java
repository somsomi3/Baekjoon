import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String Fung = br.readLine();
		String Arm = br.readLine();

		for(int i = 0; i< Fung.length(); i++) {
			if(Fung.charAt(i)==' ') {
				sb.append(" ");
			}
			else{
				int a = Fung.charAt(i) - 'a';
                int b = Arm.charAt(i % Arm.length()) - 'a';

                int z = (a - b - 1 + 26) % 26;

                sb.append((char)(z + 'a'));
			}
		}
		System.out.println(sb.toString());
	}
}
