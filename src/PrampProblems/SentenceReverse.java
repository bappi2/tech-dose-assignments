package PrampProblems;

public class SentenceReverse {
    /*
    Sentence Reverse
You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.

Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

Example:

input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
                'm', 'a', 'k', 'e', 's', '  ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]

output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
          'm', 'a', 'k', 'e', 's', '  ',
          'p', 'e', 'r', 'f', 'e', 'c', 't' ]
Constraints:

[time limit] 5000ms
[input] array.character arr
0 ≤ arr.length ≤ 100
[output] array.character
     */

    public String reverseWords(String s) {
        // Check if the string is empty
        if (s == null || s.length() == 0) return "";

        // Split the string into tokens
        String delim = "[ ]+";
        String[] arr = s.split(delim);

        // Create a temporary buffer to store the reversed string
        // Use StringBuilder since String is immutable
        StringBuilder sb = new StringBuilder();

        // Iterate the array in an reversed order
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" "); // leading empty string
            }
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    // second way
    public String reverseWords2(String s) {
        // empty string
        if (s == null || s.length() == 0) return "";

        int length = s.length();
        StringBuilder r = new StringBuilder(); // buffer to store the reversed string
        int stringStart = 0;
        int tokenReadPos = length - 1;
        int wordEnd;

        // Check the leading spaces
        while (stringStart < length && s.charAt(stringStart) == ' ')
            stringStart++;

        // Determine the trailing spaces
        while (tokenReadPos >= stringStart && s.charAt(tokenReadPos) == ' ') {
            tokenReadPos--;
        }

        while (tokenReadPos >= stringStart) {
            if (s.charAt(tokenReadPos) == ' ') {
                r.append(' ');
                tokenReadPos--;
                // Handle multiple spaces
                while (tokenReadPos >= stringStart && s.charAt(tokenReadPos) == ' ')
                    tokenReadPos--;
            }
            else {
                wordEnd = tokenReadPos;
                while (tokenReadPos >= stringStart && s.charAt(tokenReadPos) != ' ') {
                    tokenReadPos--;
                }
                // Copy a word into the buffer
                for (int i = tokenReadPos + 1; i <= wordEnd; i++)
                    r.append(s.charAt(i));
            }
        }
        return r.toString();
    }
}
