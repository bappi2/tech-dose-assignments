package String;

public class AddSpaces {
    public String addSpaces(String s, int[] spaces) {

        StringBuilder sb = new StringBuilder();

        int len = spaces.length;
        int prev = 0;
        int curr = 0;

        while (curr <len ) {
            String sub = s.substring(prev, spaces[curr]);

            sb.append(sub).append(" ");
            prev = spaces[curr];
            curr++;
        }
        String sub = s.substring(spaces[len-1]);
        return sb.append(sub).toString();
    }

    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int []spaces = {8,13,15};

        AddSpaces as = new AddSpaces();

        System.out.println(as.addSpaces(s, spaces));
    }
}
