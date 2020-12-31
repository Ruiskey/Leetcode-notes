

| title              | cr_date                              | labels | updated                              |
| ------------------ | ------------------------------------ | ------ | ------------------------------------ |
| Merge Sorted Array | 2020年 12月 31日 星期四 19:08:56 CST | array  | 2020年 12月 31日 星期四 19:08:56 CST |

## Leetcode

[explore-fun-with-arrays in-place-operations](https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/) 

## Question

Given an array `arr`, replace every element in that array with the greatest element among the elements to its right, and replace the last element with `-1`. (对数组中每个元素替换为其右手边最大值，最后一为替换为-1)



**Example:**

```
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
```

 

**Constraints:**

- `1 <= arr.length <= 104`
- `1 <= arr[i] <= 105`

## 解题思路

用最笨的办法，从左向右遍历，然后对每一个元素，再另外做一个`for`循环遍历



## Java Code O(n*n)

```java
public class update_01 {
    public int[] replaceElements(int[] arr) {
        if(arr==null) {
            return arr;
        }
        int i=0;
        while(i<arr.length-1) {
            int max=arr[i+1];
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j]>max) {
                    max = arr[j];
                }
            }
            arr[i] = max;
            i++;
        }
        arr[i] = -1;
        return arr;
    }
}
```





## 方法二：O(n)

思路：因为数组中元素都是大于1的，从右往左开始遍历，每次比较遍历中遇到的最大值

```
class Solution {
    public int[] replaceElements(int[] arr) {
        int max=-1;
        for(int i=arr.length-1; i>=0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if(max<temp) {
                max=temp;
            }
            
    }
        return arr;
}
}
```

