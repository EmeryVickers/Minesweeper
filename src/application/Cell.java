package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Cell extends Button {
	// Private Data Field // 
	private String id = "";
	private boolean isMine = false;
	private boolean isClicked = false;
	private int howManyAround = 0;
	
	// No-Arg Constructor
	public Cell() {
	}
	
	// Generate, Style, and Set Tile ID 
	public void setTile(String id) {
		// Tile ID 
		this.id = id;
		// Styling Tiles
		this.setMinWidth(60);
		this.setMinHeight(35);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
	// Mine Setter 
	public void setMine() {
		this.isMine = true;
	}
	
	// Tile ID Getter 
	public String getID() {
		return id;
	}
	
	
	// First Click of Game 
	public void firstClick(Cell button) {
		System.out.println("First Click\n" + button.id);
		
		// Add Mines AFTER First Click 
		PlayerBoardController controller = new PlayerBoardController(); 
		ArrayList<String> mines = controller.mines; 
		controller.addMines(); 
	} 
	
	// Handles userClick
	public void userClick() {
		if(!isClicked) {
			// Non-Mine
			isClicked = true;
			this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
			// Mine 
			if(isMine) {
				this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			
			locateMines();
		}
	}
	
	// Find All Mines 
	public void locateMines() {
//        for(Node c: Board.newInstance.getBombsBoard().getChildren()) {
//            if (surroundsAndMine((Cell)c)) {
//                
//            }
//        }
        this.setText("" + howManyAround);
    }
    
    public boolean surroundsAndMine(Cell c) {
    	
        return false;
    }
}
