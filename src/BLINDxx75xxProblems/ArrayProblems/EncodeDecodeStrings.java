package BLINDxx75xxProblems.ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    // https://leetcode.com/problems/group-anagrams/

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length())
                    .append("#")
                    .append(s);
        }
        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i =0;
        int j = 0;
        int length = s.length();

        while (i < length) {
            j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int segLen = Integer.valueOf(s.substring(i, j));
            String str = s.substring(j +1, j + segLen + 1);
            result.add(str);
            i = j + segLen + 1;
        }
        return result;
    }
}
