package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
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
			
			//split
			String[] idSplitter = id.split(",",0);
			int y = Integer.parseInt(idSplitter[0]);
			int x = Integer.parseInt(idSplitter[1]);
			
			callNeighbors(x,y);
		}
			
		
		
	}
	
	public void revealSelf() {
		// reveal the number if mine
	}
	
	public int callNeighbors(int i, int j) {
		// call its neighbors which inturn would call their neighbors
		
		
		if(i <= 9 && i >=0 && j <= 9 && j >= 0) {
			howManyAround += callNeighbors(i-1, j-1);
			howManyAround += callNeighbors(i-1, j);
			howManyAround += callNeighbors(i-1, j+1);
			howManyAround += callNeighbors(i, j-1);
			howManyAround += callNeighbors(i, j+1);
			howManyAround += callNeighbors(i-1, j);
			howManyAround += callNeighbors(i+1, j);
			howManyAround += callNeighbors(i+1, j+1);
		}else{
			howManyAround = 0;
		}
		// if neighbor(i-1,j-1) is mine then  howManyAround++ return 
		//else
		
		//
		

		
		return howManyAround;
		

	}
	
	public void locateMines() {
		
		Board.newInstance.getBombsBoard().getRowIndex(this);
		Board.newInstance.getBombsBoard().getColumnIndex(this);
		
		
		for(Node c: Board.newInstance.getBombsBoard().getChildren())
		{
			if (surroundsAndMine((Cell)c)) {
				
			}
		}
		
		this.setText(howManyAround);
	}
	
	public boolean surroundsAndMine(Cell c) {
		
		
		return false;
		
	}
	
	
}
