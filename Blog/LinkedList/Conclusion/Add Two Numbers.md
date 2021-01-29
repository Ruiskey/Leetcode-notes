

| title           | cr_date                              | labels     | updated                              |
| --------------- | ------------------------------------ | ---------- | ------------------------------------ |
| Add Two Numbers | 2021年 01月 29日 星期五 10:46:18 CST | LinkedList | 2021年 01月 29日 星期五 10:46:18 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1228/)  

## Question

You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order**, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 **用链表实现两个数字的相加**

**Example 1:**

 

![](../../images/addtwonumber1.jpg)



```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

**Example 2:**

```
Input: l1 = [0], l2 = [0]
Output: [0]
```

**Example 3:**

```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

 

**Constraints:**

- The number of nodes in each linked list is in the range `[1, 100]`.
- `0 <= Node.val <= 9`
- It is guaranteed that the list represents a number that does not have leading zeros.



## 解题思路

这里我用的解题思路很无脑，首先是通过创建新链表的方法，然后对l1和l2两个链表的每个节点进行相加处理，然后当有一个链表到达末尾后，使用两个while循环对剩下的那个链表进行加运算，当两个链表都结束后，仍需要判断有没有进一位，收否需要再创建一个Node。


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode head3 = dummyHead;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int sum, sum_single, sum_double = 0;
        while(head1 != null && head2 != null) {
            sum = head1.val + head2.val + sum_double;
            sum_single = sum % 10;
            ListNode newNode = new ListNode();
            newNode.val = sum_single;
            head3.next = newNode;
            head3 = head3.next;
            sum_double = sum / 10;
            System.out.println(head3.val);
            head1 = head1.next;
            head2 = head2.next;
        }
        // head1 == null && head2 == null
        while(head1 != null) {
            sum = head1.val + sum_double;
            sum_single = sum % 10;
            ListNode newNode = new ListNode();
            newNode.val = sum_single;
            head3.next = newNode;
            head3 = head3.next;
            sum_double = sum / 10;
            head1 = head1.next;
        }
        while(head2 != null) {
            sum = head2.val + sum_double;
            sum_single = sum % 10;
            ListNode newNode = new ListNode();
            newNode.val = sum_single;
            head3.next = newNode;
            head3 = head3.next;
            sum_double = sum / 10;
            head2 = head2.next;
        }
        if(sum_double > 0) {
            ListNode newNode = new ListNode();
            newNode.val = sum_double;
            head3.next = newNode;
        }
        return dummyHead.next;
        
    }
}
```



