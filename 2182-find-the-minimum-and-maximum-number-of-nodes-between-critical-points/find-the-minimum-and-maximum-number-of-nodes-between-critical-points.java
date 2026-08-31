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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode dummy= head;
        int n=0;
        while(dummy!=null){
            n++;
            dummy=dummy.next;
        }
        if(n<3){
            return new int[]{-1,-1};
        }
        ListNode prev=head;
        ListNode curr=prev.next;
        ListNode next=curr.next;
        int i=1;
        ArrayList<Integer>list= new ArrayList<>();
        while(next!=null){
            if((curr.val>prev.val && curr.val>next.val)|| (curr.val<prev.val && curr.val<next.val)){
                list.add(i);
            }   
            i++;
            prev=curr;
            curr=next;
            next=curr.next;
        }
        if(list.size()<2){
            return new int[]{-1,-1};
        }
        int min=list.get(1)-list.get(0);
        for(int j=2;j<list.size();j++){
            if(list.get(j)-list.get(j-1)<min){
                min=list.get(j)-list.get(j-1);
            }
        }
        int max=list.get(list.size()-1)-list.get(0);
        return new int[]{min,max};
        

        
    }
}