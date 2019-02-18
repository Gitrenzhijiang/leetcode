package com.u8;

public class LTxo {

    public static void main(String[] args) {
      /*X X X X
        X O O X
        X X O X
        X O X X */
        char[][] cs = {
                {'O','O','O'},
                {'O','O','O'},
                {'O','O','O'}
        };
        LTxo lt = new LTxo();
        lt.solve(cs);
        
        for (int i = 0;i < cs.length;i++) {
            for (int j = 0;j < cs[i].length;j++) {
                System.out.print(cs[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void solve(char[][] board) { //O
        int row = board.length;
        if (row <= 0)
            return;
        int col = board[0].length;
        if (col <= 0)
            return;
        // 把边界上是O找到, 对于每一个边界上的O, 继续找到与他相邻的O, 标记为不改变. 
        int [][] map = new int[row][col];
        for (int i = 1;i < row-1;i++){
            if (board[i][0] == 'O'){
                soo(board, map, i, 0, row, col);
            }
            if (board[i][col-1] == 'O'){
                soo(board, map, i, col-1, row, col);
            }
        }
        for (int i = 1;i < col-1;i++){
            // 第一行的
            if (board[0][i] == 'O'){
                soo(board, map, 0, i, row, col);
            }
            // 最后一行
            if (board[row-1][i] == 'O'){
                soo(board, map, row-1, i, row, col);
            }
        }
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (board[i][j] == 'O' && map[i][j] == 0) {
                    if (i > 0 && i < row-1 && j > 0 && j < col-1)
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    // 从i,j 扩散的算法
    private void soo(char[][] board, int[][] map, int i, int j, int row, int col){
        if (i < 0 || i >= row || j < 0 || j >= col)
            return;
        map[i][j] = 1;
        if (i > 0 && board[i-1][j] == 'O' && map[i-1][j] == 0){
            soo(board, map, i-1, j, row, col);
        }
        if (i < row-1 && board[i+1][j] == 'O'&& map[i+1][j] == 0){
            soo(board, map, i+1, j, row, col);
        }
        if (j > 0 && board[i][j-1] == 'O'&& map[i][j-1] == 0){
            soo(board, map, i, j-1, row, col);
        }
        if (j < col-1 && board[i][j+1] == 'O'&& map[i][j+1] == 0){
            soo(board, map, i, j+1, row, col);
        }
    }
}
