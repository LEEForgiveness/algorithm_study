import java.util.ArrayList;
import java.util.List;

public class Main3 {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getCountOfWaysToTargetByDoingPlusOrMinus(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int getCountOfWaysToTargetByDoingPlusOrMinus(int[] list, int targetNumber) {
        getAllWaysByDoingPlusOrMinus(list, 0, 0);
        int count = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) == targetNumber) {
                count++;
            }
        }
        return count;
    }

    public static void getAllWaysByDoingPlusOrMinus(int[] list, int currentIndex, int currentSum) {
        if (currentIndex == list.length) {
            result.add(currentSum);
            return; //return안해주면 밑에꺼 실행되서 배열크기를 넘어서서 계산을 함.
        }
        System.out.println("currentIndex = " + currentIndex + " currentSum = " + currentSum);
        getAllWaysByDoingPlusOrMinus(list, currentIndex + 1, currentSum + list[currentIndex]);
        getAllWaysByDoingPlusOrMinus(list, currentIndex + 1, currentSum - list[currentIndex]);
    }
}
