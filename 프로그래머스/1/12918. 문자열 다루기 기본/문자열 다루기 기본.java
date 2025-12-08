class Solution {
    public boolean solution(String s) {
        int len = s.length();
        
        boolean answer = false;
        int count=0;
        if(len==4||len==6){
            for(int i=0; i<10; i++){
                for(int j=0; j<len; j++){
                    if(i==s.charAt(j)-'0'){
                        count++;
                    }
                }

            }
        }
        if(count==len){
             answer = true;
        }
        return answer;
    }
}