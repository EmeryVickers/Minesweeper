package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.After;
import org.junit.Before;

import junit.framework.TestCase;



class TestFailure {
	 
	//Generate accurate number of mines
	@Test
	void testTenMines() {
		PlayerBoardController playerBoard = new PlayerBoardController(); 
		playerBoard.addMines();
		
		int numMines = playerBoard.mines.size();
		
		assertEquals(10, numMines);
	}
	
	
	@Test
	void testTotalCells() {
		PlayerBoardController test = new PlayerBoardController(); 
		test.addTiles();
		int totalCells = test.tiles.impl_getColumnCount();
		int totalCells2 = test.tiles.impl_getRowCount();
		
		assertEquals(100.0, totalCells);
		
	}
	

}
