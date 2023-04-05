package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = getListNodeNums(l1);
        List<Integer> list2 = getListNodeNums(l2);
        int maxLength = list1.size()>=list2.size()?list1.size():list2.size();
        // if(list1.size() = list2.size() && list1.get(0) + list2.get(0)>=10){
        int minLength = list1.size()<=list2.size()?list1.size():list2.size();
        // }
        int up = 0;
        int[] result = new int[maxLength+1];
        for(int i = 0 ;i<minLength;i++){
            // int sum = list1.get(list1.size()-1-i)+list2.get(list2.size()-1-i) + up;
            // up = sum / 10;
            // result[maxLength - i] = sum % 10;
            int sum = list1.get(i)+list2.get(i) + up;
            up = sum / 10;
            result[i] = sum % 10;
        }
        if(list1.size() == list2.size() ){
            if(up > 0){
                result[maxLength] = up;
                // return result;
                return intIntoListNode(result);
            }else{
                return intIntoListNode(Arrays.copyOfRange(result,0,maxLength));
            }
        }else{
            List<Integer> lenList = list1.size()>list2.size()?list1:list2;
            for(int i = minLength;i<maxLength;i++){
                int sum = lenList.get(i) + up;
                up = sum / 10;
                result[i] = sum % 10;
            }
            if(up > 0){
                result[maxLength] = up;
                // return result;
                return intIntoListNode(result);
            }else{
                return intIntoListNode(Arrays.copyOfRange(result,0,maxLength));
            }
        }
    }

    List<Integer> getListNodeNums(ListNode listNode){
        List<Integer> list = new ArrayList();

        while(true){
            list.add(listNode.val);
            if(listNode.next == null){
                break;
            }
            listNode = listNode.next;
        }
        return list;
    }

    ListNode intIntoListNode(int[] result){


        ListNode resultNode = new ListNode();
        ListNode lastNode = new ListNode();
        for (int i = result.length - 1; i >= 0; i--) {
            resultNode.val = result[i];
            if ( i  == result.length - 1){
                resultNode.next = null;
            }else {
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




    public static void main(String[] args) {
        Solution solution = new Solution();
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

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
//        System.out.println(listNode.next.next.val);

    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
