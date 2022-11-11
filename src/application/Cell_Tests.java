package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Cell_Tests {

	//Makes sure that cells display the correct value of mines around them/blank if 0
	@Test
	void test_howManyAround(Cell cell) {
		if (cell.howManyAround > 0 && cell.getRevealed()) {
			assertEquals(cell.howManyAround, cell.getText());
		}else{
			assertEquals("",cell.getText());
		}
		
	}
	

}
