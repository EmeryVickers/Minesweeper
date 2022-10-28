package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PlayerBoardController {
    Boolean[][] bombsBoard = new Boolean[10][10];
    
    Boolean[][] revealedBoard = new Boolean[10][10];
    
    @FXML
    private BorderPane mainLayout;
	
	// ----- Create GridPane -----// 
	GridPane tiles = new GridPane(); 
	
	public void addTiles() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// ----- Buttons/Tiles -----// 
				Button buttonTemp = new Button("  "); 
				tiles.add(buttonTemp, i, j);
				buttonTemp.setId("" + i + ", "+ j + "");
				System.out.println("" + i + j + " ID: " + buttonTemp.getId());
			}
		}
	}

	

	
}
