package ArrayProblems.FaceBook;

class MinimumAddtoMakeParenthesisValid {
    public int minAddToMakeValid(String S) {
        int openCount = 0; // Count of open parentheses
        int addCount = 0; // Count of parentheses to be added

        for (char c : S.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) {
                    // Match an open parenthesis
                    openCount--;
                } else {
                    // Need to add a parenthesis
                    addCount++;
                }
            }
        }

        // Add the remaining open parentheses
        addCount += openCount;

        return addCount;
    }
}
