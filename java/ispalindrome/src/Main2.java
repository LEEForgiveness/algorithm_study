public class Main2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("소주만병만주소"));
    }

    private static boolean isPalindrome(String string) {
        if(string.length() == 1){
            return true;
        }
        int end = string.length() - 1;
        int start = 0;
        if (string.charAt(start) != string.charAt(end)) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder(string);
            sb.deleteCharAt(end);
            sb.deleteCharAt(start);
            string = sb.toString();
            System.out.println(string);
            isPalindrome(string);
        }
        return true;
    }
}
