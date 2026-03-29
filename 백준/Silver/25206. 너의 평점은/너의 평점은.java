import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Double>map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		
		double sumAll = 0;
		double sum = 0;
		
		for(int i = 0; i < 20; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    
		    String name = st.nextToken();
		    double time = Double.parseDouble(st.nextToken());
		    String score = st.nextToken();
		    if(score.equals("P")) continue;
		    
		    sum += time;
		    double x = map.get(score);
		    sumAll += time * x;
		    
		}
		double result = sumAll / sum;

		System.out.printf("%.6f\n", result);

	}
}
