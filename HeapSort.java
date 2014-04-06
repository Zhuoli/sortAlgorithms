package sortAlgorithms;

import java.util.Arrays;

public class HeapSort {
	int heapSize = 0;
	public void heapsort(int[] num){
		int[] A = new int[num.length+1];
		A[0]=Integer.MAX_VALUE;
		System.arraycopy(num, 0, A, 1, num.length);
		System.out.println(Arrays.toString(A));
		buildMaxHeap(A);
		for(int i=A.length-1;i>=2;i--){
			swap(A,i,1);
			heapSize--;
			maxHeapify(A,1);
		}
		System.arraycopy(A, 1, num, 0, num.length);
	}
	private void buildMaxHeap(int[] A){
		heapSize = A.length-1;
		for(int i=A.length/2;i>=1;i--){
			maxHeapify(A,i);
		}
	}
	
	private void maxHeapify(int[] A, int i){
		int l=left(i);
		int r =right(i);
		int largest;
		if(l<=heapSize && A[l]>A[i]){
			largest=l;
		}else{
			largest=i;
		}
		if(r<=heapSize && A[r]>A[largest]){
			largest=r;
		}
		if(largest!=i){
			swap(A,i,largest);
			maxHeapify(A,largest);
		}
	}
	private void swap(int[]A,int a,int b){
		int tmp = A[a];
		A[a]=A[b];
		A[b]=tmp;
	}
	private int left(int i){
		return i*2;
	}
	private int right(int i){
		return i*2+1;
	}
	
	public static void main(String[] args){
		HeapSort instance = new HeapSort();
		int[] arr ={7,1,3,19,12,14,15,6,8,1,2};
		instance.heapsort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
