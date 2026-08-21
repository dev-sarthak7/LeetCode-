/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head= new ListNode();
        ListNode dum= head;
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        
        while(list1!=null && list2!=null){
            ListNode curr= new ListNode();
            if(list1.val <list2.val){
                curr.val= list1.val;
                list1=list1.next;
            }else{
                curr.val= list2.val;
                list2=list2.next;
            }
            dum.next= curr;
            dum=dum.next;
        }
        while(list1!=null){
            ListNode c= new ListNode(list1.val);
            dum.next=c;
            dum=dum.next;
            list1=list1.next;
        }
        while(list2!=null){
            ListNode c= new ListNode(list2.val);
            dum.next=c;
            dum=dum.next;
            list2=list2.next;
        }
        return head.next;


    }
}