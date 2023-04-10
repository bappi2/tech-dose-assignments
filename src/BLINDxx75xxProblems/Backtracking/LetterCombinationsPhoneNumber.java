package BLINDxx75xxProblems.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String [] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();

        helper(digits, 0, result, map, sb);
        return result;
    }
    void helper(String digits, int index, List<String> result, String [] map, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for (char ch : map[digit].toCharArray()) {
            sb.append(ch);
            helper(digits, index + 1, result, map, sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
