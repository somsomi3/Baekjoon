import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new char[26][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[root - 'A'][0] = left;
            tree[root - 'A'][1] = right;
        }

        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
    }

    static void preorder(char node) {
        if (node == '.') return;
        System.out.print(node);
        preorder(tree[node - 'A'][0]);
        preorder(tree[node - 'A'][1]);
    }

    static void inorder(char node) {
        if (node == '.') return;
        inorder(tree[node - 'A'][0]);
        System.out.print(node);
        inorder(tree[node - 'A'][1]);
    }

    static void postorder(char node) {
        if (node == '.') return;
        postorder(tree[node - 'A'][0]);
        postorder(tree[node - 'A'][1]);
        System.out.print(node);
    }
}
