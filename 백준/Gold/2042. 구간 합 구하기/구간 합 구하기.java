import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] tree;
    static int N;
	
	//init에서 구간합을 다 저장한다.
	static long init(int node, int start, int end) {
		//node = 트리 배열 인덱스
		
		if(start == end) return tree[node] = arr[start];
		//리프노드이면, 값을 그대로 저장한다.
		
		int mid = (start + end) /2;
		
		return  tree[node] =  init(node * 2, start, mid)
				+init(node * 2+1, mid +1, end);
	}
	
	//update : 값을 바꾸기
	static void update(int node, int start, int end, int idx, long diff) {
		if(idx< start || idx> end) return;
		
		tree[node] += diff;
		
		if(start != end) {
			int mid = (start + end)/2;
			
			update(node*2, start, mid, idx, diff);
			update(node*2+1, mid+1, end, idx, diff);
		}
	}
	
	//query: 원하는 구간의 합을 출력하는 것.= 꺼내기
	static long query(int node, int start, int end, int left, int right) {
		if (right < start || left > end) return 0;
		
		if (left <= start && end <= right) return tree[node];
		
		int mid = ( start + end ) / 2;
		return query(node * 2, start, mid, left, right)
				+query(node*2+1, mid+1, end, left, right);
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
        arr = new long[N + 1];
        tree = new long[4 * N];
        
        for(int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
		
		init(1, 1, N);
        
        StringBuilder sb = new StringBuilder();
        
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a==1) {
				long diff = c -arr[b];
				arr[b] = c;
				update(1, 1, N, b, diff);
				//출력
            } else {
                sb.append(query(1, 1, N, b, (int)c)).append("\n");
            }
        }

        System.out.print(sb);
    }
}