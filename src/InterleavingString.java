/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * answer: ��̬�滮��dp[i][n-i] ��ʾs3��ǰn���Ӵ��Ƿ������s1ǰi���Ӵ���s2ǰ(n-i)���Ӵ�����
 * ���ж�̬���̣�
 * dp[i][n-i] = (i-1 >=0 && dp[i-1][n-i] && s1[i-1]==s3[n-1]) ||
 * 		        (n-i-1 >= 0 && dp[i][n-i-1] && s2[n-i-1]==s3[n-1])
 *
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
        	return false;
        }
        
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;	//��ʼ�����
        for(int n=1;n<=s3.length();n++){
        	for(int i=Math.max(0, n-s2.length());i<=s1.length() && (n-i)>=0;i++){
        		if(n-i-1 >= 0 && dp[i][n-i-1] && s2.charAt(n-i-1) == s3.charAt(n-1)){
        			dp[i][n-i] = true;
        		}else if(i-1 >=0 && dp[i-1][n-i] && s1.charAt(i-1) == s3.charAt(n-1)){
        			dp[i][n-i] = true;
        		}
        	}
        }
        return dp[s1.length()][s2.length()];
    }
}
