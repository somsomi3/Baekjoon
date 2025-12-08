class Solution {
    public String solution(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()){
            if(c==' '){
                sb.append(' ');
                continue;
            }
            if(c>='A'&& c<='Z'){
                c = (char)((c-'A' +n)%26+'A');
            }else if(c>='a'&& c<='z'){
                c = (char)((c-'a'+n)%26+'a');
            }
            sb.append(c);
        }
        return sb.toString();
    }
}