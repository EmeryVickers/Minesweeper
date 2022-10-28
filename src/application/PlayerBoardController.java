package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

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
				buttonTemp.setMinWidth(60);
				buttonTemp.setMinHeight(35);
				tiles.add(buttonTemp, i, j);
				buttonTemp.setId("" + i + ", "+ j + "");
				System.out.println("" + i + j + " ID: " + buttonTemp.getId());
			}
		}
	}
}
