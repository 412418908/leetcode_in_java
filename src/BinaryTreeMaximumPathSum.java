/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 *
 * answer: dfs �����б�������������������Ľ��L ��R�����L ����0��
 * ��ô�Ժ�������������ģ����Ǽ���L�����R ����0���Ժ������Ҳ�������ģ���������R��
 */
public class BinaryTreeMaximumPathSum {
	private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    private int dfs(TreeNode root){
    	if(root == null) return 0;
    	int left = dfs(root.left);
    	int right = dfs(root.right);
    	int sum = root.val;
    	if(left > 0)
    		sum += left;
    	if(right >0)
    		sum += right;
    	max = Math.max(max, sum);
    	return Math.max(left, right) > 0 ? Math.max(left, right)+root.val : root.val;
    }
}
