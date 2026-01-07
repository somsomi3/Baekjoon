import java.io.*;
import java.util.*;

public class Main {
	static class Person{
		int age;
		String name;
		Person(int age, String name){
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
        List<Person> list = new ArrayList<>();
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            
            list.add(new Person(x, s));
        }
		
		list.sort((a, b)-> a.age - b.age);
		
		StringBuilder sb = new StringBuilder();
        for (Person p : list) {
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }

        System.out.print(sb);
    }
}