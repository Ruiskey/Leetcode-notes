class Squares_Sorted_Array {
    public int[] sortedSquares(int[] nums) {

        int results[] = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int idx = nums.length - 1;
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                results[idx--] = nums[left] * nums[left];
                left++;
            }else{
                results[idx--] = nums[right] * nums[right];
                right--;
            }

        }

        return results;
    }
}