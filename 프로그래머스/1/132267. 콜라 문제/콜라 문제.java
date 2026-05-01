class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int x = n;

        while (x >= a) {
            int num = x / a;
            int namuge = x % a;
            int get = num * b;

            answer += get;
            x = get + namuge;
        }

        return answer;
    }
}