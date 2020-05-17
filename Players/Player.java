package Players;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class Player {
	int[] color;
	int x0;
	int y0;
	Pawn[] pawns;
	public int boardLength;
	int numOnDice = 0;
	short[][] playerPath;
	public int playerNo = 0;
	
	public Player(int[] color, int x0, int y0, short[][] playerPath, int boardLength) {
		this.color = color;
		this.x0 = x0;
		this.y0 = y0;
		this.pawns = new Pawn[4];
		this.playerPath = playerPath;
		this.boardLength = boardLength;
		playerNo++;
	}
	
	public Group generatePlayer() {
		
		Group pawnsGrp = new Group();
		int homeLength = boardLength*2/5;
        pawns[0] = new Pawn(x0+homeLength/2, y0+(homeLength/2)-35, playerPath, color);
        pawns[1] = new Pawn(x0+homeLength/2+35, y0+homeLength/2, playerPath, color);
        pawns[2] = new Pawn(x0+homeLength/2, y0+(homeLength/2)+35, playerPath, color);
        pawns[3] = new Pawn(x0+homeLength/2-35, y0+homeLength/2, playerPath, color);
        
        Circle pawnCircle = new Circle();
        ArrayList<Circle> shapeCircle = new ArrayList<Circle>();
        
        for (int i = 0; i < 4; i++) {
        	pawnCircle = pawns[i].createPawn();
        	pawnsGrp.getChildren().add(pawnCircle);
        	pawnCircle.setId(Integer.toString(playerNo));
        	shapeCircle.add(pawnCircle);
        }
        
        return pawnsGrp;
	}
	
	public void setNumOnDice(int diceNum) {
		this.numOnDice = diceNum;
		for (int i = 0; i < 4; i++) {
			pawns[i].setDiceNum(diceNum);
		}
	}
	
	public Pawn[] getPawns() {
		return this.pawns;
	}
}
