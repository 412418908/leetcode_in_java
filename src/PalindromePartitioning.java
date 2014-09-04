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
 * answer: �ⷨ2���������ѣ���Ϊn���ַ�����n-1�����Ա��ָ����ÿһ�������ӶȽϸߡ�
 * ��ʵ�кܶ��ظ������Ĵ��Ĳ��������Կ����ö�̬�滮����Щ״̬����������
 * dp[i][j] ����[i,j]֮����ַ��Ƿ��ǻ���
 * dp[i][j] = (s[i] == s[j]) && ( (j-i <= 2) || dp[i+1][j-1] )
 * ʱ��ռ临�Ӷ�O(n^2)
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i=len-1;i>=0;i--){
        	for(int j=i;j<len;j++){
        		dp[i][j] = (s.charAt(i) == s.charAt(j)) &&
        				((j-i <= 2) || dp[i+1][j-1] );
        	}
        }
        List<List<String>> result = new ArrayList<List<String>>();
        Stack<String> path = new Stack<>();
        dfs(s, 0, result, path, dp);
        return result;
    }
    
    //��s[start]֮��ʼ����,����start
	private void dfs(String s, int start, List<List<String>> result,
			Stack<String> path, boolean[][] dp) {
		//��path����result��
		if(start == s.length()){
			result.add((List<String>)path.clone());
			return;
		}
		for(int i=start;i<s.length();i++){
			if(dp[start][i]){
				path.push(s.substring(start, i+1));
				dfs(s,i+1,result,path,dp);
				path.pop();
			}
		}
	}
}
