import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 5;
		
		char[][] graph = new char[N][15];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j);
            }
        }
		
        StringBuilder sb = new StringBuilder();
		
		for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (graph[i][j] != '\0') {
                    sb.append(graph[i][j]);
                }
            }
        }

        System.out.print(sb.toString());
    }
}