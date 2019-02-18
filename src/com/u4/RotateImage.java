package com.u4;


public class RotateImage {

	public void rotate(int[][] matrix) {
        int num = matrix.length;//¾ØÕóµÄ½×²ã
        
        for(int i = 0;i < num/2;i++){
            rotate0(matrix, i, num-i*2);
        }
    }
    private void rotate0(int[][] matrix, int x, int length){
        int start_x = x, start_y = 0;
        int temp = 0;
       for(int i = 0;i < length-1;i++){
           start_y = x + i;
           start_x = x;
           temp = matrix[start_x][start_y];
           while(true){
               int[] next = getNextIndex(x, start_x, start_y, length);
               if(next[0] == x && next[1] == x + i){
                   matrix[start_x][start_y] = temp;
                   break;
               }
               matrix[start_x][start_y] = matrix[next[0]][next[1]];
               start_x = next[0];
               start_y = next[1];
           }
       }
    }
    
    private int[] getNextIndex(int x, int i, int j, int length){
        int start_x = i, start_y = j;
        int indsum = x + length-1;
        for(int count = 1;count < length;count++){
            if(start_x == x && start_y > x){
                start_y--;
            }else if(start_y == indsum && start_x > x){
                start_x--;
            }else if(start_x == indsum && start_y < indsum){
                start_y++;
            }else if(start_x < indsum && start_y == x){
                start_x++;
            }
        }
        return new int[]{start_x, start_y};
    }
}
