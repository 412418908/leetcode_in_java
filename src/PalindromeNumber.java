/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * answer: ���ַ�ת�����������ÿ��ȡ���ֵĵ�һ�������һ�����бȽ�
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
    	if(x < 0) return false;
        int div = 1;
        while((x/div) >= 10) div *= 10;
        int mod = 10;
        
        while(mod <= div){
        	int left = x/div;
        	int right = x%mod;
        	if(left != right){
        		return false;
        	}
        	x = (x % div)/10;
        	div /= 100;
        }
        return true;
    }
}
