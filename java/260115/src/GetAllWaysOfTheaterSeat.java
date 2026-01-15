import java.util.HashMap;
import java.util.Map;

class GetAllWaysOfTheaterSeat {
    private static int seatCount = 9;
    private static int[] vipSeatArray = {4, 7};

    private static Map<Integer, Integer> fiboMemo = new HashMap<>();
    static {
        fiboMemo.put(1, 1);
        fiboMemo.put(2, 2);
    }
    public static int getFiboCount(int n , Map<Integer, Integer> fiboMemo){
        if (n == 0) {
            return 1;
        }
        if (fiboMemo.containsKey(n)) {
            return fiboMemo.get(n);
        } else {
            int result = getFiboCount(n - 1, fiboMemo) +  getFiboCount(n - 2, fiboMemo);
            fiboMemo.put(n, result);
            return result;
        }
    }

    public static int getAllWaysOfTheaterSeat(int totalCount, int[] fixedSeatArray) {
        int result = 1;

        for (int i = 0; i < fixedSeatArray.length; i++) {
            if (i == 0) {
                result *= getFiboCount(fixedSeatArray[i] - 1, fiboMemo);
            } else if (i == fixedSeatArray.length - 1) {
                result *= getFiboCount(totalCount - fixedSeatArray[i], fiboMemo);
                result *= getFiboCount(fixedSeatArray[i] - fixedSeatArray[i - 1] - 1, fiboMemo);
            } else {
                result *= getFiboCount(fixedSeatArray[i] - fixedSeatArray[i - 1] - 1, fiboMemo);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 12가 출력되어야 합니다!
        System.out.println(getAllWaysOfTheaterSeat(seatCount, vipSeatArray));
        System.out.println(getAllWaysOfTheaterSeat(10, new int[] {1, 2, 4}));
    }
}