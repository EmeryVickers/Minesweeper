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
	
	public Cell() {
		
	}
	
	//sets up tile and gets ID after generation
	public void setTile(String id) {
		this.id = id;
		System.out.println(id);
		this.setMinWidth(60);
		this.setMinHeight(35);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
	
	//gets ID of button
	public String getID() {
		return id;
	}
	
	//Handles userClick
	public void userClick() {
		if(isClicked == false) {
			isClicked = true;
			this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		}
		
	}
	
	
}
