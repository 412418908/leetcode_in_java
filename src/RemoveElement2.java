/**
 * Given an array and a value, remove all instances 
 * of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't 
 * matter what you leave beyond the new length.
 * 
 * answer: ��Ҫɾ����Ԫ���滻������
 */
public class RemoveElement2 {
    public int removeElement(int[] A, int elem) {
         int begin = 0;
         int end = A.length;
         while(begin < end){
        	 if(A[begin] == elem){
        		 swap(A,begin,--end);
        	 }else{
        		 begin++;
        	 }
         }
         return begin;
    }
    
    private void swap(int[] A,int i,int j){
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}
