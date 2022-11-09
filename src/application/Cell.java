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
	private boolean isChecked = false;
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
			
			
			if(isMine) {
				this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
				System.out.print("Game over");
				return;
			}			
			//split
			String[] idSplitter = id.split(",",0);
			int y = Integer.parseInt(idSplitter[0]);
			int x = Integer.parseInt(idSplitter[1]);
			

			int mines = callNeighbors(x,y);
			revealSelf(mines);
			isClicked = true;
	
		}
			
		
		
	}
	
	public void revealSelf(int mine) {
		// reveal the number if mine
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
//		if(howManyAround==0) {
//			
//		} else {
			this.setText(String.valueOf(mine));
//			}
	}
	
	public int callNeighbors(Cell cell) {

		
		
		return 0;
	}
	
	
	//TODO here is the variable to keep track of the current cell. dont forget to delete if it doesnt work
	//Additionally, change all instances of "currCell" to "this"
	public int callNeighbors(int i, int j) {
		// call its neighbors which inturn would call their neighbors
		System.out.println(i+" "+j);
		String idString=i+","+j;
		
		Cell cell = Board.newInstance.getCell(idString);
		
		//TODO we need to get the actual cell. We are currently getting coordinates,
		//but these are just integers. We need to access the actual cell that the coordinates are
		//Here is my attempt (not correct):
		
		if(i > 9 || i <0) {
			return 0;
		}
		if(j > 9 || j < 0) {
			return 0;
		}
		
		if(cell.isChecked) {
			System.out.println("already checked");
			return howManyAround;
		}
		
		cell.isChecked = true;
		
		if(cell.isMine) {
			System.out.println("mine");
			return 1;
		}
		
		cell.howManyAround += cell.callNeighbors(i-1, j-1);
		cell.howManyAround += cell.callNeighbors(i-1, j);
		cell.howManyAround += cell.callNeighbors(i-1, j+1);
		cell.howManyAround += cell.callNeighbors(i, j-1);
		cell.howManyAround += cell.callNeighbors(i, j+1);
		cell.howManyAround += cell.callNeighbors(i+1, j);
		cell.howManyAround += cell.callNeighbors(i+1, j-1);
		cell.howManyAround += cell.callNeighbors(i+1, j+1);
		
		return cell.howManyAround;
		

	}
	
	/**
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
	**/
	
}


