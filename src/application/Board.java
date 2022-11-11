package application;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Board{
	// No-Arg Constructor 
	private Board() {
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
    	for(int k = -1; k<=1; k++) {
			for(int l = -1; l <= 1; l++) {
				String id = "" + (x + k) + "," + (y + l);
				
				if (isValid(x+k,y+l)) {
					Cell neighbor = getCell(id);
					if (!cell.getID().equals(id) && !neighbor.getRevealed()) {
						neighbors.add(neighbor);
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
    public boolean checkForWin() {
    	//if there exists a cell that isnt a mine and isnt broken, the user hasnt won yet
    	 for (Node c: tiles.getChildren()) {
    		 if (!((Cell)c).isMine() && !((Cell)c).getRevealed()){
    			 return false;
             }
    		 
    	 }
    	 return true;
	}
    
    //recursively reveals neighbor
    public boolean revealNeighbors(Cell cell) {
    	
    	String id = cell.getId();

    	String[] idSplitter = cell.getId().split("," , 0);
    	// Parse X/Y Coordinate of Cell 
		int x = Integer.parseInt(idSplitter[0]);
		int y = Integer.parseInt(idSplitter[1]);
    	
		
		if (cell.isMine()) {
			System.out.println("cell is a mine");
			return false;
		}
		
		if (cell.howManyAround > 0) {
			cell.revealSelf();
			return true;
		}
	
		
		cell.revealSelf();
    	
//    	if ( cell.getRevealed()) {
//    		System.out.println("cell is already revealed");
//    		return ;
//    	}
//    	
//    	if (cell.howManyAround != 0) {
//    		cell.revealSelf();
//    		return;
//    	}
//    	
    	
//    	revealNeighbors(neighbors.get(0));
//    	revealNeighbors(neighbors.get(1));
//    	revealNeighbors(neighbors.get(2));
//    	revealNeighbors(neighbors.get(3));
//    	revealNeighbors(neighbors.get(4));
//    	revealNeighbors(neighbors.get(5));
//    	revealNeighbors(neighbors.get(6));
//    	revealNeighbors(neighbors.get(7));
//    	
//    	
//
    	ArrayList<Cell> neighbors = getNeighbors(cell);
    	for(Cell neighbor: neighbors) {
    			
				if (!revealNeighbors(neighbor))
					break;
				//System.out.println(neighbor.getRevealed())
    	}
		return true;

    }
 }