import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int greatestCommonDivisor = getGreatestCommonDivisor(numbers);
        System.out.println(greatestCommonDivisor);
        System.out.println(getLeastCommonMultiple(numbers, greatestCommonDivisor));
    }
    static int getGreatestCommonDivisor(int[] numbers){
        int result = 0;
        for (int i = 1; i <= Math.min(numbers[0], numbers[1]); i++) {
            if(numbers[0] % i == 0 && numbers[1] % i == 0){
                result = i;
            }
        }
        return result;
    }
    static int getLeastCommonMultiple(int[] numbers, int greatestCommonDivisor){
        int result = 0;
        result = numbers[0] / greatestCommonDivisor * numbers[1];
        return result;
    }
}
