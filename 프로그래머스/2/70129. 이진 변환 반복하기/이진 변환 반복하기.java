class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int cnt = 0;
        int zero = 0;
        
        while(!s.equals("1")){
            int one = 0;
            
            // 1의 개수 세기
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') one++;
                else zero++;
            }
            
             s = toBinary(one);
            cnt++;
        }
        
        return new int[]{cnt, zero};
    }
    
    String toBinary(int n) {
        String res = "";
        
        for (; n > 0; n /= 2) {
            res = (n % 2) + res;
        }
        
        return res;
    }
}