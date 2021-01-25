

| title                  | cr_date                              | labels     | updated                              |
| ---------------------- | ------------------------------------ | ---------- | ------------------------------------ |
| Palindrome Linked List | 2021年 01月 25日 星期一 11:09:25 CST | LinkedList | 2021年 01月 25日 星期一 11:09:25 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/)  

## Question

Given a singly linked list, determine if it is a palindrome.(判断回文链表)

**Example 1:**

```
Input: 1->2
Output: false
```

**Example 2:**

```
Input: 1->2->2->1
Output: true
```

**Follow up:**
Could you do it in O(n) time and O(1) space?



## 解题思路

这道题的思路不难(对于我还是难得。。)，一种解决思路是，找到链表的中点，然后从链表的中点将后半部分链表反转，最后再逐一对比前后两个链表，如果相同则返回`true`。


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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        // find middle point
        ListNode slow = head;
        ListNode fast = head.next;
        System.out.print(slow.val);
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse
        System.out.print(slow.val);
        if(slow.next != null){
            slow = slow.next;
        }
        System.out.print(slow.val);
        ListNode prev = null;
            while(slow != null){
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }
        // check equals
        System.out.print(slow);
        ListNode pre = head;
        ListNode p2 = prev;
        while(pre != null && p2 != null && pre.val == p2.val){
            System.out.print(pre.val);
            pre = pre.next;
            p2 = p2.next;
        }
        return p2 == null;
    }
}
```



