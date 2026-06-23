class Solution {
    public int solution(int[] wallet, int[] bill) {

        int cnt = 0;

        int walletWidth = wallet[0];
        int walletHeight = wallet[1];

        int billWidth = bill[0];
        int billHeight = bill[1];

        while (true) {

            // 지폐를 회전했을 때까지 고려하여 지갑에 들어가는지 확인
            boolean canFit =
                    (billWidth <= walletWidth && billHeight <= walletHeight)
                 || (billHeight <= walletWidth && billWidth <= walletHeight);

            if (canFit) {
                break;
            }

            // 더 긴 변을 반으로 접기
            if (billWidth >= billHeight) {
                billWidth /= 2;
            } else {
                billHeight /= 2;
            }

            cnt++;
        }

        return cnt;
    }
}