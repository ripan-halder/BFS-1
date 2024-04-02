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
    
    // Approach 1: BFS
    /**
        TC -> O(N), where N is the total number of nodes in the tree
        SC -> O(N), worst scenario, queue will have all nodes.
     */
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> resBFS = new ArrayList<>();
        if(root == null) return resBFS;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);  
            }
            resBFS.add(level);
        }
        return resBFS;
    }


    // Approach 2: DFS
    /**
        TC -> O(N), where N is the total number of nodes in the tree
        SC -> O(H), the stack will take max space of height of the tree
     */
    List<List<Integer>> resDFS;

    public List<List<Integer>> levelOrder(TreeNode root) {
        resDFS = new ArrayList<>();
        if(root == null) return resDFS;
        helper(root, 0);
        return resDFS;
    }

    private void helper(TreeNode root, int level){
        if(root == null) return;

        if(resDFS.size() < level+1){
            resDFS.add(new ArrayList<>());
        }

        resDFS.get(level).add(root.val);
        
        if(root.left != null) helper(root.left, level+1);
        if(root.right != null) helper(root.right, level+1);
    }

}
