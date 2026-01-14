import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        //1단계
        String s = new_id.toLowerCase();
        
        //2단계
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if((c>='a'&&c<='z')||
               (c>='0'&&c<='9')||
               (c=='-')|| (c=='_')||
               (c=='.')){
                sb.append(c);
            }
        }
        s = sb.toString();
        
        //3단계
        //new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 현재 문자가 '.'이고,
            // 이전에 넣은 문자도 '.'이면 → 건너뜀
            if (c == '.') {
                if (sb2.length() == 0 || sb2.charAt(sb2.length() - 1) != '.') {
                    sb2.append(c);
                }
            } else {
                sb2.append(c);
            }   
        }
        s = sb2.toString();
        
        //4단계
        if (!s.isEmpty() && s.charAt(0) == '.') {
            s = s.substring(1);
        }
        if (!s.isEmpty() && s.charAt(s.length() - 1) == '.') {
            s = s.substring(0, s.length() - 1);
        }
        
        
        //5단계
        if (s.isEmpty()) {
            s = "a";
        }
        
        //6단계
        if(s.length()>=16){
            s = s.substring(0, 15);
            if (s.charAt(s.length() - 1) == '.') {
                s = s.substring(0, s.length() - 1);
            }
        }
        while (s.length() < 3) {
            s += s.charAt(s.length() - 1);
        }

        return s;
    }
}
