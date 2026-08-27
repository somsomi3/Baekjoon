import java.util.*;

class Solution {
    public int solution(String str) {
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i) + str.substring(0, i);
            if (c(s)) ans++;
        }
        return ans;
    }

    boolean c(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char up = stack.pop();

            if (ch == ')' && up != '(') return false;
            if (ch == '}' && up != '{') return false;
            if (ch == ']' && up != '[') return false;
        }
        return stack.isEmpty();
    }
}