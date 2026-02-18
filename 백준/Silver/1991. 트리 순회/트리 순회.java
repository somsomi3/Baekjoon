import java.io.*;
import java.util.*;

public class Main {
//	static List<String>[] graph;
	static char[][] tree;
	static boolean[] visited;
	static int N;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		tree = new char[N+1][2];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree[root - 'A'][0] = left;
			tree[root - 'A'][1] = right;
			
		}
//		전위
        pre('A');
        System.out.println();
        in('A');
        System.out.println();
        post('A');
		
		
	}
	static void pre(char node) {
		if(node =='.')return;
		
		System.out.print(node);
		pre(tree[node - 'A'][0]);
		pre(tree[node - 'A'][1]);
	}
	static void in(char node) {
		if(node =='.')return;
		
		in(tree[node - 'A'][0]);
		System.out.print(node);
		in(tree[node - 'A'][1]);
	}
	
	static void post(char node) {
		if(node =='.')return;
		
		post(tree[node - 'A'][0]);
		post(tree[node - 'A'][1]);
		System.out.print(node);
		
	}
	
}