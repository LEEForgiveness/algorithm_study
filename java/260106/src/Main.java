import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(get_minimum_count_of_overseas_supply(4, new int[] {4, 10, 15}, new int[] {20, 5, 10}, 30));
        System.out.println(get_minimum_count_of_overseas_supply(0, new int[] {0, 10, 15}, new int[] {20, 10, 15}, 35));
        System.out.println(get_minimum_count_of_overseas_supply(0, new int[] {0, 20, 25}, new int[] {20, 10, 15}, 35));
        System.out.println("정답 = 2 / 현재 풀이 값 = " + get_minimum_count_of_overseas_supply(4, new int[] {4, 10, 15}, new int[] {20, 5, 10}, 30));
        System.out.println("정답 = 4 / 현재 풀이 값 = " + get_minimum_count_of_overseas_supply(4, new int[] {4, 10, 15, 20}, new int[] {20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " + get_minimum_count_of_overseas_supply(2, new int[] {1, 10}, new int[] {10, 100}, 11));
    }

    static int get_minimum_count_of_overseas_supply(int stock, int[] supplyDates, int[] supplies, int k){
        int result = 0;

        return result;
    }
}
