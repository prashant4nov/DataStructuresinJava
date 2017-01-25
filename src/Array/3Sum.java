// https://leetcode.com/problems/3sum/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums==null||nums.length<3) return result;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++) {
            if(i==0||nums[i]>nums[i-1]) { // check for the duplicate values 
            int left = i+1;
            int right = nums.length-1;
            while(left<right) {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0) {
                    List<Integer> aList = new LinkedList<>();
                    aList.add(nums[i]);
                    aList.add(nums[left]);
                    aList.add(nums[right]);
                    result.add(aList);
                    left++; right--;
                    // Handle duplicates
                    while(left<right&&nums[left]==nums[left-1]) left++;
                    while(left<right&&nums[right]==nums[right+1]) right--;
                } else if(sum<0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        }   
                    return result;

    }

}
