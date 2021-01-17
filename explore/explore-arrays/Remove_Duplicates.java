public class Remove_Duplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums == null) {
            return 0;
        }
        int i,j=1;
        for(i=0; i<nums.length; i++) {
            while(j<nums.length && nums[i] == nums[j]) {
                j++;
            }
            if(j>=nums.length) {
                break;
            }
            nums[i+1] = nums[j];
        }
        return i+1;
    }
}
