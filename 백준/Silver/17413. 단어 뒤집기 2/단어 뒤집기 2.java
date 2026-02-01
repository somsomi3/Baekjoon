import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		int N = s.length();
		
		Stack<Character> st = new Stack<>();
		boolean inTag = false;
		
		for(int i =0; i<N; i++) {
			char c = s.charAt(i);
			
			//태그 안과 태그에 대하여
			if (c == '<') {
				//스택안에 많이 있다면
				while (!st.isEmpty()) sb.append(st.pop());
                inTag = true;
                //<를 더해줘라
                sb.append(c);
            }
            else if (c == '>') {
                inTag = false;
                sb.append(c);
            } 
            else if (inTag) {
            	//태그안인데 <도 아니고 >도 아니라면
            	//즉, <>안에 있는 모든 문자일 경우
                sb.append(c);
            } 
			
			//태그 밖
            else {
                if (c == ' ') {
                    while (!st.isEmpty()) sb.append(st.pop());
                    sb.append(' ');
                } else {//태그 밖에서 공백도 아닌문자라면
                    st.push(c);
                }
            }
        }

        while (!st.isEmpty()) sb.append(st.pop());

        System.out.println(sb.toString());
    }
}