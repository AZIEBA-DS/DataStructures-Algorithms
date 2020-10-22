package aStackQueue;

import java.util.Scanner;

public class Maze {

	private char[][] maze = { { '*', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' } };

	private int m_row = 0;
	private int m_column = 0;
	private boolean m_game = true;
	private IStack<String> undo = new StackAL<String>();
	private IStack<String> redo = new StackAL<String>();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		Maze m = new Maze();

		while (m.m_game == true) {
			if (m.undo.isEmpty()) {
				m.print();
				System.out.println();
				System.out.println("What have you mage?");
				System.out.print("N: North\nS: South\nE: East\nW: West\nG: Grog\nU: Undo\nR: Redo\nQ: Quit\n");

				String m_direction = scr.next();
				m.move(m_direction);
			} else {
				System.out.println("Undo Stack: " + m.undo.toString());
				System.out.println("Redo Stack: " + m.redo.toString());
				m.print();
				System.out.println();
				System.out.println("What have you mage?");
				System.out.print("N: North\nS: South\nE: East\nW: West\nG: Grog\nU: Undo\nR: Redo\nQ: Quit\n");

				String m_direction = scr.next();
				m.move(m_direction);
			}

		}
		scr.close();
	}

	public void cardinalDirection(String direction) {
		switch (direction.toUpperCase()) {
		case "N":
			if (getRow() == 0) {
				System.out.println("Ouch!");
			} else {
				undo.push("S");
				maze[getRow()][getColumn()] = '-';
				m_row--;
				maze[getRow()][getColumn()] = '*';
			}
			break;

		case "S":
			if (getRow() == 9) {
				System.out.println("Ouch!");
			} else {
				undo.push("N");
				maze[getRow()][getColumn()] = '-';
				m_row++;
				maze[getRow()][getColumn()] = '*';
			}
			break;

		case "E":
			if (getColumn() == 9) {
				System.out.println("Ouch!");
			} else {
				undo.push("W");
				maze[getRow()][getColumn()] = '-';
				m_column++;
				maze[getRow()][getColumn()] = '*';
			}
			break;

		case "W":
			if (getColumn() == 0) {
				System.out.println("Ouch!");
			} else {
				undo.push("E");
				maze[getRow()][getColumn()] = '-';
				m_column--;
				maze[getRow()][getColumn()] = '*';
			}
			break;

		case "G":
			System.out.println("Glug!");
			undo.push("G");
			break;

		default:
			return;
		}
	}

	public void move(String direction) {

		switch (direction.toUpperCase()) {

		case "N":
		case "S":
		case "E":
		case "W":
		case "G":
			cardinalDirection(direction);
			break;

		case "Q":
			System.out.println("Quitting.");
			m_game = false;
			return;

		case "U":
			undo();
			return;

		case "R":
			redo();
			return;

		default:
			System.out.println("Invalid Input");
			return;
		}
		redo.clear();
	}

	public int getRow() {
		return m_row;
	}

	public int getColumn() {
		return m_column;
	}

	public void undo() {
		if (!undo.isEmpty()) {
			String top = undo.top();
			undo.pop();
			if (top == "N") {
				cardinalDirection("N");
				undo.pop();
				redo.push("S");
			}

			else if (top == "S") {
				cardinalDirection("S");
				undo.pop();
				redo.push("N");
			}

			else if (top == "W") {
				cardinalDirection("W");
				undo.pop();
				redo.push("E");
			}

			else if (top == "E") {
				cardinalDirection("E");
				undo.pop();
				redo.push("W");
			} else if (top == "G") {
				System.out.println("Blah!");
				undo.pop();
			} else if (undo.isEmpty()) {
				System.out.println("Stack is Empty");
			}
		} else {
			System.out.println("No moves to undo.");
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			String top = redo.top();
			redo.pop();

			cardinalDirection(top);
		} else {
			System.out.println("No moves to redo.");
		}
	}

	public void print() {

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
}
