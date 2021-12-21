package String;

public class FindFirstPalindrome {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
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
        String [] words = {"abc","car","ada","racecar","cool"};
        FindFirstPalindrome ffp = new FindFirstPalindrome();

        System.out.println(ffp.firstPalindrome(words));
    }
}
