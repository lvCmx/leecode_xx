package 第一章_链表;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 已知链表头节点指针head，将链表从位置 m 到 n 逆序。
 * 我们首先要知道：m的前驱，因为反转后在放到m的后驱
 *              要知道m节点，m.next等于n之后的节点
 *              n节点，将n放在m的前驱做后驱
 *              n的后驱
 */
public class 链表的逆序_按范围反转 {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        listNode =reverseListNode(listNode,2,6);
        ListNodeUtil.print(listNode);
    }

    /**
     * 反转链表
     * @param head
     */
    public static ListNode reverseListNode(ListNode head,int m,int n){
        if(head==null){
            throw new RuntimeException("链表为空");
        }
        int changeLeng=n-m+1;
        ListNode result=head;
        ListNode mnodePre=null;
        // m前
        while(head!=null && --m>0){
            mnodePre=head;
            head=head.next;
        }

        // 反转部分
        ListNode modifyListTail=head;
        ListNode newHead=null;
        while(head!=null && changeLeng-- >0){
            ListNode next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        modifyListTail.next=head;
        if(mnodePre!=null){
            mnodePre.next=newHead;
        }else{
            result=newHead;
        }
        return result;
    }
}
