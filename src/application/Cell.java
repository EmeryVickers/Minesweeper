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
	
	private String id = "";
	private boolean isMine = false;
	private boolean isClicked = false;
	private int howManyAround = 0;
	
	public Cell() {
		
	}
	
	//sets up tile and gets ID after generation
	public void setTile(String id) {
		this.id = id;
		
		this.setMinWidth(60);
		this.setMinHeight(35);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
	//sets value of cell as mine when called
	public void setMine() {
		this.isMine = true;
	}
	
	//gets ID of button
	public String getID() {
		return id;
	}
	
	
	//Handles userClick
	public void userClick() {
		if(!isClicked) {
			isClicked = true;
			this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
			
			if(isMine) {
				this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
			}
			
			locateMines();
		}
			
		
		
	}
	
	public void locateMines() {
		
		String[] idSplit = id.split(",",0);
		
		this.setText("3");
	}
}
