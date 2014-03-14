package sortAlgorithms;

public class MergeSortNSpace {

	public int[] merge(int[] A){
		if(A.length<=1){
			return A;
		}
		int n= A.length;
		int mid = n/2;
		int[] arr = merge(A,0,mid);
		int[] brr = merge(A,mid+1,n-1);
		return arrange(arr,brr);
	}
	
	private int[] arrange(int[] A,int[] B){
		if(A == null ^ B == null){
			return A==null?B:A;
		}
		if(A==null && B== null){
			return null;
		}
		int[] arr =new int[A.length+B.length];
		int ax=0,bx=0;
		while(ax<A.length && bx < B.length){
			if(A[ax]>B[bx]){
				arr[ax+bx]=B[bx++];
			}else{
				arr[ax+bx] = A[ax++];
			}
		}
		for(int i =ax;i<A.length;i++){
			arr[i+bx]=A[i];
		}
		for(int i=bx;i<B.length;i++){
			arr[ax+i]=B[i];
		}
		return arr;
	}
	
	private int[] merge(int[] A, int start,int end){
		if(start > end)
			return null;
		if(start==end){
			int[] ret = {A[start]};
			return ret;
		}
		int mid = start + (end-start)/2;
		int[] arr = merge(A,start,mid);
		int[] brr = merge(A,mid+1,end);
		return arrange(arr,brr);
	}
	
	public static void main(String[] argvs){
		MergeSortNSpace instance = new MergeSortNSpace();
		int[] arr = {9,8,7,6,5,6,4,4,1,3,19};
		for(int val : arr){
			System.out.print(val+"  ");
		}
		System.out.println();
		int[] ret = instance.merge(arr);
		for(int val : ret){
			System.out.print(val+"  ");
		}
	}

}
