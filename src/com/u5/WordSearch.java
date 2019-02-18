package com.u5;

import java.util.ArrayList;
import java.util.List;

/**
 * wordSearch
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 *
 */
public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		String word = "A";
		System.out.println("res:"+new WordSearch().exist(board, word));
		System.out.println("res2:"+ new WordSearch().search(board, word));
	}
	
	public boolean search(char[][] board, String word) {
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[i].length;j++) {
				if(search0(board, word, 0, i, j))return true;
			}
		}
		return false;
	}
	public boolean search0(char[][]board, String word, int cur, int x, int y) {
		if(x < 0 || y < 0 || x >= board.length || y >= board[0].length )
			return false;
		
		if(board[x][y] != word.charAt(cur))
			return false;
		if(cur == word.length() -1)
			return true;
		board[x][y] = '#';
		boolean res = search0(board, word, cur+1, x-1, y)
				|| search0(board, word, cur+1, x+1, y)
				|| search0(board, word, cur+1, x, y-1)
				|| search0(board, word, cur+1, x, y+1);
		board[x][y] = word.charAt(cur);
		return res;
	}
	
	
	
	
	
	
	
	
	public boolean exist(char[][] board, String word) {
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[i].length;j++) {
				if(board[i][j] == word.charAt(0)) {
					if(word.length()==1)
						return true;
					Point point = new Point(i,j);
					List<Point> list = new ArrayList<>();
					list.add(point);
					boolean res = fun(board, word.toCharArray(), 1, list, i, j);
					if(res)
						return res;
				}
			}
		}
		return false;
	}
	public boolean fun(char[][] board, char[]words, int cur, List<Point> list, int x, int y) {
	
		char curChar = words[cur];
		List<Point> lists = new ArrayList<>();
		if(x - 1 >= 0 && board[x-1][y] == curChar) {
			lists.add(new Point(x - 1, y));
		}
		if(y - 1 >= 0 && board[x][y - 1] == curChar)
			lists.add(new Point(x, y - 1));
		if(x + 1 < board.length && board[x + 1][y] == curChar)
			lists.add(new Point(x + 1, y));
		if(y + 1 < board[x].length && board[x][y + 1] == curChar)
			lists.add(new Point(x, y+1));
		for(Point point:lists) {
			if(!list.contains(point)) {
				if(cur == words.length - 1)
					return true;
				list.add(point);
				boolean res = fun(board, words, cur+1, list, point.x, point.y);
				if(res == true)
					return true;
				list.remove(point);
			}
		}
		return false;
	}
	class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj == null)
				return false;
			if(obj == this)
				return true;
			Point other = null;
			if(obj instanceof Point) {
				other = (Point)obj;
			}
			if(other.x != this.x || other.y != y)
				return false;
			return true;
		}
	}
}
