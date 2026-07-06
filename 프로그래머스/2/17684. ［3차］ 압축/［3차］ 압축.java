import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        List<Integer> list = new ArrayList<>();

        int index = 0;

        while (index < msg.length()) {

            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(index));

            String word = sb.toString();

            while (index + 1 < msg.length()
                    && map.containsKey(word + msg.charAt(index + 1))) {

                index++;
                sb.append(msg.charAt(index));
                word = sb.toString();
            }

            // 가장 긴 문자열 출력
            list.add(map.get(word));

            if (index + 1 < msg.length()) {
                map.put(word + msg.charAt(index + 1), map.size() + 1);
            }

            index++;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}