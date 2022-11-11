package application;

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
	// Cell Data Field 
	private String id = "";
	private boolean isMine = false;
	private boolean isRevealed = false;
	public boolean flagState = false;
	public int howManyAround;
	
	// Constructor 
	public Cell() {
		this.setTextFill(Color.WHITE);
	}
	
	// Generate, Style, and Set Tile ID 
	public void setTile(String id) {
		// Tile ID 
		this.id = id;
		// Style Tiles
		this.setMinWidth(60);
		this.setMinHeight(35);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		// Style Mines 
		if (this.isMine) {
			this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		}
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
		
		// Add Mines AFTER First Click 
		PlayerBoardController controller = new PlayerBoardController(); 
		controller.addMines(); 
		controller.setCellText();
		
	} 
	
	// Handles userClick
	public void userClick() {
		// Verify click is not on revealed or flagged tile 
		if(!Board.newInstance.gameOver) {
			if(!isRevealed && !flagState) {
					
				// Check if user clicked on mine 
				if (isMine) {
					// Style Mine
					this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
					// Exit the program after displaying GAME OVER or reset the board 
					System.out.println("Game over");
					Board.newInstance.loss();
					return;
				}
				
				// Style Revealed Tile 
				this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
				Board.newInstance.revealNeighbors(this);
				isRevealed = true;
			}
		}
	}
	
	// Flag/Remove Flag on Tile 
	public void toggleFlag() {
		if(!Board.newInstance.gameOver) {
			flagState = !flagState;
			this.setText(flagState ? "F" : "");
			this.setTextFill(flagState ? Color.RED : Color.WHITE);
		}
	}
	
	// Check if Mine
	public boolean isMine() {
		return isMine;
	}

	// Get Tile Revealed Status 
	public boolean getRevealed() {
		return isRevealed;
	}
	
	// Returns number of mines around the cell
	public int getHowManyAround() {
		return howManyAround;
	}

	// Sets the number of mines around the cell
	public void setHowManyAround(int howManyAround) {
		this.howManyAround = howManyAround;
	}

	// Reveals the cell and shows number of mines
	public void revealSelf() {
		//if user flagged cell
		if(!flagState) {
			// Style revealed tiles 
			this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
			this.isRevealed = true;
			
			// Show amount of neighboring mines  
			if (howManyAround > 0 && isRevealed) {
				this.setText("" + howManyAround);
			}
		}
		
	}
}
