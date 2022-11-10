package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PlayerBoardController {

    @FXML
    private TextArea clockField;

    @FXML
    private ImageView mainButton;

    @FXML
    private TextArea minesLeftField;
    
    @FXML
    private BorderPane mainLayout;

    @FXML
    void mainButtonClick(MouseEvent event) {
    }
    // Test if it is the user's first click 
    private Boolean firstClick = true; 
    // ArrayList to hold each mine on the GridPane 
    public ArrayList<String> mines = new ArrayList<String>();

    // Add tiles to Board instance 
	public void addTiles() {
		// Loop through each GridPane coordinate 
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// Temporary Cell/Tile -> to be added to the GridPane(tiles) 
				Cell buttonTemp = new Cell(); 
				// Handle "click" on each cell 
				buttonTemp.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent a) {
						// If it is the first click... 
						if (firstClick == true) {
							firstClick = false;
							Cell newCell = new Cell(); 
							newCell.firstClick(buttonTemp); 
						} else {
							// If it is not the first click... 
							buttonTemp.userClick(); 
						}
					
					}
				});
				
				// Add button to Board instance
				Board.newInstance.addToBombsBoard(buttonTemp, i, j);
				buttonTemp.setId(i + "," + j);
				buttonTemp.setTile(buttonTemp.getId());
			}
		}
	}
	
	// Generate Mines 
	public void setCellText() { 
		// Loop through neighbors and increment count for cell based on proximity to mine 
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) { 
				// Create instance of Board Cell 
				Cell cell = Board.newInstance.getCell(i + "," + j);
				int count = 0;
				// For each cell, find the neighboring cells and test if they are a mine 
				for (Cell neighbor: Board.newInstance.getNeighbors(cell)) {
					if (neighbor.isMine()) {
						count = count + 1;
						cell.howManyAround = count;
						
					}
				}
				
				// Set the text on each cell with distance to neighboring mines 
				if (cell.getHowManyAround() != 0) {
					cell.setText(""+cell.getHowManyAround());
				}
			}
		}
	}
	
	// Add mines to Board 
	public void addMines() {
        for (int i = 0; i < 10; i++) {
        	// Randomly select row and column to set mine locations 
            int randomRow = (int) ((Math.random() * (10 - 0)) + 0);
            int randomColumn = (int) ((Math.random() * (10 - 0)) + 0);
            
            // Mine Location 
            String newMine = (randomRow +","+ randomColumn);
            if (this.isNewMine(mines, newMine)) {
                mines.add(newMine);
                // If mine location == location on Board instance  
                for (Node c : Board.newInstance.getBombsBoard().getChildren()) {
                	Cell cellC = (Cell)c;
                	if(cellC.getId().equals(newMine)) {
                		cellC.setMine();
                	}
                }
            } else {
            	// If mine location is taken, re-do process (to guarantee 10 mines) 
                i--;
            }
        }
    }
	
	
    

	// Check if newMine is in valid location 
    public boolean isNewMine(ArrayList<String> mines, String newMine) {
    	// Loop through ArrayList of mines 
        for (int i = 0; i < mines.size(); i++) {
        	// Check if mine is already set at location 
            if (newMine.equals(mines.get(i))){
                return false;
            }
            
        }
        return true;
    }
}
