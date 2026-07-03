import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> dictionary = new ArrayList<>();
    public char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {

        dfs("");

        return dictionary.indexOf(word) + 1;
    }

    public void dfs(String nowWord) {

        if (!nowWord.isEmpty()) {
            dictionary.add(nowWord);
        }

        if (nowWord.length() == 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            dfs(nowWord + vowels[i]);
        }
    }
}