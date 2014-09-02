/**
 * Given an unsorted integer array, find the first missing positive integer.
 * Your algorithm should run in O(n) time and uses constant space.
 *
 * answer: ʹ��hash��ʱ��O(N)���ռ�Ҳ��O(N)  �����û���ڴ����
 */

import java.util.HashSet;

public class FirstMissingPositive2 {
    public int firstMissingPositive(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>(A.length);
        for(int i : A){
        	if(i > 0) set.add(i);	
        }
        int index = 1;
        while(set.contains(index)){
        	index ++ ;
        }
        return index;
    }
}
