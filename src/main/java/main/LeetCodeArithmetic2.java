package main;

import testModel.ListNode;

/**
 * Create by 孙斌 on 2019/11/5.
 */

/**
 * LeetCode第2题：两数相加
 */
public class LeetCodeArithmetic2 {
    public static void main(String[] args){

        ListNode result1 = new ListNode(9);
        result1.next = new ListNode(4);
        result1.next.next = new ListNode(5);
        result1.next.next.next = new ListNode(9);

        ListNode result2 = new ListNode(2);
        result2.next = new ListNode(8);
        result2.next.next = new ListNode(4);
        result2.next.next.next = new ListNode(2);


        ListNode listNode = addTwoNumbers(result1, result2);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @param ln1
     * @param ln2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode ln1, ListNode ln2) {
        int sum = 0;
        int minus = 0;
        int remainder = 0;
        ListNode result = new ListNode(0);
        ListNode pro = result;
        while (ln1 != null || ln2 != null){
            int ln1Val = ln1 == null ? 0 : ln1.val;
            int ln2Val = ln2 == null ? 0 : ln2.val;

            sum = ln1Val + ln2Val;

            if(remainder != 0){
                sum += remainder;
                remainder = 0;
            }

            minus = sum / 10;
            if(minus != 0){
                remainder = sum % 10;
                pro.next = new ListNode(remainder);
                remainder = minus;
            }else {
                pro.next = new ListNode(sum);
            }

            if(ln1 == null){
                ln1 = null;
            }else {
                ln1 = ln1.next;
            }

            if(ln2 == null){
                ln2 = null;
            }else {
                ln2 = ln2.next;
            }

            pro = pro.next;
        }
        if(remainder != 0){
            pro.next = new ListNode(remainder);
        }
        return result.next;
    }



}
