class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int same = 0;
        int cha = 0;
        char x = 0;
        
        for(int i = 0; i< s.length(); i++){
             if (same == 0) { // 새로운 문자열 시작
                x = s.charAt(i);
                same = 1;
                cha = 0;
            } else {
                if (s.charAt(i) == x) {
                    same++;
                } else {
                    cha++;
                }
            }

            if (same == cha) {
                answer++;
                same = 0;
                cha = 0;
            }
        }
        
        // 남은 문자열 처리
        if (same != 0) {
            answer++;
        }

        return answer;
    }
}