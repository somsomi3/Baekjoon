class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String s : skill_trees) {
            int idx = 0;
            boolean flag = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (skill.indexOf(c) != -1) {
                    if (idx >= skill.length() || c != skill.charAt(idx)) {
                        flag = false;
                        break;
                    }
                    idx++;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}