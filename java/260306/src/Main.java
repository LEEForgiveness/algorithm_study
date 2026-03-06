import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node head = new Node("A", null, null);
    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        static public void insertNode(Node node, String value, String left, String right){
            if (node.value.equals(value)) {
                node.left = (left.equals(".") ? null : new Node(left, null, null));
                node.right = (right.equals(".") ? null : new Node(right, null, null));
            } else {
                if (node.left != null) {
                    insertNode(node.left, value, left, right);
                }
                if (node.right != null) {
                    insertNode(node.right, value, left, right);
                }
            }
        }
    }

    static void preOrder(Node node){
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node){
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node){
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node.insertNode(head, root, left, right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }
}
