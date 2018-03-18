package Midterm;

import java.util.ArrayList;

/*
 * Name:Zhihao Li
 * Date: 03/17/2018
 */
public class Maze {

	public ArrayList<Cell> findPath(int[][] maze) {
		ArrayList<Cell> arrList = new ArrayList<Cell>();
		if(maze == null || maze.length == 0 || maze[0].length == 0){
			return arrList;
		}
		findPath(maze, 0, 0, arrList);
		return arrList;

	}

	public boolean findPath(int[][] maze, int row, int col, ArrayList<Cell> list) {
		int n = maze.length;
		int m = maze[0].length;
		if (row > n - 1 || col > m - 1 || maze[row][col] == 0)
			return false;

		list.add(new Cell(row, col));

		if (row == n - 1 && col == m - 1) {
			return true;
		}

		if (findPath(maze, row + 1, col, list))// check right
			return true;
		if (findPath(maze, row, col + 1, list))// check down
			return true;

		list.remove(list.size() - 1);
		return false;
	}
	
	public static void main(String[] args) {
		Maze rim = new Maze();
		int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		System.out.println(rim.findPath(maze));
	}

	class Cell {
		int x, y;

		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "[" + this.x + ", " + this.y + "]";
		}
	}


}
