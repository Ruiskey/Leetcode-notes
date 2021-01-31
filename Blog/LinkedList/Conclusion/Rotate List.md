

| title       | cr_date                              | labels     | updated                              |
| ----------- | ------------------------------------ | ---------- | ------------------------------------ |
| Rotate List | 2021年 01月 30日 星期六 11:51:59 CST | LinkedList | 2021年 01月 30日 星期六 11:51:59 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/)

## Question

Given the `head` of a linked list, rotate the list to the right by `k` places.

旋转链表问题，有点类似于理发店门口那个一直往上旋转的灯。

 

**Example 1:**

![](../../images/rotate1.jpg)

```
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
```

**Example 2:**

![](../../images/roate2.jpg)

```
Input: head = [0,1,2], k = 4
Output: [2,0,1]
```

 

**Constraints:**

- The number of nodes in the list is in the range `[0, 500]`.
- `-100 <= Node.val <= 100`
- `0 <= k <= 2 * 109`

 


## 解题思路（一）

我们只要保证找到距离尾节点k步的那个节点就可以了。**但是需要注意，k有可能大于或远远大于链表的长度，所以我们需要先数出链表的长度**，然后利用`k % length`，计算出实际要走的步数。

这里采用两个指针：

1. 首先计算出链表长度
2. 然后让`fast`指针先走`k % n`步
3. `fast`和`slow`同时向前走，当`fast`到尾节点截至
4. 取`slow`的下一个节点为`newHead`头节点


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
    public ListNode rotateRight(ListNode head, int k) {
	if(head == null) return null;
        ListNode dummyHead = head;
        int n = 0;
        while(dummyHead != null) {
            dummyHead = dummyHead.next;
            n++;
        }
        k = k % n;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k; i++) {
            if(fast != null) {
                fast = fast.next;
            }
        }
//        if(fast == null) return head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        fast = slow.next;
        slow.next = null;
        return fast;
            }
}
```





## 解题思路（二）

这里其实和上面思路差不多，只是用了一个指针（**而且效率远没有以上的高**）

1. 首先计算出链表的长度
2. 然后让尾节点和头节点相连，成为一个环
3. 计算出`m = length - k % length`，即实际要走的距离
4. 然后让走完之后节点的下一个节点成为newHead节点，并断开环。

## Java Code

```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
       if(head == null) return null;
        int n = 1;
        ListNode dummyHead = head;
        while(dummyHead.next != null) {
            dummyHead = dummyHead.next;
            ++n;
        }
        System.out.println(n);
        System.out.println(dummyHead.val);
        dummyHead.next = head;
        // dummyHead = head;
        int m = n - k % n;
        System.out.println(m);
        for(int i = 0; i < m; i++) {
            dummyHead = dummyHead.next;
        }
        ListNode newHead = dummyHead.next;
        dummyHead.next = null;
        return newHead;
    }
}
```

