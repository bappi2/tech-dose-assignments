package BLINDxx75xxProblems.StackQueueProblems;

import java.util.Stack;

public class SimplifyPath {
   /*
   Complexity Analysis

Time Complexity: O(N)O(N) if there are NN characters in the original path. 
First, we spend O(N)O(N) trying to split the input path into components and 
then we process each component one by one which is again an O(N)O(N) operation. 
We can get rid of the splitting part and just string together the characters 
and form directory names etc. However, that would be too complicated and not 
worth depicting in the implementation. The main idea of this algorithm is to 
use a stack. How you decide to process the input string is a personal choice.
Space Complexity: O(N)O(N). Actually, it's 2N2N because we have the array that 
contains the split components and then we have the stack.
*/
   
   
   public String simplifyPath(String path) {

        // Initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        // Split the input string on "/" as the delimiter
        // and process each portion one by one
        for (String directory : components) {

            // A no-op for a "." or an empty string
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {

                // If the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {

                // Finally, a legitimate directory name, so we add it
                // to our stack
                stack.add(directory);
            }
        }

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/" ;
    }
}
