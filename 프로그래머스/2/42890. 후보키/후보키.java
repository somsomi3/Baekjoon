import java.util.*;

class Solution {
    public int solution(String[][] relation) {

        int row = relation.length;
        int col = relation[0].length;

        List<Integer> arr = new ArrayList<>();

        for (int bit = 1; bit < (1 << col); bit++) {
            HashSet<String> set = new HashSet<>();

            for (int i = 0; i < row; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < col; j++) {
                    if ((bit & (1 << j)) != 0) {
                        sb.append(relation[i][j]).append(",");
                    }
                }
                set.add(sb.toString());
            }
            if (set.size() != row) {
                continue;
            }

            boolean possible = true;

            for (int key : arr) {
                if ((key & bit) == key) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                arr.add(bit);
            }
        }
        return arr.size();
    }
}