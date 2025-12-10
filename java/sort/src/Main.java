import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("================bubbleSort================");
        System.out.println(
            "정답 = [1, 2, 4, 6, 9] / 현재 풀이 값 = " + bubbleSort(new int[]{4, 6, 2, 9, 1}));
        System.out.println(
            "정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + bubbleSort(new int[]{3, -1, 17, 9}));
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + bubbleSort(
            new int[]{100, 56, -3, 32, 44}));
        System.out.println("================selectSort================");
        System.out.println(
            "정답 = [1, 2, 4, 6, 9] / 현재 풀이 값 = " + selectSort(new int[]{4, 6, 2, 9, 1}));
        System.out.println(
            "정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + selectSort(new int[]{3, -1, 17, 9}));
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + selectSort(
            new int[]{100, 56, -3, 32, 44}));
        System.out.println("================insertionSort================");
        System.out.println(
            "정답 = [1, 2, 4, 6, 9] / 현재 풀이 값 = " + insertionSort(new int[]{4, 6, 2, 9, 1}));
        System.out.println(
            "정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + insertionSort(new int[]{3, -1, 17, 9}));
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + insertionSort(
            new int[]{100, 56, -3, 32, 44}));
    }

    private static String bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                int temp = 0;
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return Arrays.toString(numbers);
    }

    private static String selectSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            int temp = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }

        return Arrays.toString(numbers);
    }

    private static String insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i - j] < numbers[i - j - 1]) {
                    int temp = numbers[i - j];
                    numbers[i - j] = numbers[i - j - 1];
                    numbers[i - j - 1] = temp;
                }
            }
        }
        return Arrays.toString(numbers);
    }
}
