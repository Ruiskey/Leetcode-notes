

| title                               | cr_date                                  | labels | updated                                  |
| ----------------------------------- | ---------------------------------------- | ------ | ---------------------------------------- |
| Remove Duplicates from Sorted Array | 2020年 12月 28日     星期一 09:20:15 CST | array  | 2020年 12月 28日     星期一 09:20:15 CST |



## Leetcode

[explore-fun-with-arrays deleting-items-from-an-array](https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3248/) 



## Question

Given a sorted array *nums*, remove the duplicates [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) such that each element appears only *once* and returns the new length. (删除数组中连续相同的数字，只留一个，然回最后数组个数)



**Example:**

```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
```

 

**Constraints:**

- `0 <= nums.length <= 3 * 104`
- `-104 <= nums[i] <= 104`
- `nums` is sorted in ascending order.

## 解题思路

设置两个`index i,j`，每次j先向数组右边移动，并每次与i比较，如果相同就向后移，直到不相同，然后把num[j]的数值复制给i的下一格。 **注意检测数组是否越界**



## Java Code

```java
class Solution {
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
```

