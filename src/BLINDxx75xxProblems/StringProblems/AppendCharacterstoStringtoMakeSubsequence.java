package BLINDxx75xxProblems.StringProblems;

public class AppendCharacterstoStringtoMakeSubsequence {
    public int appendCharacters(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int i = 0;
        int j = 0;
        while (j < sLen) {
            if (i < tLen && s.charAt(j) == t.charAt(i)) {
                i++;
            }
            j++;
        }
        return tLen - i;
    }
}
