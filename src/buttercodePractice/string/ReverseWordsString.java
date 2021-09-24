package buttercodePractice.string;

public class ReverseWordsString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();


        return sb.toString();
    }

    public static void main(String[] args) {
        String phrase = "  the music made    it    hard     to        concentrate";
        ReverseWordsString rw = new ReverseWordsString();
        rw.reverseWords(phrase);


    }
}
