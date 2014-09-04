/**
 * Given an array of integers, every element appears 
 * three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * answer��ʹ��λ���㣬ʱ��O(N) �ռ�O(1)
 * ��������one��two����һ������һ�γ��ֻ��ȱ�����one�У��ڶ��γ�����one�������
 * ������two�У������γ��ֻὫtwo�������������one���ɡ� "�ö�����ģ��������"
 */
public class SingleNumberII {
    public int singleNumber(int[] A) {
    	int one = 0;
    	int two = 0;
        for(int i=0;i<A.length;i++){
        	one = (one ^ A[i]) & ~two;
        	two = (two ^ A[i]) & ~one;
        }
        return one;
    }
}
