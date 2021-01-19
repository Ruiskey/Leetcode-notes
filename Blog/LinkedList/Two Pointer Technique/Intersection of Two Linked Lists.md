

| title                            | cr_date                              | labels     | updated                              |
| -------------------------------- | ------------------------------------ | ---------- | ------------------------------------ |
| Intersection of Two Linked Lists | 2021年 01月 19日 星期二 17:01:18 CST | LinkedList | 2021年 01月 19日 星期二 17:01:18 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/)  

## Question

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

![](../../images/160_statement.png)

begin to intersect at node c1.

 

**Notes:**

- If the two linked lists have no intersection at all, return `null`.
- The linked lists must retain their original structure after the function returns.
- You may assume there are no cycles anywhere in the entire linked structure.
- Each value on each linked list is in the range `[1, 10^9]`.
- Your code should preferably run in O(n) time and use only O(1) memory.

## 解题思路

1. 我们首先找到两条链表的长度
2. 然后让长的那一条，指针首先移动两个长度差值
3. 然后两个指针再同时移动
4. 当两者相等且！=null则，找到相遇点



## Java Code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if(lengthA > lengthB){
            for(int i=0; i < lengthA - lengthB; i++) headA = headA.next;
        }else{
            for(int i=0; i < lengthB - lengthA ; i++) headB = headB.next;
        }
        while(headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null) ? headA : null;
    }
    public int getLength(ListNode head){
        int count = 0;
        while(head != null){
            ++count;
            head = head.next;
        }
        return count;
    }
}

```



## 方法二

也可以借鉴2指针找环的思路，让两个指针都从head出发，当有一个指针先达到尾部，则转到另一个链表的开头，最终两个指针会相遇在交叉点，因为，它们两个指针走的距离都是两个链表长度之和。

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class test {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null && headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            if(a != null){
                a = a.next;
            }else{
                a = headB;
            }
        
            if(b != null){
                b = b.next;
            }else{
                b = headA;
            }
        }
        return a;

    }

}
```

