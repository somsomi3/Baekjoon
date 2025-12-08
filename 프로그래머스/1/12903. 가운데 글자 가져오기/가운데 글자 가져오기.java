class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len % 2 == 0) {
            return "" + arr[len/2 - 1] + arr[len/2];
        } else {
            return "" + arr[len/2];
        }
    }
}