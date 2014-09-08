/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * 
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL 
 *
 * answer: ������"Populating Next Right Pointers in Each Node II"���ơ�
 * �ⷨҲ���ƣ�ֻ����������nextָ���ʱ����ֱ�ӽ����ҽڵ������ˡ�
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        while(root != null){
        	TreeLinkNode first = null;	//��һ���һ���ǿյĽڵ�
        	TreeLinkNode pre = null;	//Ҫ���ӵ�ǰһ���ڵ�
        	for(; root != null; root = root.next){
        		if(first == null){
        			first = (root.left != null) ? root.left : root.right;
        		}
        		if(root.left != null){
        			if(pre != null)  pre.next = root.left;
        			pre = root.left;
        		}
        		if(root.right != null){
        			if(pre != null)  pre.next = root.right;
        			pre = root.right;
        		}
        	}
        	root = first;
        }
    }
}
