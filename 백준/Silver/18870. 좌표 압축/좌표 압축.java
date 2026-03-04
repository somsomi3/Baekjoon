import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] copy = arr.clone();
        Arrays.sort(copy);

        //크기변경이 가능하게 하기위해서 list 사용
        ArrayList<Integer> list = new ArrayList<>();
        list.add(copy[0]);

        for(int i = 1; i < N; i++){
            if(copy[i] != copy[i-1]){
                list.add(copy[i]);
            }
        }

        int[] unique = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            unique[i] = list.get(i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int left = 0;
            int right = unique.length - 1;
            while(left <= right){

                int mid = left + (right - left) / 2;
                if(unique[mid] >= arr[i]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }

            sb.append(left).append(" ");
        }

        System.out.println(sb);
    }

}
