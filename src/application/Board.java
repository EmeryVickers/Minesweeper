package application;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Board{
	
	// No-Arg Constructor 
	Board() {
	}

	// Create Board GridPane
	public static GridPane tiles = new GridPane(); 
	public static Board newInstance = new Board();
	
	// GridPane "Tiles" Getter 
	public GridPane getBombsBoard() {
		return tiles;
	}

	// Add Bombs to Singleton GridPane 
	public void addToBombsBoard(Cell cell, int i, int j) {
		tiles.add(cell, i,j);
	}
	
	// Returns the current cell
    public Cell getCell(String xy) {
    	// Loops through cells in ArrayList of "Cells" and returns the cell with the matching ID 
        for (Node c: tiles.getChildren()) {
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
		int x = Integer.parseInt(idSplitter[0]);
		int y = Integer.parseInt(idSplitter[1]);
		
		// Loops through neighboring cells to the received cell and adding to "neighbors" ArrayList 
    	for (int k = -1; k <= 1; k++) {
			for (int l = -1; l <= 1; l++) {
				String id = "" + (x + k) + "," + (y + l);
				// Check if neighbor location is valid 
				if (isValid(x + k, y + l)) {
					Cell neighbor = getCell(id);
					// Check if iterated cell is != to cell and the neighbor is not revealed  
					if (!cell.getID().equals(id) && !neighbor.getRevealed()) {
						neighbors.add(neighbor);
					}
				}
				
			}
		}
    	
    	for (int i = 0; i < neighbors.size(); i++) {
    		System.out.println(neighbors.get(i).getID());
    	}
    	return neighbors;
    }
    
    // Check if location is valid within the GridPane 
    public boolean isValid(int x, int y) {
		if (x > 9 || x < 0) {
			return false;
		} if (y > 9 || y < 0) {
			return false;
		}
    	return true;
    }
    
    // Check if the player has won  
    public boolean checkForWin() {
    	// Check if there are cells that are -> A: not a mine & B: not revealed 
    	 for (Node c: tiles.getChildren()) {
    		 if (!((Cell)c).isMine() && !((Cell)c).getRevealed()){
    			 return false;
             }
    	 }
    	 // If there are no remaining cells other than mines, the player has won 
    	 return true;
	}
    
    // Recursively Reveal Neighboring Tiles  
    public boolean revealNeighbors(Cell cell) {
    	// Check is Tile is Mine 
		if (cell.isMine()) {
			System.out.println("This cell is a mine.");
			return false;
		}
		// Check if there are neighboring mines 
		if (cell.howManyAround > 0) {
			cell.revealSelf();
			return true;
		}
		// Reveal Tile 
		cell.revealSelf();
		// Store neighboring tiles
    	ArrayList<Cell> neighbors = getNeighbors(cell);
    	// Loop through neighbors 
    	for(Cell neighbor: neighbors) {
    		// Break if neighbor 
			if (!revealNeighbors(neighbor)) { 
				break;
			}
    	}
		return true;
    }
 }