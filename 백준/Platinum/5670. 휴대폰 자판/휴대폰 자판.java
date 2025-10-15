import java.io.*;
import java.util.*;

class Node {
    Node[] child = new Node[26];
    boolean isEnd;
}

class Trie {
    Node root = new Node();

    void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.child[idx] == null)
                cur.child[idx] = new Node();
            cur = cur.child[idx];
        }
        cur.isEnd = true;
    }

    int countInput(String word) {
        Node cur = root;
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (i == 0) count++;

            int idx = word.charAt(i) - 'a';
            Node next = cur.child[idx];

            int childCount = 0;
            for (int j = 0; j < 26; j++)
                if (cur.child[j] != null)
                    childCount++;

            if (i > 0 && (cur.isEnd || childCount > 1))
                count++;

            cur = next;
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line);
            Trie trie = new Trie();
            String[] words = new String[N];

            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
                trie.insert(words[i]);
            }

            double total = 0;
            for (String w : words)
                total += trie.countInput(w);

            sb.append(String.format("%.2f\n", total / N));
        }

        System.out.print(sb);
    }
}
