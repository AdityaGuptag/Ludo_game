package Players;

import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Pawn {
	int xCenter;
	int yCenter;
	int[] color;
	Circle pawn;
	int diceNum = 0;
	int totalDist;
	String region;			//'r' or 'y' -> x-coordinate changes; 'g' or 'b' -> y-coordinate changes
	int state;				// -1 -> home; 0 -> playing field; 1 -> final destination
	short[][] pawnPath;
	int currentPos;			//Represents the current position of Pawn in terms of index number in oath array
	
	public Pawn(int xCenter, int yCenter, short[][] path, int[] color) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.color = color;
		this.totalDist = 56;
		this.pawnPath = path;
		this.state = -1;
		this.currentPos = 0;
	}
	
	public Circle createPawn() {
		this.pawn = new Circle(xCenter, yCenter, 15);
		pawn.setStroke(Color.BLACK);
		pawn.setFill(Color.rgb(color[0], color[1], color[2]));
		
		pawn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				diceNum = getDiceNum();
				move(diceNum);
			}
		});
		
		return pawn;
	}
	
	public void move(int numOnDice) {
		
		Path path = new Path();
		PathTransition pTrans = new PathTransition();
		if (this.state == 1) {
			numOnDice = 0;
		} else if (this.state == -1 && !(numOnDice == 6 || numOnDice == 1)) {
			numOnDice = 0;
		} else if (this.state == -1 && numOnDice == 1) {
			this.state = 0;
			numOnDice = 0;
			LineTo line = new LineTo(115 + pawnPath[0][currentPos]*30, 115 + pawnPath[1][currentPos]*30);		// x0 + j * rectWidth, y0 + i * rectWidth
			MoveTo initialPos = new MoveTo(xCenter, yCenter);
			path.getElements().addAll(initialPos, line);
			pTrans.setPath(path);
			pTrans.setNode(pawn);
			pTrans.play();
		} else if (this.state == -1 && numOnDice == 6) {
			this.state = 0;
			numOnDice = 0;
			LineTo line = new LineTo(115 + pawnPath[0][currentPos]*30, 115 + pawnPath[1][currentPos]*30);		// x0 + j * rectWidth, y0 + i * rectWidth
			MoveTo initialPos = new MoveTo(xCenter, yCenter);
			path.getElements().addAll(initialPos, line);
			path.getElements().add(line);
			pTrans.setPath(path);
			pTrans.setNode(pawn);
			pTrans.play();
		} else if (this.state == 0) {
			int temp = this.totalDist - numOnDice;
			if (temp < 0) {
				numOnDice = 0;
			} else if (temp == 0) {
				this.totalDist = temp;
				state = 1;
				MoveTo initialPos = new MoveTo(115 + pawnPath[0][currentPos]*30, 115 + pawnPath[1][currentPos]*30);
				path.getElements().add(initialPos);
				for (int i = 1; i <= numOnDice; i++) {
					path.getElements().add(new LineTo(115 + pawnPath[0][currentPos+i]*30, 115 + pawnPath[1][currentPos+i]*30));
				}
				currentPos += numOnDice;
				pTrans.setPath(path);
				pTrans.setNode(pawn);
				pTrans.play();
			} else {
				this.totalDist = temp;
				MoveTo initialPos = new MoveTo(115 + pawnPath[0][currentPos]*30, 115 + pawnPath[1][currentPos]*30);
				path.getElements().add(initialPos);
				for (int i = 1; i <= numOnDice; i++) {
					path.getElements().add(new LineTo(115 + pawnPath[0][currentPos+i]*30, 115 + pawnPath[1][currentPos+i]*30));
				}
				currentPos += numOnDice;
				pTrans.setPath(path);
				pTrans.setNode(pawn);
				pTrans.play();
			}
		}		
	}
	
	public void setDiceNum(int diceNum) {
		this.diceNum = diceNum;
	}
	
	public int getDiceNum() {
		return this.diceNum;
	}

}
