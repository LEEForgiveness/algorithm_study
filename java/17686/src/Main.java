//일단 숫자가 나올때까지 합친거를 HEAD에 추가한다.
//중간에 숫자끝날때까지 NUMBER에 추가
//나머지를 TAIL에 추가한다음 HEAD부터 비교

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String[] solution(String[] files) {
        String[] answer = {};
        List<String> heads = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        List<String> tails = new ArrayList<>();

        for(String file : files){
            file = file.toUpperCase();
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            for(int j = 0; j < file.length(); j++){
                if(Character.isDigit(file.charAt(j))){
                    number.append(file.charAt(j));
                }
                else {
                    head.append(file.charAt(j));
                }
            }
            file.replace(head,"");
            file.replace(number,"");

        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
    }
}