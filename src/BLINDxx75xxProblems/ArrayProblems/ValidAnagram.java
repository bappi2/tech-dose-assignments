package BLINDxx75xxProblems.ArrayProblems;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }


    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] cnt = new int[26];

        for(char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        for(char c : t.toCharArray()) {
            if(cnt[c-'a'] == 0) return false;
            cnt[c-'a']--;
        }
        return true;
    }
}
