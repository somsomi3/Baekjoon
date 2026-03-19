import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N];
		//길이 변환 자유자재 = list사용해야함.
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
            int idx = lowerBound(list, arr[i]);

            if(idx == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(idx, arr[i]);
            }
            //list 문법 set = 덮어쓰기(교체_
            //add / set / get / size / contains        
        }
        System.out.println(list.size());		
	}
	 static int lowerBound(List<Integer> list, int key) {
	 //lowerBound = key 이상이 처음 나오는 위치
	        int left = 0, right = list.size() - 1;

	        while(left <= right) {
	            int mid = (left + right) / 2;

	            if(list.get(mid) < key) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return left;
	    }
}