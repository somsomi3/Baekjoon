import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int king = 1- Integer.parseInt(st.nextToken());
		int queen =1- Integer.parseInt(st.nextToken());
		int look = 2 - Integer.parseInt(st.nextToken());
		int bi = 2- Integer.parseInt(st.nextToken());
		int night = 2 -Integer.parseInt(st.nextToken());
		int poon = 8 -Integer.parseInt(st.nextToken());

		
		System.out.println(king+" "+queen+" "+look+" "+bi+" "+night+" "+poon);

	}
}
