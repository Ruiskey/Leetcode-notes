/**
 * 设置两个index，一个记录非0值下标在前，一个记录共有的非0值下标，再前的到数组末尾，然后j后面补0
 */


public class update_03 {
    public void moveZeroes(int[] nums) {
        if(nums==null && nums.length==0) {
            System.out.println(nums);;
        }else{
            int i=0;
            int j=0;
            while(i<nums.length) {
                if(nums[i] == 0) {
                    i++;
                }else{
                    nums[j] = nums[i];
                    j++;
                    i++;
                }
            }
            while(j<nums.length) {
                nums[j] = 0;
                j++;
            }
        }
        
    }
}
