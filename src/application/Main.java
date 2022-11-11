package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

//main
public class Main extends Application {
	@Override 
	public void start(Stage primaryStage) {
		try {
			// Set a title for the Window
			primaryStage.setTitle("Minesweeper");
			
			// Create FXML loader and read in the FXML code
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/PlayerBoard.fxml"));
			BorderPane mainLayout = (BorderPane)loader.load();
			
			// ----- Add GridPane to BorderPane -----//
			PlayerBoardController playerBoard = new PlayerBoardController(); 
			playerBoard.addTiles();
			GridPane tiles = Board.newInstance.getBombsBoard(); 
			mainLayout.setCenter(tiles);

			
			// Create the scene with the layout in the FXML code, set the scene and show it
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void launchGame() {
		//start()
	}
	

}