

| title              | cr_date                                  | labels | updated                                  |
| ------------------ | ---------------------------------------- | ------ | ---------------------------------------- |
| Merge Sorted Array | 2020年 12月 25日     星期五 22:51:01 CST | array  | 2020年 12月 25日     星期五 22:51:01 CST |



## Leetcode

[explore-fun-with-arrays inserting-items-into-an-array](https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/) 

## Question

Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**

- The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.
- You may assume that *nums1* has enough space (size that is **equal** to *m* + *n*) to hold additional elements from *nums2*.

**Example:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```

 

**Constraints:**

- `-10^9 <= nums1[i], nums2[i] <= 10^9`
- `nums1.length == m + n`
- `nums2.length == n`



## 解题思路

之前我自己想的都是将两个数组从左边开始依次比较对应下表元素的大小，然后每次移动`nums1`数组中的后续元素，这样时间复杂度较大。

#### new solution

这里是在`discuss`中看的别人的思路，它从两个数组的第m-1 和n-1位置开始比较，较大的这个直接放到`nums1`数组右边，然后右边的`index`向左移动



## Java Code

```java
class Solution {
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
```

