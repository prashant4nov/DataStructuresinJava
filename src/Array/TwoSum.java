// https://leetcode.com/problems/two-sum/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums==null||nums.length<2) return result;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int tmp = target - nums[i];
            if(mp.containsKey(tmp)) {
                result[0] = mp.get(tmp);
                result [1] = i;
                return result;
            } else {
                mp.put(nums[i], i);
            }
        }
        return result;
    }
}
