package application;

import javafx.scene.layout.GridPane;

public class Board{
	
	// No-Arg Constructor 
	private Board() {
	}
	
	// ----- Create GridPane ----- // 
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
}
