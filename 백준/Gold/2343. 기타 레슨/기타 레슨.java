import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int N, M;
	static int sum =0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
        int left = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            left = Math.max(left, arr[i]);   //최소값은 최대 강의 길이
        }
		//한개는 무조건 들어가야 하므로, 그중에서 최소 값을 left로 둬야한다. 어제 푼 용돈관리랑 같음 
        
        int right = sum;
        //ans가 sum부터 시작하는 이유는, mid중에 가장 큰 값이라.
        int ans = sum;
		
		while(left<=right) {
            int mid = (left + right) / 2;
		
            if(canCut(mid)) {
            	//M개 이하로도 가능하면, 더 쪼개서(= mid가 더 작아져야함.) M개로 만드는 건 언제든 가능하기 때문
                ans = mid;
                right = mid - 1;// 갯수가 작거나 같다는 것은, 합계가 너무 크다는 것. 따라서 범위를 줄여야한다. 
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
	}
	static boolean canCut(int mid) {
		//무조건 2개 들어가 있음.
        int count = 1;
        int cutSum = 0;

		for(int i= 0; i<N; i++) {
            if(cutSum + arr[i] > mid) {
                count++;
                cutSum = arr[i];
            } else {
                cutSum += arr[i];
            }
        }

        return count <= M;//M개 이하로도 가능하면, 더 쪼개서 M개로 만드는 건 언제든 가능하기 때문
	}

}