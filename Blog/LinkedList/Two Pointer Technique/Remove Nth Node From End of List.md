

| title                            | cr_date                              | labels     | updated                              |
| -------------------------------- | ------------------------------------ | ---------- | ------------------------------------ |
| Remove Nth Node From End of List | 2021年 01月 19日 星期二 21:22:36 CST | LinkedList | 2021年 01月 19日 星期二 21:22:36 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/)  

## Question

Given the `head` of a linked list, remove the `nth` node from the end of the list and return its head.

**Follow up:** Could you do this in one pass?（通过一次遍历的方式删除倒数第n个节点）

![](../../images/remove_ex1.jpg)

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

**Example 2:**

```
Input: head = [1], n = 1
Output: []
```

**Example 3:**

```
Input: head = [1,2], n = 1
Output: [1]
```



**Constraints:**

- The number of nodes in the list is `sz`.
- `1 <= sz <= 30`
- `0 <= Node.val <= 100`
- `1 <= n <= sz`

## 解题思路

1. 使用两个指针，一前一后，前面那个先移动n步，然后前后一起走，当前面节点到达倒数第二个，则对后面的指针进行删除操作



## Java Code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode pre = head;
        ListNode post = head;
        for(int i=0; i<n; i++) post = post.next;
        // post 已经到达尾部
        if(post == null) return head.next;
        while(post.next != null){
            pre = pre. next;
            post = post.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}

```



