import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//순서는 상관없어!! 두개가 있으면 두개로 쳐주면 되니깐! 정렬 해도되고 뒤섞어도될거같아..
		Arrays.sort(arr);
		
		//슬라이딩? 아니고 투포인터라서, 초기 배열은 상관없음.
		
//		int start =0;
//		int end = N-1;
		int count = 0;
		
		for(int i =0; i<N; i++) {
			int start =0;
			int end = N-1;
			while(start<end) {
		        if(start == i) { 
		            start++;
		            continue;
		        }
		        if(end == i) {
		            end--;
		            continue;
		        }
				
				int sum = arr[start]+ arr[end];
//				System.out.println(sum);
				if(sum== arr[i]&& !visited[i]) {
//					System.out.println("arr[i]="+arr[i]);
					count++;
					visited[i]=true;
//					System.out.println("후"+count);
					start++;
					end--;
				}else if(sum>arr[i]) {
					end--;
				}else {
					start++;
				}
			}			
		}
		System.out.println(count);
	}
}