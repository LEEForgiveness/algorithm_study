public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(6);
        list.add(7);
        list.add(8);
        System.out.println(getKthNodeFromLast(list, 2));
        System.out.println(getKthNodeFromLast2(list, 2));
    }

    private static Object getKthNodeFromLast(LinkedList list, int i) {
        return list.get(list.size() - i);
    }

    private static Object getKthNodeFromLast2(LinkedList list, int i) {
        Node slow = list.first;
        Node fast = list.first;
        for (int j = 0; j < i; j++) {
            fast = fast.next;
        }
//        System.out.println(fast.item);

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.item;
    }

    public static class Node {

        Object item;
        Node next;

        public Node(Object item) {
            this.item = item;
        }
    }

    public static class LinkedList {

        private Node first;
        private int size = 0;

        public void add(Object item) {
            Node newNode = new Node(item);
            if (first == null) {
                first = newNode;
            } else {
                Node lastNode = getLastNode();
                lastNode.next = newNode;
            }
            size++;
        }

        private Node getLastNode() {
            Node x = first;
            while (x.next != null) {
                x = x.next;
            }
            return x;
        }

        public Object get(int index) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x.item;
        }

        public int size() {
            return size;
        }
    }
}
