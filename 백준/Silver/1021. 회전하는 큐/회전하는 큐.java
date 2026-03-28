import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
			
		Deque<Integer> dq = new LinkedList<>();
		
        for(int i = 1; i<=N; i++) {
        	dq.add(i);
        }
        
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        while(M -->0) {
        	
        	int x = Integer.parseInt(st.nextToken());
        	
        	//위치 찾기
        	int idx = 0;
        	for(int ind: dq) {
        		if(ind == x) {
        			break;
        		}else idx++;
        	}
        	//위치에 따라 /2 위치 별로 분리
        	
        	if(idx <= dq.size()/2) {
        		//반보다 적을때
        		 while(dq.peekFirst() != x) {
                     dq.addLast(dq.pollFirst());
                     cnt++;
                 }
        	}else {
        		while(dq.peekFirst()!= x) {
        			dq.addFirst(dq.pollLast());
        			cnt++;
        		}
        		
        	}
        	dq.pollFirst();
        }
        System.out.println(cnt);
	}
}