

| title              | cr_date                                  | labels | updated                                  |
| ------------------ | ---------------------------------------- | ------ | ---------------------------------------- |
| Merge Sorted Array | 2020年 12月 27日     星期日 23:23:37 CST | array  | 2020年 12月 27日     星期日 23:23:37 CST |



## Leetcode

[explore-fun-with-arrays deleting-items-from-an-array](https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/) 

## Question

Given an array *nums* and a value `val`, remove all instances of that value [**in-place**](https://en.wikipedia.org/wiki/In-place_algorithm) and return the new length. (删除除val之外的元素)



**Example:**

```
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 2.
It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
```

 

**Constraints:**

- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`



## 解题思路

用最笨的办法，从左至右遍历数组，若`==val`，则将后续数组向前移，`length--`，**并且检查下一个是不是也==val**



## Java Code

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for(int i=0; i<length; i++) {
            if(nums[i] == val) {
                for(int j=i+1; j<length; j++) {
                    nums[j-1] = nums[j];
                }
                if(nums[i] == val) {
                    i--;
                }
                length--;
            }
        }
        return length;
    }
}
```

