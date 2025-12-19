import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[3];
        int result = 0;
        String answer;
        for (int i = 0; i < 3; i++) {
            inputs[i] = bufferedReader.readLine();
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if(inputs[i].matches("^\\d+$")){
                index = i;
            }
        }
        result = Integer.parseInt(inputs[index]) + (3 - index);
        if (result % 3 == 0 && result % 5 == 0){
            answer = "FizzBuzz";
            System.out.println(answer);
        } else if (result % 3 == 0 && result % 5 != 0) {
            answer = "Fizz";
            System.out.println(answer);
        } else if (result % 3 != 0 && result % 5 == 0) {
            answer = "Buzz";
            System.out.println(answer);
        } else {
            System.out.println(result);
        }
    }
}