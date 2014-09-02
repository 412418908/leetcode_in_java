/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * answer: �Ե����Ϲ����ķ�����ʱ��O(N) �ռ�O(1)
 * ��ʵ����������һ����������������������
 * �ڵݹ��д��Ķ���ͬһ������ֻ���������Ľڵ㲻ͣ��ǰ�ߣ������������Ա仯�������䣻
 * ���Կ�����ÿ�εݹ���ÿ�ʼʱ���ڵ�ָ�붼ָ�������һ��������ʱ�ڵ��ָ��ָ������ĩβ�ĺ�һ����
 * ÿ�εݹ����ʱ���ֳ����������֣���߹�����ʱ������ָ��ָ��mid������һ��root�����������Ҳ���������
 */

public class ConvertSortedListtoBinarySearchTree {
	private ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node != null){
        	length ++ ;
        	node = node.next;
        }
        cur = head;
        return buildTree(0,length-1);
    }
    
    //�Ե����Ϲ�����
    private TreeNode buildTree(int start,int end){
    	if(start > end) return null;
    	int mid = start + ((end-start)>>1);
    	TreeNode left = buildTree(start,mid-1);
    	TreeNode root = new TreeNode(cur.val);
    	root.left = left;
    	cur = cur.next;
    	root.right = buildTree(mid+1,end);
    	return root;
    }
}
