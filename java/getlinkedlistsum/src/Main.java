import java.util.Iterator;
import java.util.LinkedList;
import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(6);
        linkedList1.add(7);
        linkedList1.add(8);
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(3);
        linkedList2.add(5);
        linkedList2.add(4);
        System.out.println(getLinkedListSum(linkedList1, linkedList2));
    }

    public static Integer getLinkedListSum(LinkedList<Integer> linkedList1,
        LinkedList<Integer> linkedList2) {
        Integer sum = 0;
        for (int i = 0; i < linkedList1.size(); i++) {
            Integer integer = (int) (linkedList1.get(i) * Math.pow(10, (linkedList1.size() - i - 1)));
            sum += integer;
            System.out.println(sum);
        }

        for (int i = 0; i < linkedList2.size(); i++) {
            Integer integer = (int) (linkedList2.get(i) * Math.pow(10, (linkedList2.size() - i - 1)));
            sum += integer;
            System.out.println(sum);
        }
    return sum;
    }
}

