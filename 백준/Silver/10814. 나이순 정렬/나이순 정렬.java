import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int age;
        String name;

        Edge(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		List<Edge> list = new ArrayList<>();
		
		//맵은 인덱스가 없어서 ArrayList로 저장해보자!
		for(int i = 0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
			
            list.add(new Edge(age, name));
		}
		//어차피 나이만 정렬하면, 위의 입력에서 인덱스 순으로 들어갔기 때문에 2차적으로 인덱스대로 정렬된다.
		Collections.sort(list, (a, b)-> a.age - b.age);
		
		StringBuilder sb = new StringBuilder();
		
		for(Edge x : list) {
			sb.append(x.age).append(" ").append(x.name).append('\n');
		}
		
		System.out.println(sb);
	}
}
