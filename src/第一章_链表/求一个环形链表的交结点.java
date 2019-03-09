package 第一章_链表;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 这题的思路：
 * 1，求出快慢指针两个指针的交点
 * 2、在两个指针相遇的时候
 *          起始指针向后重新走，
 *          从相遇的位置慢指针继续向后走，当新起始的指针与慢指针相遇的时候，就是一环形链表的交结点
 */
public class 求一个环形链表的交结点 {
    public static void main(String[] args) {
        ListNode nodeA = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        nodeA.next.next.next.next.next.next.next=nodeA.next.next;
        ListNode result=findRangNode(nodeA);
        System.out.println(result.value);
    }

    /**
     * 如果节点有环，则返回头指针
     * @param head
     * @return
     */
    private static ListNode findRangNode(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && slow!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                break;
            }
        }
        // 然后新节点重新从头开始，而slow则继续
        ListNode reslow=head;
        while(reslow!=null && slow!=null){
            if(reslow==slow){
                return slow;
            }
            reslow=reslow.next;
            slow=slow.next;
        }
        return null;
    }
}
