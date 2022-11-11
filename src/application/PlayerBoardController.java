package application;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import java.util.ArrayList;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class PlayerBoardController {

	// ----- FXML Objects ----- // 
    @FXML
    public TextArea lossField;

    @FXML
    private Button mainButton;

    @FXML
    private ImageView mainButtonImg;

    @FXML
    public TextArea winField;
    
    @FXML
    private BorderPane mainLayout;
    
    
    // ----- Controller Methods ----- // 
    // Test if it is the user's first click 
    private Boolean firstClick = true; 
    
    // ArrayList to hold each mine on the GridPane 
    public ArrayList<String> mines = new ArrayList<String>();

    // Add tiles to Board instance 
	public void addTiles() {
		// Loop through each GridPane coordinate 
		// TODO: Find out whether i/j is row/col
		// Loop through rows 
		for (int i = 0; i < 10; i++) {
			// Loop through columns 
			for (int j = 0; j < 10; j++) {
				
				// Temporary Cell/Tile -> to be added to the GridPane(tiles) 
				Cell buttonTemp = new Cell(); 
				
				// Handle "click" on each cell 
				buttonTemp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent a) {
						// If it is the first click... 
						if (firstClick == true) {
							firstClick = false;
							Cell newCell = new Cell(); 
							newCell.firstClick(buttonTemp); 
						} else {
							// Check for FLAG (right-click)  
							if (a.getButton() == MouseButton.SECONDARY) {
								if (!buttonTemp.getRevealed()) {
						           buttonTemp.toggleFlag();
								}
							} else {
						        // If it is not the first click... 
						        buttonTemp.userClick(); 
						        // Check for win (all bombs are discovered) 
						        if (Board.newInstance.checkForWin()) {
						        	System.out.println("You Win!");
								}
							}
						}
					}
				});
				
				// Add button to Board instance with row/col as ID 
				// TODO: Find out whether i/j is row/col
				Board.newInstance.addToBombsBoard(buttonTemp, i, j);
				buttonTemp.setId(i + "," + j);
				buttonTemp.setTile(buttonTemp.getId());
			}
		}
	}
	
	// Show amount of neighboring mines 
	public void setCellText() { 
		// Loop through neighbors and increment count for cell based on proximity to mine 
		// TODO: Find out whether i/j is row/col
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) { 
				
				// Create instance of Board Cell 
				Cell cell = Board.newInstance.getCell(i + "," + j);

				int count = 0;	// Count amount of neighboring mines 
				// For each cell, find the neighboring cells and test if they are a mine 
				for (Cell neighbor: Board.newInstance.getNeighbors(cell)) {
					if (neighbor.isMine()) {
						count = count + 1;
						cell.howManyAround = count;
					}
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
                	if (((Cell)c).getId().equals(newMine)) {
                		((Cell)c).setMine();
                	}
                }
            // If mine location is taken, re-do process (to guarantee 10 mines) 
            } else {
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