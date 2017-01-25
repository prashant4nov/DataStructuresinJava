// https://leetcode.com/problems/third-maximum-number/  fb/ git/ li

public class Solution {  
    public int thirdMax(int[] nums) {
        
        if (nums.length < 3) return (nums[0] < nums[1]) ? nums[1] : nums[0];
        
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            
            int n = nums[i];
            
            if(n > first) {
                third = second;
                second = first;
                first = n;
            } else if(n > second && n < first) {
                third = second;
                second = n;
            } else if(n > third && n < second) {
                third = n;
            }
        }
        
        return (third==Long.MIN_VALUE) ? (int) first : (int) third;

    }
}
