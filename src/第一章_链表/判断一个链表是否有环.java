package 第一章_链表;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 判断一个链表是否有环
 * 这题我们得用快慢指针，定义两个指针，一个指针一次走一步，另外一个指针一次走两步，如果他们能够相遇，则说明有环
 */
public class 判断一个链表是否有环 {
    public static void main(String[] args) {
        ListNode nodeA = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        nodeA.next.next.next.next.next.next=nodeA.next.next;
        boolean result=isRing(nodeA);
        System.out.println(result);
    }

    private static boolean isRing(ListNode nodeA) {
        if(nodeA==null){
            return false;
        }
        ListNode fast=nodeA;
        ListNode slow=nodeA;
        while(slow!=null && fast.next!=null){
            if(slow==fast){
                return true;
            }else{
                slow=slow.next;
                fast= fast.next.next;
            }
        }
        return false;
    }
}
