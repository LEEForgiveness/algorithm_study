// 1 -> 1
// 2 -> 6
// 3 -> 12
// 4 -> 18
// 5 -> 24

import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int room = 1;
        int plus = 1;
        while (N > room){
            room += 6 * plus;
            plus++;
        }
        System.out.println(plus);
    }
}
