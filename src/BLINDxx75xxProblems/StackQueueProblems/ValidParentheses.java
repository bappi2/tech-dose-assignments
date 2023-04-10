package BLINDxx75xxProblems.StackQueueProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {


    public boolean isValid(String s) {

        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid2("([)]");
    }
    public static boolean isValid2(String s) {
        Deque<Character> stack=new ArrayDeque<Character>();
        if(s.length()==1) return false;
        for(char c:s.toCharArray()){
            if(c==')'||c==']'||c=='}'){
                if(stack.isEmpty()){
                    stack.push(c);
                }else{
                    char pc=stack.peek();
                    if(c==')' && pc=='('){
                        stack.pop();
                    }
                    else if(c=='}' && pc=='{') {
                        stack.pop();
                    }
                    else if(c==']' && pc=='[') {
                        stack.pop();
                    }
                    else return false;
                }

            }
            else
                stack.push(c);
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

}

