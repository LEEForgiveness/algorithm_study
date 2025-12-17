import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] ISBN = bf.readLine().toCharArray();
        int result = 0;
        int total = 0;
        int index = 0;
        for (int i = 0; i < ISBN.length; i++) {
            if(ISBN[i] != '*'){
                if(i % 2 == 0){
                    total += (ISBN[i] - '0');
                } else {
                    total += 3 * (ISBN[i] - '0');
                }
            } else {
                index = i;
            }
            System.out.println("index: " + i + " ISBN: " + ISBN[i] + " total: " + total);
        }
        if (total % 10 == 0){
            System.out.println(result);
            return;
        }
        if (index % 2 == 0){
            result = 10 - (total % 10);
        } else {
            for (int i = 0; i < 10; i++) {
                if ((i * 3) % 10 == (10 - total % 10)){
                    result = i;
                }
            }
        }
        System.out.println(result);
    }
}
