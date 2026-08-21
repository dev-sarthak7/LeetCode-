/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

      if(head==null) return false;
      ListNode sp= head.next;
        if(sp==null){
            return false;
        }
        ListNode fp=sp.next;
        
        while(fp!=null && fp.next!=null){
           
            
            if(sp==fp){return true;}
            sp=sp.next;
            fp=fp.next.next;
        }
        return false;
    }
}