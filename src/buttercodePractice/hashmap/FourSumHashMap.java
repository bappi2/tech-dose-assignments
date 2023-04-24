package buttercodePractice.hashmap;

public class FourSumHashMap {
    /*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i=0; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<Pair<Integer, Integer>> curr = map.getOrDefault(nums[i] + nums[j], new ArrayList<>());
                curr.add(new Pair<>(i, j));
                map.put(nums[i] + nums[j], curr);
            }
        }
        for (int i = 0; i < nums.length -1; i++) {
            if (i == 0 || nums[i] > nums[i -1]) {
                for (int j = i+1; j < nums.length; j++) {
                    if (j == i + 1 || nums[j] > nums[j -1]) {
                        int sum = target - nums[i] - nums[j];
                        if (map.containsKey(sum)) {
                            List<Pair<Integer, Integer>> curr = map.get(sum);
                            for(Pair p: curr) {
                                int k = (Integer) p.getKey();
                                int l = (Integer) p.getValue();
                                if (k > j) {
                                    List<Integer> temp = new ArrayList<>();
                                    temp.add((nums[i]));
                                    temp.add(nums[j]);
                                    temp.add(nums[k]);
                                    temp.add(nums[l]);
                                    if (!result.contains(temp)) {
                                        result.add(temp);
                                    }

                                }
                            }

                        }

                    }

                }
            }

        }


        return result;
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,1, 1,0, 2, -2, -2, -1,-4};
        FourSumHashMap fshm = new FourSumHashMap();
        FourSum fs = new FourSum();
        System.out.println(fs.fourSum(nums, 0));
        System.out.println(fshm.fourSum(nums, 0));

    }
    */
}
