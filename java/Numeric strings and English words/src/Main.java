class Solution {
    public static int solution(String s) {
        String answer = "";
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        String temp = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                answer += s.charAt(i);
            }
            else {
                temp += s.charAt(i);
            }
            for(int j = 0; j < words.length; j++){
                if(temp.equals(words[j])){
                    answer += numbers[j];
                    temp = "";
                }
            }
        }

        return Integer.parseInt(answer);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution("one4seveneight"));
    }
}