/**
 * Given a binary tree
 * 
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 *     
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree 
 * (ie, all leaves are at the same level, and every parent has two children).
 * 
 * 
 * answer: ��ΪҪ�����ռ䣬���Բ���ʹ�ö��й��ѡ�
 * ��Ϊ�ڱ�����һ���ʱ����һ���Ѿ���next�����ˣ�����ʹ�����������������ɡ�
 */
public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		while (root != null) {
			TreeLinkNode first = root;	//��һ��ĵ�һ���ڵ�
			TreeLinkNode pre = null;	//������ǰ�Ľڵ�
			for (; root != null; root = root.next) {
				if (pre != null) {
					pre.next = root.left;
				}
				if(root.left != null){
					root.left.next = root.right;
				}
				pre = root.right;
			}
			root = first.left;
		}
	}
}
