import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * answer: ʹ��ջ��ģ��ݹ�Ĺ���
 */
public class BinaryTreePostorderTraversal2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return result;
        TreeNode node = root;
        TreeNode pre;
        do{
        	while(node != null){	//��ߵĽڵ㶼��ջ
        		stack.push(node);
        		node = node.left;
        	}
        	pre = null;
        	while(!stack.isEmpty()){
        		node = stack.peek();
        		//������������ʹ��˻�Ϊ�գ�����ʸýڵ�
        		if(node.right == pre){
        			result.add(stack.pop().val);
        			pre = node;
        		}else{
        			node = node.right;
        			break;	//�ȴ���������
        		}
        	}
        }while(!stack.isEmpty());
        return result;
    }
}
