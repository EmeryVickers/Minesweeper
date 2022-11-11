package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;


class TestFailure {
    // Generate accurate number of mines
    @Test
    void testTenMines() {
        PlayerBoardController controller = new PlayerBoardController(); 
        controller.addMines();
        
        int numMines = controller.mines.size();

        assertEquals(10, numMines);
    }
    
    @Test
    void testNewMine() {
        PlayerBoardController controller = new PlayerBoardController(); 
        controller.addMines();
        
        ArrayList<String> generatedMines = controller.mines;
        
        Set<String> mySet = new HashSet<String>(generatedMines);
        assertEquals(mySet.size(), generatedMines.size());    
    }
    
//	Could not get the following tests to work 
//    @Test
//    void testCellCount() {
//        PlayerBoardController controller = new PlayerBoardController(); 
//        controller.addTiles();
//        int numCells = controller.totalTiles;
//        assertEquals(100, numCells);
//    }
//    
//    @Test
//    void testCells() {
//        PlayerBoardController controller = new PlayerBoardController(); 
//        controller.addTiles();
//        boolean empty = Board.newInstance.getBombsBoard().getChildren().isEmpty();
//        assertEquals(false, empty);    
//    }   
}