import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        System.out.println(primeNumbers(20));
//        System.out.println(primeNumbers2(20));
//        System.out.println(primeNumbers3(20));
//        System.out.println(primeNumbers(3));

        measureAndPrint("primeNumbers", 100000);
        measureAndPrint("primeNumbers2", 100000);
        measureAndPrint("primeNumbers3", 100000);
    }

    private static void measureAndPrint(String methodName, int number) {
        long start = System.nanoTime();
        List<Integer> result;
        switch (methodName) {
            case "primeNumbers":
                result = primeNumbers(number);
                break;
            case "primeNumbers2":
                result = primeNumbers2(number);
                break;
            case "primeNumbers3":
                result = primeNumbers3(number);
                break;
            default:
                throw new IllegalArgumentException("Unknown method: " + methodName);
        }
        long end = System.nanoTime();
        System.out.println(methodName + "(" + number + ") 결과: " + result);
        System.out.println(methodName + " 실행 시간: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static List<Integer> primeNumbers(int number){
        if (number == 0 || number == -1){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            Boolean primeNumber = true;
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && j != 1) {
                    primeNumber = false;
                }
            }
            if(primeNumber){
                result.add(i);
            }
        }

        return result;
    }

    public static List<Integer> primeNumbers2(int number){
        if (number == 0 || number == -1){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            Boolean primeNumber = true;
            for (int j : result) {  //소수는 자신보다 작은 소수로 나눠도 나누어 지지 않는다.
                if (i % j == 0) {
                    primeNumber = false;
                    break;      //모든 루프를 돌 필요 없이 나누져서 나머지가 안 생기면 소수가 아니기 때문에 멈춰도 된다.
                }
            }
            if(primeNumber){
                result.add(i);
            }
        }

        return result;
    }

    public static List<Integer> primeNumbers3(int number){
        if (number == 0 || number == -1){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            Boolean primeNumber = true;
            for (int j : result) {  //소수의 필요충분 조건은 소수의 제곱근보다 작은 어떠한 소수로도 나누어 지지 않는다.
                if (j * j <= i && i % j == 0) {
                    primeNumber = false;
                    break;      //모든 루프를 돌 필요 없이 나누져서 나머지가 안 생기면 소수가 아니기 때문에 멈춰도 된다.
                }
            }
            if(primeNumber){
                result.add(i);
            }
        }

        return result;
    }
}