package HashMap;

public class JewelsandStones {
    // brute force
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        for (char s: S.toCharArray()) // For each stone...
            for (char j: J.toCharArray()) // For each jewel...
                if (j == s) {  // If the stone is a jewel...
                    ans++;
                    break; // Stop searching whether this stone 's' is a jewel
                }
        return ans;
    }
    // Time Complexity: O(J.length∗S.length))

    // HashMap
    public int numJewelsInStones(String J, String S) {
        Set<Character> Jset = new HashSet();
        for (char j: J.toCharArray())
            Jset.add(j);

        int ans = 0;
        for (char s: S.toCharArray())
            if (Jset.contains(s))
                ans++;
        return ans;
    }
    // Time Complexity: O(J.length+S.length).

    // Array
    public int numJewelsInStones(String J, String S) {

        int[] stones=new int[128];

        for(char c:S.toCharArray()){
            stones[c]++;
        }
        int count=0;
        for(char c:J.toCharArray()){
            count+=stones[c];
        }

        return count;
    }
}
