package sortAlgorithms;
/**
 *  http://blog.csdn.net/zhongkeli/article/details/8786694
 *  
 *  Time complexity: O(nlogn)
 *  Space Complexity: O(1)
 * @author CT61557
 *
 */
public class MergeSortConstantSpace {
	public void merge(int[] A){
		merge(A,0,A.length/2);
		merge(A,A.length/2,A.length);
		arrange(A,0,A.length/2,A.length);
	}
	
	private void merge(int[] A, int start, int end){
		if(end - start<=1){
			return;
		}
		else{
			int cut = start + (end-start)/2;
			merge(A,start,cut);
			merge(A,cut,end);
			arrange(A,start,cut,end);
		}
	}
	
	private void arrange(int[] A,int start, int cut, int end){
		if(end-start<=1){
			return;
		}else{
			int k=start;
			int ai=start;
			int bi=cut;
			while(ai<cut&&bi<end){
				if(A[ai]<=A[bi]){
					A[k++]=A[ai++];
				}else{
					int j=bi;
					while(j<end && A[j]<A[ai] ){
						j++;
					}
					exchange(A,k,bi,j);
					k +=j-bi;
					ai +=j-bi;
				}
			}
		}
	}
	
	private void exchange(int[] A, int start, int cut, int end){
		reverse(A,start,cut);
		reverse(A,cut,end);
		reverse(A,start,end);
	}
	
	private void reverse(int[] A, int start,int end){
		int offset = end-start;
		for(int i=0;i<offset/2;i++){
			int tmp = A[start+i];
			A[start+i]=A[start+offset-i-1];
			A[start+offset-i-1]=tmp;
		}
	}
	
	public static void main(String[] argvs){
		MergeSortConstantSpace instance = new MergeSortConstantSpace();
		int[] arr = {6,5,4,3,2,1,11,15,13,7};
		for(int val : arr){
			System.out.print(val+" ");
		}
		System.out.println();
		instance.merge(arr);
		//instance.exchange(arr, 0, 2, 6);
		for(int val : arr){
			System.out.print(val+" ");
		}
		System.out.println();
	}
}
