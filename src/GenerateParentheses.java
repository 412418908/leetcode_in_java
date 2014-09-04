import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 * answer: �ݹ�����,ʹ��һ��ջ�����ַ�����ʡ�ռ�
 */

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		char[] stack = new char[n * 2];
		List<String> result = new ArrayList<String>();
		dfs(result, stack, 0, 0, 0, n);
		return result;
	}

	//top:ջ��  left:�����Ÿ���  right:�����Ÿ���  n:�����������
	private void dfs(List<String> result, char[] stack, int top, int left,
			int right, int n) {
		if (top == 2*n) {
			result.add(new String(stack));
			return;
		}
		if (left < n) {
			stack[top++] = '(';
			dfs(result, stack, top, left + 1, right, n);
			top--;
		}
		if (right < left) {
			stack[top++] = ')';
			dfs(result, stack, top, left, right + 1, n);
			top--;
		}
	}

}
