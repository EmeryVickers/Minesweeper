package application;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Board{
	// No-Arg Constructor 
	private Board() {
	}

	// ----- Create GridPane -----// 
	GridPane tiles = new GridPane(); 
	public static Board newInstance = new Board();
	
	// GridPane "Tiles" Getter 
	//returns entire board
	public GridPane getBombsBoard() {
		return tiles;
	}

	// Add Bombs to Singleton GridPane 
	//add tile to board
	public void addToBombsBoard(Cell cell, int i, int j) {
		this.tiles.add(cell, i,j);
	}
	
	//returns the current cell
    public Cell getCell(String xy) {
        for (Node c: this.tiles.getChildren()) {
            if (((Cell)c).getId().equals(xy)){
                return (Cell)c;
            }
        }
        return new Cell();

    }
    
    public ArrayList<Cell> getNeighbors(Cell cell) {
    	ArrayList<Cell> neighbors = new ArrayList<>();
    	
    	String[] idSplitter = cell.getId().split(",",0);
		int y = Integer.parseInt(idSplitter[0]);
		int x = Integer.parseInt(idSplitter[1]);
    	
    	for(int k = -1; k<=1; k++) {
			for(int l = -1; l<=1; l++) {
				String id =""+(x+k)+","+(y+l);
				neighbors.add(getCell(id));
			}
		}

    	return neighbors;
    }
}
