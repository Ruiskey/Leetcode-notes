/**
 * java
 * 问题描述：将两个数组n和数组m合并到一个数组，且两个数组都是排序好的
 * 
 */

public class Merge_Sorted {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx_1 = m-1;
        int idx_2 = n-1;
        for(int i=m+n-1; i>=0; i--) {
            if(idx_2 < 0) {
                break;
            }
            if((idx_1>=0) && (nums1[idx_1] > nums2[idx_2])) {
                nums1[i] = nums1[idx_1];
                idx_1--;
            }else{
                nums1[i] = nums2[idx_2];
                idx_2--;
            }
        }

    }
}