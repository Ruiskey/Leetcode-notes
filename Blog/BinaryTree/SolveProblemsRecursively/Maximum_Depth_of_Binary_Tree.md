

| title                        | cr_date                              | labels      | updated                              |
| ---------------------------- | ------------------------------------ | ----------- | ------------------------------------ |
| Maximum Depth of Binary Tree | 2021年 02月 14日 星期日 22:26:07 CST | Binary Tree | 2021年 02月 14日 星期日 22:26:07 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/)  

## Question

Given the `root` of a binary tree, return *its maximum depth*.

A binary tree's **maximum depth** is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

**Example 1:**

![img](../../images/tmp-tree.jpg)

```
Input: root = [3,9,20,null,null,15,7]
Output: 3
```

**Example 2:**

```
Input: root = [1,null,2]
Output: 2
```

**Example 3:**

```
Input: root = []
Output: 0
```

**Example 4:**

```
Input: root = [0]
Output: 1
```

 

**Constraints:**

- The number of nodes in the tree is in the range `[0, 104]`.
- `-100 <= Node.val <= 100`



## 解题思路 

使用递归的方式，返回树的最大深度


## Java Code

```java
package Solve_Problems_Recursively;

public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}

```


