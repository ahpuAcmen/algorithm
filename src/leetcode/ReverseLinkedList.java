package leetcode;

import java.util.Stack;

public class ReverseLinkedList {


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {

        public static void main(String[] args) {
            ListNode listNode1 = new ListNode(1);
            ListNode listNode2 = new ListNode(2);
            ListNode listNode3 = new ListNode(3);
            listNode2.next = listNode3;
            listNode1.next = listNode2;
            ListNode listNode = ReverseList(listNode1);
            System.out.println(listNode);
        }

        public static ListNode ReverseList(ListNode head) {
            if(head == null){
                return head;
            }

            Stack<ListNode> stack = new Stack<ListNode>();
            stack.push(head);
            while(head.next != null){
                stack.push(head.next);
                head = head.next;
            }
            ListNode listNode = new ListNode(stack.pop().val);
            ListNode current;
            current = listNode;
            while(!stack.empty()){
                ListNode temp = new ListNode(stack.pop().val);
                current.next = temp;
                current = current.next;
            }
            return listNode;
        }
    }

}
