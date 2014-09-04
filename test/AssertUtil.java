import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;


public class AssertUtil {
	//listһ���Լ��飬��Ҫ��˳��һ��
	public static void assertArrayCommonEquals(List<String> result, List<String> anagrams) {
		// TODO Auto-generated method stub
		String ret = CommonUtil.listToString(result);
		String ana = CommonUtil.listToString(anagrams);
		assertFalse(errorString(ret,ana),result.size() != anagrams.size());
		
		for(String s : result){
			assertFalse(errorString(ret,ana),!anagrams.contains(s));
		}
		assertTrue(true);
		
	}
	
	//������
	public static void assertTreeEquals(TreeNode expected, TreeNode result) {
		if(expected == null || result == null){
			if(expected != null){
				assertFalse(errorString("null",result.val),true);
			}else if(result != null){
				assertFalse(errorString(expected.val,"null"),true);
			}else{
				return;
			}
		}
		assertFalse(errorString(expected.val,result.val),expected.val != result.val);
		assertTreeEquals(expected.left,result.left);
		assertTreeEquals(expected.right,result.right);
	}
	
	//��ά�������
	public static void assert2DArrayEquals(char[][] expecteds, char[][] board) {
    	int m = board.length;
    	if(m == 0)	return;
    	int n = board[0].length;
    	if(n == 0) 	return;
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++){
    			if(board[i][j] != expecteds[i][j]){
    				String expected = CommonUtil.arrayToString(expecteds);
    				String result = CommonUtil.arrayToString(board);
    				assertFalse(errorString(expected, result),true);
    			}
    		}
    	}
	}
	
	//��άlistһ���Լ���
	public static void assertListCommonEquals(List<List<String>> expected,
			List<List<String>> result) {
		String error = errorString(Arrays.toString(expected.toArray()),
				Arrays.toString(expected.toArray()));
		assertFalse(error,expected.size() != result.size());
		for(List<String> list : expected){
			assertFalse(error, !result.contains(list));
		}
	}
	
	
	public static void assertRandomListEquals(RandomListNode expected,RandomListNode result){
		if(expected == null || result == null){
			if(expected == null || result == null){
				if(expected != null){
					assertFalse(errorString("null",result.label),true);
				}else if(result != null){
					assertFalse(errorString(expected.label,"null"),true);
				}else{
					return;
				}
			}
		}
		RandomListNode node1 = expected;
		RandomListNode node2 = result;
		while(node1 != null){
			if(node1.label != node2.label){
				assertFalse("label not equal"+errorString(expected.label,result.label),true);
			}
			if(node1.random == null || node2.random == null){
				if(node1.random != node2.random){
					assertFalse("random not equal null",true);
				}
			}else if(node1.random.label != node2.random.label){
				assertFalse("random "+errorString(node1.random.label,node2.random.label),true);
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		assertFalse(node2 != null);
	}
	
	private static String errorString(Object expected,Object result){
		return "expected:<"+expected+"> but was:<"+result+">";
	}
}
