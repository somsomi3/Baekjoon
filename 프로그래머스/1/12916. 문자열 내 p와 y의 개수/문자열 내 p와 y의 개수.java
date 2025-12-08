class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        int countp = 0;
        int county = 0;
        for(int i=0; i<len; i++){
            char x = s.charAt(i);
            if (x == 'P' || x == 'p') {
                countp++;
            } else if (x == 'Y' || x == 'y') {
                county++;
            }
        }
        if(countp==county){
            answer = true;
        }else{
            answer = false;
        }


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        return answer;
    }
}