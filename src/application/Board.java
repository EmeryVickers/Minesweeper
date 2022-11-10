package application;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Board{
	// No-Arg Constructor 
	private Board() {
	}

	// Create Board GridPane
	GridPane tiles = new GridPane(); 
	public static Board newInstance = new Board();
	
	// GridPane "Tiles" Getter 
	public GridPane getBombsBoard() {
		return tiles;
	}

	// Add Bombs to Singleton GridPane 
	public void addToBombsBoard(Cell cell, int i, int j) {
		this.tiles.add(cell, i,j);
	}
	
	// Returns the current cell
    public Cell getCell(String xy) {
    	// Loops through cells in ArrayList of "Cells" and returns the cell with the matching ID 
        for (Node c: this.tiles.getChildren()) {
            if (((Cell)c).getId().equals(xy)){
                return (Cell)c;
            }
        }
        return new Cell(); 
    }
    
    // Receives cell and returns neighboring cells in ArrayList 
    public ArrayList<Cell> getNeighbors(Cell cell) {
    	// ArrayList of neighboring cells to the given cell 
    	ArrayList<Cell> neighbors = new ArrayList<>();
    	
    	// Split ID of Cell into X/Y Coordinates 
    	String[] idSplitter = cell.getId().split("," , 0);
    	// Parse X/Y Coordinate of Cell 
		int y = Integer.parseInt(idSplitter[0]);
		int x = Integer.parseInt(idSplitter[1]);
    	
		// Loops through neighboring cells to the received cell and adding to "neighbors" ArrayList 
    	for(int k = -1; k<=1; k++) {
			for(int l = -1; l <= 1; l++) {
				String id = "" + (x + k) + "," + (y + l);
				neighbors.add(getCell(id));
			}
		}

    	return neighbors;
    }
}
