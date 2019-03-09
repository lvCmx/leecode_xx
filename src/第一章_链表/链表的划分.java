package 第一章_链表;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 已知链表头指针head与数值x，将所有小于x的节点放在大于或等于x的节点前，且保持这些节点的原来的相对位置
 * 这题的思路：
 *  可以定义两个指针，一个指针存储所有小于x的值
 *                  一个指针存储所有大小x的值
 */
public class 链表的划分 {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.createListNode(new int[]{5,2,13,15, 5, 62, 7,3,2});
        int k=18; // 按18进行划分
        ListNode result = partitionNodeByKey(head,k);
        ListNodeUtil.print(result);
    }

    private static ListNode partitionNodeByKey(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode ltPre=new ListNode(-1,null);
        ListNode gtPre=new ListNode(-1,null);
        ListNode lt= ltPre;
        ListNode gt= gtPre;
        while(head!=null){
            ListNode next = head.next;
            head.next=null;
            if(head.value>k){
                gt.next=head;
                gt=gt.next;
            }else{
                lt.next=head;
                lt=lt.next;
            }
            head=next;
        }
        lt.next=gtPre.next;
        return ltPre.next;
    }
}
