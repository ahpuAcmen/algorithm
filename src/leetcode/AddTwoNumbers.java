package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {

    /**
     * 两数相加
     * 1.获取两数的字符数组
     * 2.对两数的字符数组按照顺序相加
     * 3.对结果数组按照变成链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //获取初始链表的数字列表
        List<Integer> list1 = getListNodeNums(l1);
        List<Integer> list2 = getListNodeNums(l2);
        //计算最大长度
        int maxLength = list1.size() >= list2.size() ? list1.size() : list2.size();
        // if(list1.size() = list2.size() && list1.get(0) + list2.get(0)>=10){
        //计算最小长度
        int minLength = list1.size() <= list2.size() ? list1.size() : list2.size();
        // }
        int up = 0;
        int[] result = new int[maxLength + 1];
        //计算位数重合部分
        for (int i = 0; i < minLength; i++) {
            // int sum = list1.get(list1.size()-1-i)+list2.get(list2.size()-1-i) + up;
            // up = sum / 10;
            // result[maxLength - i] = sum % 10;
            int sum = list1.get(i) + list2.get(i) + up;
            up = sum / 10;
            result[i] = sum % 10;
        }

        if (list1.size() == list2.size()) {
            //两数长度相同
            if (up > 0) {
                result[maxLength] = up;
                // return result;
                return intIntoListNode(result);
            } else {
                return intIntoListNode(Arrays.copyOfRange(result, 0, maxLength));
            }
        } else {
            //两数长度不同
            List<Integer> lenList = list1.size() > list2.size() ? list1 : list2;
            for (int i = minLength; i < maxLength; i++) {
                int sum = lenList.get(i) + up;
                up = sum / 10;
                result[i] = sum % 10;
            }
            if (up > 0) {
                result[maxLength] = up;
                // return result;
                return intIntoListNode(result);
            } else {
                return intIntoListNode(Arrays.copyOfRange(result, 0, maxLength));
            }
        }
    }

    /**
     * 获取初始链表的数字列表
     *
     * @param listNode
     * @return
     */
    List<Integer> getListNodeNums(ListNode listNode) {
        List<Integer> list = new ArrayList();

        while (true) {
            list.add(listNode.val);
            if (listNode.next == null) {
                break;
            }
            listNode = listNode.next;
        }
        return list;
    }

    /**
     * 数组变链表
     *
     * @param result
     * @return
     */
    ListNode intIntoListNode(int[] result) {


        ListNode resultNode = new ListNode();
        ListNode lastNode = new ListNode();
        for (int i = result.length - 1; i >= 0; i--) {
            resultNode.val = result[i];
            if (i == result.length - 1) {
                resultNode.next = null;
            } else {
                resultNode.next = lastNode;
            }
            lastNode = new ListNode();
            lastNode.val = resultNode.val;
            lastNode.next = resultNode.next;
        }
        return resultNode;

//
//        ListNode resultNode = new ListNode();
//        for (int i = 0;i<result.length;i++){
//
//
//            resultNode.val = result[i];
//
//        }
//
//
//        ListNode lastNode = new ListNode();
//        for (int i = result.length -1;i>=0;i--){
//            resultNode.val = result[i];
//            resultNode.next = lastNode;
//            lastNode.val = resultNode.val;
//            lastNode.next = resultNode.next;
//        }

//        for(int i = 0;i<result.length;i++){
//            resultNode.val = result[i];
//            ListNode bakNode = new ListNode();
//            bakNode.val = lastNode.val;
//            resultNode.next = lastNode;
//            lastNode = resultNode;
//        }
//        return resultNode;
    }


    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        listNode1.val = 5;
        listNode2.val = 5;
//        ListNode listNode3 = new ListNode();
//        ListNode listNode4 = new ListNode();
//        ListNode listNode5 = new ListNode();
//        ListNode listNode6 = new ListNode();
//        ListNode listNode7 = new ListNode();
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
//        listNode1.val = 9;
//        listNode2.val = 9;
//        listNode3.val = 9;
//        listNode4.val = 9;
//        listNode5.val = 9;
//        listNode6.val = 9;
//        listNode7.val = 9;
//
//
//        ListNode listNode8 = new ListNode();
//        ListNode listNode9 = new ListNode();
//        ListNode listNode10 = new ListNode();
//        ListNode listNode11 = new ListNode();
//        listNode8.next = listNode9;
//        listNode9.next = listNode10;
//        listNode10.next = listNode11;
//        listNode8.val = 9;
//        listNode9.val = 9;
//        listNode10.val = 9;
//        listNode11.val = 9;

        //计算两数之和
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
//        System.out.println(listNode.next.next.val);

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode current = pre;
        int up = 0;
        while (l1.next != null || l2.next != null) {
            int liv1 = l1 == null ? 0 : l1.val;
            int liv2 = l2 == null ? 0 : l2.val;
            int sum = liv1 + liv2 + up;
            up = sum/10;
            int result = sum % 10;
            current.next = new ListNode(result);
            current = current.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (up == 1){
            current.next = new ListNode(up);
        }

        return pre.next;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
