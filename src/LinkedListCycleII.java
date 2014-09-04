/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * answer:����ָ�룬�������ָ��ص������ÿ��һ���ߣ��ٴ�������Ϊ�������
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean hasCircle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCircle = true;
				break;
			}
		}
		if(!hasCircle) return null;
		fast = head;
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
    }
}
