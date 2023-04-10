package BLINDxx75xxProblems.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;

public class  FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int lo = 0;
        int hi = 0;
        int maxFruits = 1;
        for (hi = 0; hi < fruits.length; hi++) {
            map.put(fruits[hi], map.getOrDefault(fruits[hi], 0) +1);

            while (map.size() > 2) {
                if (map.get(fruits[lo]) == 1) {
                    map.remove(fruits[lo]);
                }
                else {
                    map.put(fruits[lo], map.get(fruits[lo]) -1 );
                }
                lo++;
            }

            maxFruits = Math.max(maxFruits, hi - lo +1);
        }
        return maxFruits;
    }
}
