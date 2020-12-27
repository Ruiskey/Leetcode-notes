public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for(int i=0; i<length; i++) {
            if(nums[i] == val) {
                for(int j=i; j<length; j++) {
                    nums[j] = nums[j+1];
                }
                length--;
            }
        }
        return length;
    }
}
