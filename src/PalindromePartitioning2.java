import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 *   
 * answer: ���ѣ���Ϊn���ַ�����n-1�����Ա��ָ����ÿһ�������Ӷ�O(2^n-1)
 */
public class PalindromePartitioning2 {
    public List<List<String>> partition(String s) {
        Stack<String> path = new Stack<>();
        List<List<String>> result = new ArrayList<List<String>>();

        dfs(s, 0, result, path);
        
        return result;
    }
    
    //��s[start]֮��ʼ����,����start
	private void dfs(String s, int start, List<List<String>> result,
			Stack<String> path) {
		//��path����result��
		if(start == s.length()){
			result.add((List<String>)path.clone());
			return;
		}
		for(int i=start;i<s.length();i++){
			if(isPalindrome(s, start, i)){
				path.push(s.substring(start, i+1));
				dfs(s,i+1,result,path);
				path.pop();
			}
		}
	}
    
    private boolean isPalindrome(String s,int start,int end){
    	while(start < end){
    		if(s.charAt(start) != s.charAt(end)){
    			return false;
    		}
    		start++;
    		end--;
    	}
    	return true;
    }
    
}
