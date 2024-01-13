package JustCodingWithJie;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        int left = 0, right = 0;
        int leftToRemove = 0, rightToRemove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            if (right > left) {
                rightToRemove++;
                right--;
            }
        }
        leftToRemove = left - right;
        dfs(s, 0, leftToRemove, rightToRemove, new StringBuilder(s), result);
        return result;
    }

    private void dfs(String s, int idx, int leftToRemove, int rightToRemove,
                     StringBuilder sb, List<String> result) {
        if (leftToRemove == 0 && rightToRemove == 0) {
            if (isBalanced(sb)) {
                result.add(sb.toString());
                return;
            }
            for (int i = idx; i < sb.length(); i++) {
// de dupe
                if (i > idx && sb.charAt(i) == sb.charAt(i - 1)) {
                    continue;
                }
                if (leftToRemove > 0 && sb.charAt(i) == '(') {
                    sb.deleteCharAt(i);
                    dfs(s, i, leftToRemove - 1, rightToRemove, sb, result);
                    sb.insert(i, '(');
                }
                if (rightToRemove > 0 && sb.charAt(i) == ')') {
                    sb.deleteCharAt(i);
                    dfs(s, i, leftToRemove, rightToRemove - 1,
                            sb, result);
                    sb.insert(i, ')');
                }
            }
        }
    }
}

private boolean isBalanced(StringBuilder sb) {
    int left = 0, right = 0;
    for (int i = 0; i < sb.length(); i++) {
        if (sb.charAt(i) == '(') left++;
        if (sb.charAt(i) == ')') {
            right++;
        }
    }
    return left == right;
}
}

