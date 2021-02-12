

| title                           | cr_date                              | labels      | updated                              |
| ------------------------------- | ------------------------------------ | ----------- | ------------------------------------ |
| Binary Tree Postorder Traversal | 2021年 02月 12日 星期五 23:10:20 CST | Binary Tree | 2021年 02月 12日 星期五 23:10:20 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/)  

## Question

Given the `root` of a binary tree, return *the Postorder traversal of its nodes' values*.(后序遍历二叉树)

 

**Example 1:**

![img](../../images/inorder_1.jpg)

```
Input: root = [1,null,2,3]
Output: [3,2,1]
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
Output: [2,1]
```

 

**Constraints:**

- The number of nodes in the tree is in the range `[0, 100]`.
- `-100 <= Node.val <= 100`

 

**Follow up:**

Recursive solution is trivial, could you do it iteratively?



## 解题思路 （非递归方法）




## Java Code

```java
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 解法一 将之前先序遍历的顺序变换，然后将数组插入的方式改变，改为从头插入
 */

public class Binary_Tree_Postorder_Traversal {
    public List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while(temp != null || !stack.empty()) {
            if(temp != null) {
                stack.push(temp);
                list.add(0, temp.val);
                temp = temp.right;
            } else {
                temp = stack.peek();
                stack.pop();
                temp = temp.left;
            }
        }
        return list;
    }
}

/**
 * 解法二 这个效率没有上一个高 思路类似
 */
class Binary_Tree_Postorder_Traversal2 {
    public List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.empty()) {
            TreeNode temp = stack.peek();
            stack.pop();
            list.add(0, temp.val);
            if(temp.left != null) stack.push(temp.left);
            if(temp.right != null) stack.push(temp.right);
        }
        return list;
    }
}

```



## 解题思路 （递归方法）

1. 如果当前节点不为空， 
2. 递归访问其左边子节点
3. 递归访问其右边子节点
4. list加入当前节点`val`，



```java
/**
 * 递归写法
 */
class Binary_Tree_Postorder_Traversal3 {
    public List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        PostOrder(list, root);
        return list;
    }

    public void PostOrder(List<Integer> list, TreeNode root) {
        if(root == null) return;
        PostOrder(list, root.left);
        PostOrder(list, root.right);

        list.add(root.val);
    }
}
```



