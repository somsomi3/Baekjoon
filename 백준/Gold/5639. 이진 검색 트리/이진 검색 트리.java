import java.io.*;

public class Main {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }

        public void insert(int num) {
            if (num < this.val) {
                if (this.left == null) {
                    this.left = new Node(num);
                } else {
                    this.left.insert(num);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(num);
                } else {
                    this.right.insert(num);
                }
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.val).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Node root = null;
        String input;
        while ((input = br.readLine()) != null && !input.equals("")) {
            int num = Integer.parseInt(input);
            if (root == null) {
                root = new Node(num);
            } else {
                root.insert(num);
            }
        }

        postorder(root);
        System.out.println(sb);
    }
}
