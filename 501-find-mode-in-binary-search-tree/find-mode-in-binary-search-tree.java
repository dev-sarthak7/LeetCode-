/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int currNum=0;
    int currFreq=0;
    int maxFreq=0;
    ArrayList<Integer> result= new ArrayList<>();

    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(root.val==currNum){
            currFreq++;
        }else{
            currNum=root.val;
            currFreq=1;
        }
        if(currFreq>maxFreq){
            maxFreq=currFreq;
            result.clear();
            result.add(currNum);
        }else if(currFreq==maxFreq){
            result.add(currNum);
        }
        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res= new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
        return res;
    }
}