package buttercodePractice.string;

public class ReverseWordsString {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int start = 0;
        int readPos = len -1;
        int wordEnd;
        // leading space
        while (start < len && s.charAt(start) == ' ') {
            start++;
        }
        // trailing space
        while (readPos >= start && s.charAt(readPos) == ' ') {
            readPos--;
        }

        while (start <= readPos) {
            if (s.charAt(readPos) == ' ') {
                sb.append(' ');
                readPos--;
                while (start <= readPos && s.charAt(readPos) == ' ') {
                    readPos--;
                }
            }
            else {
                wordEnd = readPos;
                while (start <= readPos && s.charAt(readPos) != ' ') {
                    readPos--;
                }
                // copy word
                for (int i = readPos + 1; i <= wordEnd; i++) {
                    sb.append(s.charAt(i));
                }
            }
        }


        return sb.toString();
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int start = 0;
        int readPos = length -1;
        int wordEnd;
        // skip leading space
        while (start < length && s.charAt(start) == ' ') {
            start++;
        }
        // skip trailing space
        while (start <= readPos && s.charAt(readPos) == ' ') {
            readPos--;
        }

        while ( start <= readPos) {
            if (s.charAt(readPos) == ' ') {
                sb.append(' ');
                readPos --;
                while (start <= readPos && s.charAt(readPos) == ' ') {
                    readPos--;
                }
            }
            else {
                wordEnd = readPos;
                while (start <= readPos && s.charAt(readPos) != ' ') {
                    readPos--;
                }
                // copy word
                for(int i = readPos +1; i <= wordEnd; i++) {
                    sb.append(s.charAt(i));
                }
            }
        }


        return sb.toString();
    }

    public String reverseWords3(String s) {
        if ( s == null || s.length() == 0) {
            return "";
        }
        String delim = "[ ]+";
        String[] words = s.split(delim);
        StringBuilder sb = new StringBuilder();
        for (int i=words.length -1; i>=0; i--) {
            if (!words[i].equals("")) {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length()-1).toString();
    }

    public static void main(String[] args) {
        String phrase = "  the music made    it    hard     to        concentrate";
        ReverseWordsString rw = new ReverseWordsString();
        String reverseStr = rw.reverseWords3(phrase);
        System.out.println(reverseStr);

    }
}
