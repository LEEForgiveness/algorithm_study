// 아예 String을 바꾸는 건 아니니깐 앞에 인덱스꺼 숫자를 바꾼다고 생각해도 원래 숫자가 뒤에꺼가 같으면 카운트가 안올라간다고 생각할 수있음.


public class Main {

    public static void main(String[] args) {
        System.out.println(findCountToTurnOutToAllZeroOrAllOne("011110"));
        System.out.println(findCountToTurnOutToAllZeroOrAllOne("01010101"));
        System.out.println(findCountToTurnOutToAllZeroOrAllOne("11011"));
    }

    public static int findCountToTurnOutToAllZeroOrAllOne(String numbers) {
        int zeroToAllCount = 0;
        int oneToAllCount = 0;

        if (numbers.charAt(0) == '0') {
            oneToAllCount += 1;
        } else {
            zeroToAllCount += 1;
        }

        for (int i = 0; i < numbers.length() - 1; i++) {
            if (numbers.charAt(i) != numbers.charAt(i + 1)) {
                if (numbers.charAt(i) == '0') {
                    zeroToAllCount += 1;
                } else {
                    oneToAllCount += 1;
                }
            }
        }

        System.out.println(
            "zeroToAllCount : " + zeroToAllCount + ", " + "oneToAllCount : " + oneToAllCount);
        return Math.min(zeroToAllCount, oneToAllCount);
    }
}