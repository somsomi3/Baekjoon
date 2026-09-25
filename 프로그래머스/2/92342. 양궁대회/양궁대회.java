class Solution {
    int[] ans = {-1};
    int max = 0;

    public int[] solution(int n, int[] brr) {
        dfs(0, n, new int[11], brr);
        return ans;
    }

    void dfs(int idx, int n, int[] arr, int[] brr) {
        if (idx == 10) {
            arr[10] = n;
            int chai = 0;

            for (int i = 0; i < 10; i++) {
                if (arr[i] > brr[i]) {
                    chai += 10 - i;
                } else if (brr[i] > 0) {
                    chai -= 10 - i;
                }
            }

            if (chai > 0) {
                if (chai > max) {
                    max = chai;
                    ans = new int[11];

                    for (int i = 0; i < 11; i++) {
                        ans[i] = arr[i];
                    }
                } else if (chai == max) {
                    for (int i = 10; i >= 0; i--) {
                        if (arr[i] == ans[i]) continue;

                        if (arr[i] > ans[i]) {
                            ans = new int[11];
                            for (int j = 0; j < 11; j++) {
                                ans[j] = arr[j];
                            }
                        }
                        break;
                    }
                }
            }
            arr[10] = 0;
            return;
        }

        int cnt = brr[idx] + 1;

        //점수 얻기
        if (n >= cnt) {
            arr[idx] = cnt;
            dfs(idx + 1, n - cnt, arr, brr);
            arr[idx] = 0;
        }
        //점수포기
        dfs(idx + 1, n, arr, brr);
    }
}