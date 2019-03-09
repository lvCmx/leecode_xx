package 第一章_链表;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 已知链表头节点指针head，将链表逆序。
 * 要求不能使用额外的空间
 */
public class 链表的逆序 {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        listNode =reverseListNode(listNode);
        ListNodeUtil.print(listNode);
    }

    /**
     * 反转链表
     * @param head
     */
    public static ListNode reverseListNode(ListNode head){
        if(head==null){
            throw new RuntimeException("链表为空");
        }
        ListNode newHead=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        return newHead;
    }
}
