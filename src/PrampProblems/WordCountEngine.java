package PrampProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCountEngine {
    /*
    Word Count Engine
Implement a document scanning function wordCountEngine, which receives
a string document and returns a list of all unique words in it and
their number of occurrences, sorted by the number of occurrences in a
descending order. If two or more words have the same count, they should be
sorted according to their order in the original sentence. Assume that all
letters are in english alphabet. Your function should be case-insensitive,
so for instance, the words “Perfect” and “perfect” should be considered
the same word.

The engine should strip out punctuation (even in the middle of a word)
 and use whitespaces to separate words.

Analyze the time and space complexities of your solution. Try to optimize
for time while keeping a polynomial space complexity.

Examples:

input:  document = "Practice makes perfect. you'll only get Perfect by practice. just practice!"

output: [ ["practice", "3"], ["perfect", "2"],
          ["makes", "1"], ["youll", "1"], ["only", "1"],
          ["get", "1"], ["by", "1"], ["just", "1"] ]
Important: please convert the occurrence integers in the output list to strings
(e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java,
C++, C etc., it’s not straightforward to create mixed-type arrays (as it is,
for instance, in scripted languages like JavaScript, Python, Ruby etc.).
The expected output will simply be an array of string arrays.

Constraints:

[time limit] 5000ms
[input] string document
[output] array.array.string
     */

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";

        String[][] output = wordCountEngine(document);

        Arrays.stream(output).forEach(arr -> {
            System.out.println(arr[0] + "->" + arr[1]);
        });
    }

    static String[][] wordCountEngine(String doc) {

        doc = doc.toLowerCase();
        doc = doc.replaceAll("[^a-z ]", "");

        String[] words = doc.split(" ");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }

        }
        //sorting in descending order of values
        LinkedHashMap<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        //adding hashmap values to 2D array.
        String[][] arrayString = sortedMap.entrySet()
                .stream()
                .map(e -> new String[]{e.getKey(), String.valueOf(e.getValue())})
                .toArray(String[][]::new);


        return arrayString;
    }
}
