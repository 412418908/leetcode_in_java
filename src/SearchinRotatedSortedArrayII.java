/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 *
 * answer:  
 * ��һ�������A[m]>=A[l], ��ô[l,m] Ϊ�������еļ���Ͳ��ܳ����ˣ���
 * ��[1,3,1,1,1]��
 * ���A[m]>=A[l] ����ȷ���������ǾͰ�����ֳ�����������
 * - ��A[m]>A[l]��������[l,m] һ������
 * - ��A[m]==A[l] ȷ�����ˣ��Ǿ�l++�����¿�һ�����ɡ�
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        int mid;
        while(left <= right){
        	mid = left + ((right-left)>>1);
        	if(A[mid] == target){
        		return true;
        	}
        	if(A[mid] > A[left]){		//[left,mid] Ϊ��������
        		if(A[left] <= target && target < A[mid]){
        			right = mid - 1;
        		}else{
        			left = mid + 1;
        		}
        	}else if(A[mid] < A[left]){		//[mid,right] Ϊ��������
        		if(A[mid] < target && target <= A[right]){
        			left = mid + 1;
        		}else{
        			right = mid - 1;
        		}
        	}else{		// A[mid] == A[left] 
        		left ++;	//�����ظ�Ԫ��
        	}
        }
        return false;
    }
}
