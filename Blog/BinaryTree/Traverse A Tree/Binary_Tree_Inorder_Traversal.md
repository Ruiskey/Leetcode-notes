

| title                         | cr_date                              | labels      | updated                              |
| ----------------------------- | ------------------------------------ | ----------- | ------------------------------------ |
| Binary Tree Inorder Traversal | 2021年 02月 01日 星期一 11:53:57 CST | Binary Tree | 2021年 02月 01日 星期一 11:53:57 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/)  

## Question

Given the `root` of a binary tree, return *the inorder traversal of its nodes' values*.(中序遍历二叉树)

 

**Example 1:**

![img](../../images/inorder_1.jpg)

```
Input: root = [1,null,2,3]
Output: [1,3,2]
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
Output: [2,1]
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

 

**Follow up:**

Recursive solution is trivial, could you do it iteratively?



## 解题思路 （非递归方法）

利用**栈**工具进行遍历。

1. 对于当前节点若不为空，先压入栈，然后访问它的左子节点
2. 若当前节点为空，则`temp`指向栈顶元素，然后将元素存入list链表，栈顶元素出栈，且temp指向当前节点的右子节点
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

public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null) return null;
        TreeNode temp = root;
//        TreeNode peek = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(temp != null || !stack.empty()) {
            if(temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.peek();
                list.add(temp.val);
                stack.pop();
                temp = temp.right;
            }
        }
        return list;
    }
}
```



## 解题思路 （递归方法）

1. 如果当前节点不为空， 
2. 递归访问其左边子节点
3. list加入当前节点`val`，
4. 递归访问其右边子节点



```java
public class Binary_Tree_Preorder_Traversal2 {
    public List<Integer> InorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Inorder(root, list);
        return list;
    }

    public void Inorder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return ;
        }
        Inorder(root.left, list);
        list.add(root.val);
        Inorder(root.right, list);
    }
    }
```



## 非递归且不使用用户栈

待补充

