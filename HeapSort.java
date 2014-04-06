package sortAlgorithms;

import java.util.Arrays;

public class HeapSort {
	int heapSize = 0;
	private void buildMaxHeap(int[] A){
		heapSize = A.length;
		for(int i=A.length/2;i>=0;i--){
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
		int[] arr ={7,1,3};
		instance.buildMaxHeap(arr);
		System.out.println(Arrays.toString(arr));
	}
}
