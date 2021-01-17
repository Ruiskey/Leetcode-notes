

| title               | cr_date                              | labels     | updated                              |
| ------------------- | ------------------------------------ | ---------- | ------------------------------------ |
| Lindked List Cycle2 | 2021年 01月 16日 星期六 22:05:43 CST | LinkedList | 2021年 01月 16日 星期六 22:05:43 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/)  

## Question

Given a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.

**Notice** that you **should not modify** the linked list.

 

**Example 1:**

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist.png)

```
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
```

**Example 2:**

![img](https://assets.leetcode.com/uploads/2018/12/07/circularlinkedlist_test2.png)

```
Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

**Constraints:**

- The number of the nodes in the list is in the range `[0, 104]`.
- `-105 <= Node.val <= 105`
- `pos` is `-1` or a **valid index** in the linked-list.



## 解题思路

1. 检测是否存在环，首先我们知道只要有环，肯定快慢指针肯定能相遇。
2. 然后等两个指针相遇，慢指针放到开头，快指针从相遇点出发，每次走一步，相遇点则为环入口



## Java Code

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean detectCycle(ListNode head) {
        # 这是是|| 不是 &&
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        # 注意这里是||不是&&
        if(fast == null || slow == null){
            return null;
        }
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

**[参考](https://leetcode-cn.com/problems/linked-list-cycle-lcci/solution/java-kuai-man-zhi-zhen-zhao-ru-kou-jie-dian-you-sh/)**

## 证明

令m为head到环入口点的距离，n为入口点到相遇点的距离，c表示环的长度，ls表示slow指针走的长度，fs表示fast指针走的长度。则

**由于我们设定fast指针的速度是slow指针的两倍，且差值为1，所以直到相遇时，slow指针所走的距离，一定小于c.**

那么现在有：

m + n = ls

fs = m + n + x*c

fs = 2*ls

化简之后可得：

2(m + n) = m + n + x * c => m + n = x * c

**分析：**

当x = 1时，m+n = c，所以head点和相遇点到环入口点的距离均为m.

当x = 2时，m+n = 2*c，这种情况即慢指针从head点到达相遇点时，fast指针已经走了两圈环的距离

当x > 2时，即fast指针走了多圈环的长度

