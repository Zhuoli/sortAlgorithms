package sortAlgorithms;

public class QuickSort {
	public void quickSort(int[] A){
		quickSort(A,0,A.length);
	}
	private void quickSort(int[] A,int left, int right){
		if(right>left){
			int pivotIndex = selectPivotIndex(A,left,right);
			int pivotNewIndex = partition(A,left,right,pivotIndex);
			quickSort(A,left,pivotNewIndex-1);
			quickSort(A,pivotNewIndex+1,right);
		}
	}
	private int selectPivotIndex(int[] A,int left,int right){
		return right;
	}
	private int partition(int[] A, int left, int right,int pivotIndex){
	  swap(A,right,pivotIndex);
		  int j=left;
		  for(int i=left;i<right;i++){
			  if(A[i]<A[pivotIndex]){
				  swap(A,i,j++);
			  }
		  }
		  swap(A,j,right);
		  return j;
	}
	
	private void swap(int[] A,int a, int b){
		int temp=A[a];
		A[a]=A[b];
		A[b]=temp;
	}
}
