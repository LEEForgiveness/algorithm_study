import java.util.Arrays;

class Solution {
    static public String solution(int[] numbers) {
        String answer = "";
        String[] numberArrays = new String[numbers.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberArrays.length; i++) {
                String number = String.valueOf(numbers[i]);
                numberArrays[i] = number;
        }

        Arrays.sort(numberArrays, (a, b) -> (b + a).compareTo(a + b));

        for (int i = 0; i < numberArrays.length; i++) {
            sb.append(numberArrays[i]);
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[] {6, 10, 2});
        solution(new int[] {3, 30, 34, 5, 9});
    }
}