package 第一章_链表;

import common.ListNode;
import common.ListNodeUtil;

/**
 * 求两个链表的最近交点
 * 这题是利用链表长度来解决的
 * 首先求A链表长度为m
 * 再次B链表长度为n
 * m>n
 * 则m链表先前进m-n位，然后A，B两链表同时前进，判断节点是否相等
 */
public class 求两个链表的交点 {
    public static void main(String[] args) {
        ListNode nodeA = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode nodeB = ListNodeUtil.createListNode(new int[]{9, 4, 5, 6, 7});
        int result=findIntersectionNode(nodeA,nodeB);
        System.out.println(result);
    }

    private static int findIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return -1;
        }
        int lengthA=0;
        int lengthB=0;
        ListNode nodeA=headA;
        ListNode nodeB=headB;
        while(nodeA!=null || nodeB!=null){
            if(nodeA!=null){
                nodeA=nodeA.next;
                lengthA++;
            }
            if(nodeB!=null){
                nodeB=nodeB.next;
                lengthB++;
            }
        }
        // headB的长度是否比headA的链表长
        if(lengthA<lengthB){
            int temp=lengthA;
            lengthA=lengthB;
            lengthB=temp;

            //交换链表
            ListNode tempNode=headA;
            headA=headB;
            headB=tempNode;
        }
        int num=lengthA-lengthB;
        while(headA!=null || headB!=null){
            if(num-->0){
                headA=headA.next;
            }else{
                if(headA.value==headB.value){
                    return headA.value;
                }else{
                    headA=headA.next;
                    headB=headB.next;
                }
            }
        }
        return -1;
    }
}
