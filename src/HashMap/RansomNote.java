package HashMap;

public class RansomNote {

    // Takes a String, and returns a HashMap with counts of
    // each character.
    private Map<Character, Integer> makeCountsMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int currentCount = counts.getOrDefault(c, 0);
            counts.put(c, currentCount + 1);
        }
        return counts;
    }


    public boolean canConstruct(String ransomNote, String magazine) {

        // Check for obvious fail case.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Make a counts map for the magazine.
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);

        // For each character in the ransom note:
        for (char c : ransomNote.toCharArray()) {
            // Get the current count for c in the magazine.
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            // If there are none of c left, return false.
            if (countInMagazine == 0) {
                return false;
            }
            // Put the updated count for c back into magazineCounts.
            magazineCounts.put(c, countInMagazine - 1);
        }

        // If we got this far, we can successfully build the note.
        return true;
    }

    =====
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length()>magazine.length()) return false;
        int[] indexArr=new int[26];

        for(char c:ransomNote.toCharArray()){
            int index = magazine.indexOf(c,indexArr[c-'a']);

            if(index==-1){
                return false;
            }

            indexArr[c-'a']=index+1;
        }

        return true;
    }
}
