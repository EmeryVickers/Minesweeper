package application;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Board{
	
	private Board() {
		
	}

	// ----- Create GridPane -----// 
	GridPane tiles = new GridPane(); 
	public static Board newInstance = new Board();
	
	//returns entire board
	public GridPane getBombsBoard() {
		return tiles;
	}

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
	
	
}
