import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }

        HashSet<String> set = new HashSet<>(Arrays.asList(report));

        int[] cnt = new int[id_list.length];

        for (String s : set) {
            String[] temp = s.split(" ");
            String to = temp[1];
            cnt[map.get(to)]++;
        }

        for (String s : set) {
            String[] t = s.split(" ");

            String from = t[0];
            String to = t[1];

            if (cnt[map.get(to)] >= k) {
                answer[map.get(from)]++;
            }
        }

        return answer;
    }
}