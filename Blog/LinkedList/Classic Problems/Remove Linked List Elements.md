

| title                       | cr_date                              | labels     | updated                              |
| --------------------------- | ------------------------------------ | ---------- | ------------------------------------ |
| Remove Linked List Elements | 2021年 01月 22日 星期五 21:23:48 CST | LinkedList | 2021年 01月 22日 星期五 21:23:48 CST |

## Leetcode

[linked-list](https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/)  

## Question

Remove all elements from a linked list of integers that have value ***val\***.

**Example:**

```
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
```



## 解题思路

这道题的思路比较简单，就是创建两个指针，一个在前，一个在后，如果检测到前一个的下一个节点的值==val，则，然后prev指针的指向前一个指针的下一个节点。



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
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        if(head.next==null && head.val==val) return null;
        ListNode temp=head;
        ListNode prev=head;
        while(temp!=null){
            // 为了防止[1,1,1]这样的指针出现 注意&&两边的顺序不能变换 不然会出现空指针异常
            if(head!=null && head.val==val){
                head=head.next;
                continue;
            }
            if(temp.val==val ){
               prev.next=temp.next;
                temp=temp.next;
            } else{
                prev=temp;
                temp=temp.next;
            }
        }
        return head;
    }
}
```



