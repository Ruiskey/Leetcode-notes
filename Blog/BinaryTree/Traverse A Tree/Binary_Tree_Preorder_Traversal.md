

| title                          | cr_date                              | labels      | updated                              |
| ------------------------------ | ------------------------------------ | ----------- | ------------------------------------ |
| Binary Tree Preorder Traversal | 2021年 01月 31日 星期日 13:03:38 CST | Binary Tree | 2021年 01月 31日 星期日 13:03:38 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/)  

## Question

Given the `root` of a binary tree, return *the preorder traversal of its nodes' values*. (先序遍历一个链表)

 

**Example 1:**

![img](../../images/inorder_1.jpg)

```
Input: root = [1,null,2,3]
Output: [1,2,3]
```

**Example 2:**

```
Input: root = []
Output: []
```

**Example 3:**

```
Input: root = [1]
Output: [1]
```

**Example 4:**

![img](../../images/inorder_5.jpg)

```
Input: root = [1,2]
Output: [1,2]
```

**Example 5:**

![img](../../images/inorder_4.jpg)

```
Input: root = [1,null,2]
Output: [1,2]
```

 

**Constraints:**

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

 

**Follow up:** Recursive solution is trivial, could you do it iteratively?



## 解题思路 （非递归方法）

利用**栈**工具进行遍历。

1. 对于当前节点，先压入栈，然后将元素存入list链表，然后访问访问它的左子节点
2. 当当前节点左子节点为空，则访问其右子节点。
3. 当栈为空且当前节点无子节点 则返回最终list


## Java Code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraverse(TreeNode root) {
        var current = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(current != null || !stack.empty()) {
            while(current != null) {
                list.add(current.val);
                stack.push(current);
                current = current.left;
            }
            stack.pop();
            current = current.right;
        }
        return list;
    }
}
```



## 解题思路 （递归方法）

1. 如果当前节点不为空， list加入当前节点`val`，
2. 递归访问其左边子节点
3. 递归访问其右边子节点



```java
    public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraverse(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

public void preorder(TreeNode root, List<Integer> list) {
        if(root == null) {return; }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
}
    }
```

