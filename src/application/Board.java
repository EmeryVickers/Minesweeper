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
		int x = Integer.parseInt(idSplitter[0]);
		int y = Integer.parseInt(idSplitter[1]);
    	

		
		// Loops through neighboring cells to the received cell and adding to "neighbors" ArrayList 
    	for(int k = -1; k<=1; k++) {
			for(int l = -1; l <= 1; l++) {
				String id = "" + (x + k) + "," + (y + l);
				
				if (isValid(x+k,y+l)) {
					if (!cell.getID().equals(id)) {
						neighbors.add(getCell(id));
					}
				}
				
			}
		}
    	return neighbors;
    }
    
    //makes sure coordinates are not out of bounds
    public boolean isValid(int x, int y) {
		if (x > 9 || x < 0) {
			return false;
		}
		// 
		if (y > 9 || y < 0) {
			return false;
		}
    	return true;
    }
    
    //check for if the player has won
    public void checkForWin() {
    	//if there exists a cell that isnt a mine and isnt broken, the user hasnt won yet
    	 for (Node c: this.tiles.getChildren()) {
    		 if (!((Cell)c).isMine() && !((Cell)c).getRevealed()){
    			 return;
             }
    		 
    	 }
    	 System.out.println("win!");
	}
    
    public void revealNeighbors(Cell cell) {
    	
    	String id = cell.getId();

    	String[] idSplitter = cell.getId().split("," , 0);
    	// Parse X/Y Coordinate of Cell 
		int x = Integer.parseInt(idSplitter[0]);
		int y = Integer.parseInt(idSplitter[1]);
    	
		if (cell.isMine()) {
			System.out.println("cell is a mine");
			return ;
		}
		
    	if (!isValid(x,y) ) {
    		System.out.println("cell is not valid");
    		return ;
    	}
    	
    	if ( cell.getRevealed()) {
    		System.out.println("cell is already revealed");
    		return ;
    	}
    	
    	cell.revealSelf();
    	
    	ArrayList<Cell> neighbors = getNeighbors(cell);
    	revealNeighbors(neighbors.get(0));
    	revealNeighbors(neighbors.get(1));
    	revealNeighbors(neighbors.get(2));
    	revealNeighbors(neighbors.get(3));
    	revealNeighbors(neighbors.get(4));
    	revealNeighbors(neighbors.get(5));
    	revealNeighbors(neighbors.get(6));
    	revealNeighbors(neighbors.get(7));
    	
    	
//
//    	
//    	for(Cell neighbor: getNeighbors(cell)) {
////    			System.out.println("cell is already revealed");
//				revealNeighbors(neighbor);
//				//System.out.println(neighbor.getRevealed())
//    	}

    }
 }