// 121 -> 0, 2 1, 1
// 1231 -> 0, 3 1, 2 2, 1
// 12421 -> 0, 4 1, 3 2, 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = bufferedReader.readLine();
            if(s.equals("0")){
                break;
            }
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;
            boolean yes = true;
            while(i < j){
                if(chars[i] != chars[j]){
                    yes = false;
                    break;
                }
                i++;
                j--;
            }
            if(yes){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
