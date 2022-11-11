package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {
	Board board = new Board(); 

	@Test
	void testValidLocation() {
        assertEquals(false, board.isValid(-1, -1));
        assertEquals(false, board.isValid(11, 11));
        assertEquals(true, board.isValid(1, 0));
        assertEquals(true, board.isValid(9, 9)); 
	}
	
//  Could not test getNeighbors(), but this was the attempt 
//	@Test
//	void testGetNeighbors() {
//		/* 
//		 * 	0,0 -> 0,1
//		 *  |  \
//		 *  1,0  1,1
//		 */
//		// Test Cells 
//		Cell cell = new Cell();
//		cell.setTile("0,0");
//		Cell cell1 = new Cell();
//		cell.setTile("1,1");
//		Cell cell2 = new Cell();
//		cell2.setTile("0,1");
//		Cell cell3 = new Cell(); 
//		cell3.setTile("1,0");
//		// Test ArrayList 
//		ArrayList<Cell> testList = new ArrayList<>();
//		testList.add(cell1);
//		testList.add(cell2); 
//		testList.add(cell3);
//		
//		// Neighbor ArrayList 
//		ArrayList<Cell> cellList = board.getNeighbors(cell);
//		
//		// Test neighboring cells ID
//		for (int i = 0; i < cellList.size(); i++) {
//			assertEquals(testList.get(i), cellList.get(i));
//		}
//	}
}
