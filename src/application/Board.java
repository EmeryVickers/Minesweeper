package application;

import javafx.scene.layout.GridPane;

public class Board{
	
	// ----- Create GridPane -----// 
	GridPane tiles = new GridPane(); 
	public static Board newInstance = new Board();
	

	public GridPane getBombsBoard() {
		return tiles;
	}


	public void addToBombsBoard(Cell cell, int i, int j) {
		this.tiles.add(cell, i,j);
	}
	    
	
	private Board() {
		
	}
}
