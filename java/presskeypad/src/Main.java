import static java.lang.Math.abs;

class Solution {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        String mainHand = Character.toString(hand.toUpperCase().charAt(0));
        int[][] keypad = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},{10,0,11}};
        //left = {1, 4, 7};
        //right = {3, 6, 9};
        int currentLeft = 10;
        int currentRight = 11;
        for(int i = 0; i < numbers.length; i++){
           if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
               answer.append("L");
               currentLeft = numbers[i];
           }

           if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
               answer.append("R");
               currentRight = numbers[i];
           }

           int tempLeft = 0;
           int tempLeft2 = 0;
           int tempRight = 0;
           int tempRight2 = 0;

           if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0){
               for(int j = 0; j < 4; j++){
                   for(int k = 0; k < 3; k++){
                       if(keypad[j][k] == currentLeft){
                           tempLeft = j;
                           tempLeft2 = k;
                       }
                       if(keypad[j][k] == currentRight){
                           tempRight = j;
                           tempRight2 = k;
                       }
                   }
               }
               //2는 0,1 5는 1,1 8은 2,1 0은 3,1
               if (numbers[i] == 2){
                   int leftDistance = tempLeft + abs(tempLeft2 - 1);
                   System.out.println("2: " + leftDistance);
                   int rightDistance = tempRight + abs(tempRight2 - 1);
                   System.out.println("2: " + rightDistance);
                   if (leftDistance > rightDistance){
                       answer.append("R");
                       currentRight = numbers[i];
                   }
                   if (leftDistance < rightDistance){
                       answer.append("L");
                       currentLeft = numbers[i];
                   }
                   if (leftDistance == rightDistance) {
                       answer.append(mainHand);
                       if (mainHand.equals("R")) {
                           currentRight = numbers[i];
                       }
                       else {
                           currentLeft = numbers[i];
                       }
                   }
               }

               if (numbers[i] == 5){
                   int leftDistance = abs(tempLeft - 1) + abs(tempLeft2 - 1);
                   System.out.println("5: " + leftDistance);
                   int rightDistance = abs(tempRight - 1) + abs(tempRight2 - 1);
                   System.out.println("5: " + rightDistance);
                   if (leftDistance > rightDistance){
                       answer.append("R");
                       currentRight = numbers[i];
                   }
                   if (leftDistance < rightDistance){
                       answer.append("L");
                       currentLeft = numbers[i];
                   }
                   if (leftDistance == rightDistance){
                       answer.append(mainHand);
                       if (mainHand.equals("R")) {
                           currentRight = numbers[i];
                       }
                       else {
                           currentLeft = numbers[i];
                       }
                   }
               }

               if (numbers[i] == 8){
                   int leftDistance = abs(tempLeft - 2) + abs(tempLeft2 - 1);
                   System.out.println("8: " + leftDistance);
                   int rightDistance = abs(tempRight - 2) + abs(tempRight2 - 1);
                   System.out.println("8: " + rightDistance);
                   if (leftDistance > rightDistance){
                       answer.append("R");
                       currentRight = numbers[i];
                   }
                   if (leftDistance < rightDistance){
                       answer.append("L");
                       currentLeft = numbers[i];
                   }
                   if (leftDistance == rightDistance){
                       answer.append(mainHand);
                       if (mainHand.equals("R")) {
                           currentRight = numbers[i];
                       }
                       else {
                           currentLeft = numbers[i];
                       }
                   }
               }
           }

            if (numbers[i] == 0){
                int leftDistance = abs(tempLeft - 3) + abs(tempLeft2 - 1);
                System.out.println("0: " + leftDistance);
                int rightDistance = abs(tempRight - 3) + abs(tempRight2 - 1);
                System.out.println("0: " + rightDistance);
                if (leftDistance > rightDistance){
                    answer.append("R");
                    currentRight = numbers[i];
                }
                if (leftDistance < rightDistance){
                    answer.append("L");
                    currentLeft = numbers[i];
                }
                if (leftDistance == rightDistance){
                    answer.append(mainHand);
                    if (mainHand.equals("R")) {
                        currentRight = numbers[i];
                    }
                    else {
                        currentLeft = numbers[i];
                    }
                }
            }

           System.out.println(i+1 + "번째왼손위치: " + currentLeft);
           System.out.println(i+1 + "번째오른손위치: " + currentRight);
        }


        return answer.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(Solution.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(Solution.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}