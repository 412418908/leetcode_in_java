import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", 
 * which has length = 2.
 * 
 * Another example is ")()())", where the longest valid 
 * parentheses substring is "()()", which has length = 4.
 *
 * answer: ʹ��ջ��ջ�д�����±꣬ʱ��O(N) �ռ�O(N)
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    	Stack<Integer> stack = new Stack<>();
    	int max = 0;
        int last = -1;	//�������һ����ƥ��� ')' ���±�
        char c;
        for(int i=0;i<s.length();i++){
        	c = s.charAt(i);
        	if(c == '('){
        		stack.push(i);
        	}else if(c == ')'){
        		if(stack.isEmpty()){
        			last = i;	//�������һ����ƥ��� ')'
        		}else{
        			stack.pop();
        			if(stack.isEmpty()){
        				max = Math.max(max, i - last);
        			}else{
        				max = Math.max(max, i - stack.peek());
        			}
        		}
        	}
        }
        return max;
    }
}
