import java.io.*;
import java.util.*;

public class Main {
	static class Lecture{
		int start, end;
		Lecture(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//데이터 묶음
		//배열이 리스트 보다 빠르고 간단
		Lecture[] arr= new Lecture[N];
		
		
		for(int i =0; i< N; i++) {
			//여러줄에 걸쳐서 강의 가 들어오므로 StringTokenizer가 for문 안에 있도록 한다.
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i] = new Lecture(a, b);
		}
		
		Arrays.sort(arr, (x, y)->{
			if(x.start ==y.start)return x.end- y.end;
			return x.start - y.start;
		});
		
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(arr[0].end);

        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 강의
            if (pq.peek() <= arr[i].start) {
                pq.poll(); // 재사용
            }
            pq.offer(arr[i].end);
        }

        System.out.println(pq.size());
    }
}