package application;

import javafx.fxml.FXML;
import javafx.geometry.Insets;

import java.util.Random;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
				Cell buttonTemp = new Cell(); 
				tiles.add(buttonTemp, i, j);
				buttonTemp.setId("" + i + j);
				buttonTemp.setTile(buttonTemp.getId());
			}
		}
	}
	
	public void addMines() {
	    for (int i = 0; i < 10; i++) {
	    	int randomRow = (int) ((Math.random() * (10 - 0)) + 0);
	    	int randomColumn = (int) ((Math.random() * (10 - 0)) + 0);
	    	
	    	
	    }
	}
}
