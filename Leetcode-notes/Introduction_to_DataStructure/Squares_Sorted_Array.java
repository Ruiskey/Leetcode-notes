class Solution {
    public int[] sortedSquares(int[] nums) {

        int left = 0 ;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int idx = nums.length - 1;

        while(left <= right)
        {
            if(Math.abs(nums[left]) > nums[right])
            {
                result[idx--] = nums[left] * nums[left];
                left++;
            }
            else
            {
                result[idx--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}