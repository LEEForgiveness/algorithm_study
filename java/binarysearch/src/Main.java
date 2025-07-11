public class Main {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int target = 14;
        System.out.println(binarySearch(numbers, target));
    }

    public static int binarySearch(int[] numbers, int target) {
        int min = 0;
        int max = numbers.length - 1;
        int middle = (min + max) / 2;

        while (min <= max) {
            if (numbers[middle] == target) {
                return middle;
            } else if (numbers[middle] > target) { //target값이 middle보다 작다, max값을 땡겨와야함
                max = middle - 1;
            } else { //target값이 middle보다 크다, min값을 올려와야함
                min = middle + 1;
            }
            middle = (min + max) / 2;
        }

        return 0;
    }
}
