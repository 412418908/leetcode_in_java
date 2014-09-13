import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * answer: ȥ�ص�ȫ���о��Ǵӵ�һ��������ÿ�����ֱ�����������ظ����ֵ����ֽ�����
 * �ñ�̵Ļ��������ǵ�i�������j��������ʱ��Ҫ��[i,j)��û�����j������ȵ�����
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	permute(res,num,0);
    	return res;
    }
    
    private void permute(List<List<Integer>> res,int[] num,int k){
		if (k == num.length) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i : num) list.add(i);
			res.add(list);
			return;
		}
		for (int i = k; i < num.length; i++) {
			if (isValid(num, k, i)) {
				swap(num, k, i);
				permute(res, num, k + 1);
				swap(num, k, i);
			}
		}
	}

	private boolean isValid(int[] A, int i, int j) {
		for (; i < j; i++) {
			if (A[i] == A[j]) {
				return false;
			}
		}
		return true;
	}

	private void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
