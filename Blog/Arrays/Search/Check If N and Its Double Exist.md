

| title              | cr_date                                  | labels | updated                                  |
| ------------------ | ---------------------------------------- | ------ | ---------------------------------------- |
| Merge Sorted Array | 2020年 12月 28日     星期一 08:23:37 CST | array  | 2020年 12月 28日     星期一 08:23:37 CST |



## Leetcode

[explore-fun-with-arrays searching-for-items-in-an-array](https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/) 

## Question

Given an array `arr` of integers, check if there exists two integers `N` and `M` such that `N` is the double of `M` ( i.e. `N = 2 * M`). (检查这个数组中是否有一个元素是另一个元素的两倍)



**Example:**

```
Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
```

 

**Constraints:**

- `2 <= arr.length <= 500`
- `-10^3 <= arr[i] <= 10^3`



## 解题思路

用最笨的办法，从左向右遍历，然后对每一个元素，检查数组中除它之外的元素是否是其两倍



## Java Code

```java
class Solution {
     public boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length == 0) {
            return false;
        }
        int i,j=0;
        while(j < arr.length) {
            for(i=0; i<arr.length; i++) {
                if(arr[j] == 2*arr[i] && i != j) {
                    return true;
                }
            }
            j++;
        }
        return false;      
    }
}
```

