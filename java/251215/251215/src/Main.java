import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int charTotal = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < 3){
            int number = scanner.nextInt();
            if (i == 2){
                total -= number;
                charTotal = Integer.parseInt(sb.toString()) - number;
            } else {
                total += number;
                sb.append(number);
            }
            i++;
        }

        System.out.println(total);
        System.out.println(charTotal);
    }
}