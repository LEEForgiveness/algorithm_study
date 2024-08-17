//*은 바로전에 얻은 점수, 해당 점수 X2, #은 -해당점수, *#은 -2배, **은 X4

class Solution {
    public static int solution(String dartResult) {
        int answer = 0;

        char[] dart = dartResult.toCharArray();

        int[] score = {0,0,0};
        int j = -1;

        for(int i = 0; i < dart.length; i++){
//            System.out.println(dart[i]);
            if(i > 0 && Character.isDigit(dart[i - 1]) && Character.isDigit(dart[i])){
                score[j] = (dart[i - 1] - '0') * 10 + dart[i] - '0';
            }
            else if(Character.isDigit(dart[i])){
                j++;
//                System.out.println(Integer.valueOf(dart[i]));
                score[j] += dart[i] - '0';
            }
//            System.out.println("i: " + i + "일때" + score[j]);
            switch (dart[i]) {
                case 'D':
                    score[j] = score[j] * score[j];
                    break;
                case '*':
                    if(j > 0){
                        score[j - 1] *= 2;
                        score[j] *= 2;
                    } else {
                        score[j] *= 2;
                    }
                    break;
                case 'T':
                    score[j] = score[j] * score[j] * score[j];
                    break;
                case '#':
                    score[j] *= -1;
                    break;
                default:
                    break;
            }
        }

        for(int i = 0; i < score.length; i++){
//            System.out.println(score[i]);
            answer += score[i];
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution("1S2D*3T"));
        System.out.println(Solution.solution("1D2S#10S"));
    }
}