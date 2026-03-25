### 636. Exclusive Time of Functions
```agsl
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n]; 
        Stack<Integer> stack = new Stack<>(); 
        int prev = 0; 

        for (String log: logs) {
            String[] parts = log.split(":"); 
            int id = Integer.parseInt(parts[0]); 
            String type = parts[1]; 
            int t = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += t - prev;
                }
                stack.push(id);
                prev = t;
            }
            else {
                result[stack.pop()] += t - prev + 1;
                prev = t + 1;
            }
        }
       
        return result;
    }
```

### 20. Valid Parentheses
```agsl
    public boolean isValid(String s) {
        Map<Character, Character> seen = new HashMap<>(); 
        seen.put('(', ')');
        seen.put('{', '}');
        seen.put('[', ']');

        Stack<Character> stack = new Stack<>(); 
        for (char c : s.toCharArray()) {
            if (seen.containsKey(c)) {
                stack.push(seen.get(c));
            }
            else {
                char curr = stack.isEmpty() ? '#' : stack.pop();
                if (c != curr) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
```