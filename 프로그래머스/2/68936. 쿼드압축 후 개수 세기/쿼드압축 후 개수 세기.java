class Solution {
    int[] ans = new int[2];

    public int[] solution(int[][] arr) {
        nanugi(arr, 0, 0, arr.length);
        return ans;
    }

    void nanugi(int[][] arr, int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != arr[x][y]) {
                    int m = n / 2;

                    nanugi(arr, x, y, m);
                    nanugi(arr, x, y + m, m);
                    nanugi(arr, x + m, y, m);
                    nanugi(arr, x + m, y + m, m);
                    return;
                }
            }
        }

        ans[arr[x][y]]++;
    }
}