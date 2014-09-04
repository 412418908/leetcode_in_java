/**
 * Given an array of integers, every element appears 
 * three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * answer���ó�Ϊ32��int�����ڴ����ÿһλ��1���ֵĴ��������Ϊ3�ı�����
 * ��Ҫ�ҵ����ڸ�λ�ϲ�Ϊ1,   ʱ��O(N) �ռ�O(1)
 */
public class SingleNumberII2 {
	public int singleNumber(int[] A) {
		final int BITS = 32;
		int[] times = new int[BITS];
		for (int i = 0; i < A.length; i++) {
			for (int k = 0; k < BITS; k++) {
				times[k] += (A[i] >> k) & 1;
				times[k] %= 3;
			}
		}
		int result = 0;
		for (int k = 0; k < BITS; k++) {
			result |= (times[k] << k);
		}
		return result;
	}
}
