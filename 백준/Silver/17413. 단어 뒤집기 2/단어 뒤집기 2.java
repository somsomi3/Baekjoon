import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean inside = false;

        for (int i = 0; i < s.length(); i++) { //c는 계속 증가한다. for안에 while넣지마
            char c = s.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                //이걸 해주는 이유는 gat<close> 이렇게 만났을 경우를 대비해서 
                //태그와 단어 사이에는 공백이 없다.는 조건때문에 gat을 뱉어 내려고 그러는 건
                inside = true;
                //<>안의 단어는 c를 그냥넣기. 근데 아직 c=='<'이다. 지금은 <에 있다.
                sb.append(c);
            } else if (c == '>') {
                inside = false;
                sb.append(c);
                //지금은 c ==<을 sb 에 더해준것.
            } else if (inside) {
            	//여기서는 <와 >의 사이이다. 진짜 <>안의 수들이다. 
            	//for안에서 i++이 되어서 c가 <,>둘다 아니지만 inside의 상태는 true로 바뀐 애들의 경우이다.
                sb.append(c);
                //sb에 순서대로 더해준다.
            } else {
            	//아예 <>밖의 경우, 뒤집은 숫자를 넣어야 할 경우이다.
                if (c == ' ') {
                	//띄어쓰기를 만나면, 이때까지 만났던 애들을 다 토해준다.
                    while (!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }
        }
        //마지막 단어는 끝까지 가도 공백이 없어서, 
        //남아있는 stack안의 것들을 토하게 해줘야 한다.
        while (!stack.isEmpty()) sb.append(stack.pop());
        
        
        System.out.println(sb.toString());
    }
}