

| title              | cr_date                              | labels | updated                              |
| ------------------ | ------------------------------------ | ------ | ------------------------------------ |
| Merge Sorted Array | 2020年 12月 31日 星期四 15:32:04 CST | array  | 2020年 12月 31日 星期四 15:32:04 CST |



## Leetcode

[explore-fun-with-arrays searching-for-items-in-an-array](https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/) 

## Question

Given an array of integers `arr`, return *`true` if and only if it is a valid mountain array*.. (检查这个数组排列元素的顺序是否是从小至大再至小的顺序，并且不允许出现平坡)



**Example1:**

```
Input: arr = [2,1]
Output: false
```

 **Example2:**

```
Input: arr = [0,3,2,1]
Output: true
```

**Constraints:**

- `1 <= arr.length <= 104`
- `0 <= arr[i] <= 104`



## 解题思路

用两个while循环分别判断`上坡`和`下坡`，并且也要判断数是否只有单个坡度的出现



## Java Code

```java
class Solution {
      public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        int i=0;
        int j=1;
        while(j<length) {
            if(arr[i] < arr[j]) {
                i++;
                j++;
            }else if(arr[i] == arr[j]){
                return false;
            }else{
                break;
            }
        }
        if(j==length){
            return false;
        }
        if(j==1){
            return false;
        }
        while(j<length) {
            if(arr[i] > arr[j]) {
                i++;
                j++;
            }else{
                return false;
            }
        }
        return true;
    }
}
```

