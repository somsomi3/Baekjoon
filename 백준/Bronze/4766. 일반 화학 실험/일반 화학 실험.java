import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double x = Double.parseDouble(br.readLine());
        
		while (true) {
		    String s = br.readLine();
		    if (s.equals("999")) break;
		
//			double y = Double.parseDouble(br.readLine());
            double y = Double.parseDouble(s);
			
            System.out.printf("%.2f\n", y-x);
			
			x =y;
		}
		
	}
}
