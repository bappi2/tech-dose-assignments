package ArrayProblems.FaceBook;

import java.util.Stack;

class SimplifyPath {
    public String simplifyPath(String path) {
        String[] components = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.equals("..")) {
                // Move up one level by popping from the stack (if not empty)
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.equals("") && !component.equals(".")) {
                // Ignore empty strings and current directory references
                stack.push(component);
            }
        }

        // Build the simplified path
        StringBuilder result = new StringBuilder("/");
        for (String dir : stack) {
            result.append(dir).append("/");
        }

        // Remove the trailing "/" if the path is not empty
        if (result.length() > 1) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath solution = new SimplifyPath();

        System.out.println(solution.simplifyPath("/home/")); // "/home"
        System.out.println(solution.simplifyPath("/../")); // "/"
        System.out.println(solution.simplifyPath("/home//foo/")); // "/home/foo"
        System.out.println(solution.simplifyPath("/a/./b/../../c/")); // "/c"
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//")); // "/c"
        System.out.println(solution.simplifyPath("/a//b////c/d//././/..")); // "/a/b/c"
    }
}
