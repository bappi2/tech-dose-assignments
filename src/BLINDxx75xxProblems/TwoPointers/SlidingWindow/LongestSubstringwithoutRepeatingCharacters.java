package BLINDxx75xxProblems.TwoPointers.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0, j=0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j -i +1);
            map.put(s.charAt(j), j+1);
        }
        return max;
    }
}
