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
    void mainButtonClick(MouseEvent event) {
    }
    
    @FXML
    private BorderPane mainLayout;

    // Add tiles to Board instance  
	public void addTiles() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// ----- Buttons/Tiles ----- // 
				Cell buttonTemp = new Cell(); 
				buttonTemp.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent a) {
						buttonTemp.userClick();
					}
				});
				
				// Add bomb to Board instance 
				Board.newInstance.addToBombsBoard(buttonTemp,i,j);
				buttonTemp.setId(i +","+ j);
				buttonTemp.setTile(buttonTemp.getId());
			}
		}
	}
	
	// Generate Mines 
	public void addMines() {
        ArrayList<String> mines = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
        	// Randomly selectr row and column to set mine locations 
            int randomRow = (int) ((Math.random() * (10 - 0)) + 0);
            int randomColumn = (int) ((Math.random() * (10 - 0)) + 0);
            
            // Mine Location 
            String newMine = (randomRow +","+ randomColumn);
            if (this.isNewMine(mines, newMine)) {
                mines.add(newMine);
                // If mine location == location on Board instance  
                for(Node c : Board.newInstance.getBombsBoard().getChildren()) {
                	Cell cellC = (Cell)c;
                	if(cellC.getId().equals(newMine)) {
                		cellC.setMine();
                	}
                }
            } else {
            	// If mine location is taken, redo process (to guarantee 10 mines) 
                i--;
            }
        }
    }
    

	// Check if newMine is in valid location //
    public boolean isNewMine(ArrayList<String> mines, String newMine) {
        for (int i = 0; i < mines.size(); i++) {
            if (newMine.equals(mines.get(i))){
                return false;
            }
        }
        return true;
    }
}
