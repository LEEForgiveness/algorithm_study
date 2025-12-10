import java.util.ArrayList;
import java.util.List;

public class Main4 {

    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getCountOfWaysToTargetByDoingPlusOrMinus(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private static int getCountOfWaysToTargetByDoingPlusOrMinus(int[] ints, int target) {
        int count = 0;
        getAllWaysToTargetByDoingPlusOrMinus(ints, 0, 0);
        for (int number : result) {
            if (number == target) {
                count++;
            }
        }
        return count;
    }

    private static void getAllWaysToTargetByDoingPlusOrMinus(int[] ints, int currentIndex,
        int currentSum) {
        if (currentIndex == ints.length) {
            result.add(currentSum);
            return;
        }
        getAllWaysToTargetByDoingPlusOrMinus(ints, currentIndex + 1,
            currentSum + ints[currentIndex]);
        getAllWaysToTargetByDoingPlusOrMinus(ints, currentIndex + 1,
            currentSum - ints[currentIndex]);
    }
}
