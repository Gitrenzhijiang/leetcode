package com.u5;

public class Searcha2DMatrix {
	
	public static void main(String []args) {
		int[][]matrix = {
		          {1,   3,  5, 7},
		          {10, 11, 16, 20},
		          {23, 30, 34, 50}
		};
		System.out.println(new Searcha2DMatrix().searchMatrix(matrix, 12));
	}
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length <= 0 || matrix[0].length <= 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0;i < row;i++){
            if((matrix[i][0] <= target && i != row-1 && matrix[i+1][0] > target) || (i == row-1 && matrix[i][0] <= target)){
                int t = bSearch(matrix[i], target);
                if(t != -1)
                    return true;
            }
        }
        return false;
    }
    private int bSearch(int[] arr, int target){
        return bSearch0(arr, 0, arr.length-1, target);
    }
    private int bSearch0(int[]arr, int low, int high, int target){
        if(low <= high){
            int start = low;
            int end = high;
            int mid = (start+end)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                return bSearch0(arr, low, mid-1,target);
            }else if(arr[mid] < target){
                return bSearch0(arr, mid+1, high, target);
            }
        }
        return -1;
    }
}

