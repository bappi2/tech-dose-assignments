package buttercodePractice.string;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            char startChar = Character.toLowerCase(s.charAt(start));
            char endChar = Character.toLowerCase(s.charAt(end));

            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A1 man, a plan, a canal: Panam1a";
        String str2 = "race a car";
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome(str));
        System.out.println(vp.isPalindrome(str2));
    }
}
