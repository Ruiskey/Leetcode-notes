

| title                             | cr_date                              | labels      | updated                              |
| --------------------------------- | ------------------------------------ | ----------- | ------------------------------------ |
| Binary Tree Level Order Traversal | 2021年 02月 13日 星期六 23:07:46 CST | Binary Tree | 2021年 02月 13日 星期六 23:07:46 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/)  

## Question

Given a binary tree, return the *level order* traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```



return its level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```

## 解题思路 （非递归方法）

这里对于每一层使用一个队列去读取所有元素，

然后在while循环中，使用for去遍历每个队列中的元素


## Java Code

```java
public class Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> llist = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode temp = queue.poll();
                llist.add(temp.val);
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
        list.add(llist);
        }
        return list;
    }
}
```



## 解题思路 （递归方法）

待续。。