import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<String> shopMenu = Arrays.asList("만두", "떡볶이", "오뎅", "사이다", "콜라");
        List<String> shopOrders = Arrays.asList("오뎅", "콜라", "만두", "라면");
        System.out.println(isAvailableToOrder(shopMenu, shopOrders));
    }

    public static boolean isAvailableToOrder(List<String> shopMenu, List<String> shopOrders) {
        Collections.sort(shopMenu);
        for (String shopOrder : shopOrders) {
            if (!find(shopMenu, shopOrder)) {
                return false;
            }
        }
        return true;
    }

    public static boolean find(List<String> shopMenu, String shopOrder) {
        int min = 0;
        int max = shopMenu.size() - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            int comparison = shopMenu.get(middle).compareTo(shopOrder);
            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                min = middle + 1;
            } else {
                max = middle - 1;
            }
        }
        return false;
    }
}
