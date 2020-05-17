import java.io.FileNotFoundException;
import java.util.ArrayList;

import DicePkg.Dice;
import Players.Player;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class GameLoop {
	Player[] players;
	Dice[] dice;
	int numOfPlayers;
	int boardLength = 450;
	int[][] color;
	Group[] diceImgGrp;
	ArrayList<Circle> pawnsList;
	
	public GameLoop(int numOfPlayers, int[][] color) {
		this.numOfPlayers = numOfPlayers;
		this.players = new Player[this.numOfPlayers];
		this.dice = new Dice[this.numOfPlayers];
		this.color = color;
		this.diceImgGrp = new Group[this.numOfPlayers];
		this.pawnsList = new ArrayList<Circle>();
	}
	
	public Group initialiseGame() throws FileNotFoundException {
		Group gameGrp = new Group();
//		Group[] dice = new Group[numOfPlayers];
		int x0 = 100;
		int y0 = 100;
		short[][] redPlayerPath = { 
				{1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6},
				{6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7} 
		};
		short[][] greenPlayerPath = {
				{8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7},
				{1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6}
		};
		short[][] bluePlayerPath = {
				{6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7},
				{13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8}
		};
		short[][] yellowPlayerPath = {
				{13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8},
				{8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7}
		};
		short[][][] path = {redPlayerPath, greenPlayerPath, bluePlayerPath, yellowPlayerPath};
		
		int[] diceX0 = {30, 560, 30, 560};
		int[] diceY0 = {30, 30, 560, 560};
		int[][] homePlace = {
					{x0, y0},											//Red
					{x0+(boardLength*3/5), y0}, 						//Green
					{x0, y0+(boardLength*3/5)}, 						//Blue
					{x0+(boardLength*3/5), y0+(boardLength*3/5)}		//Yellow
				};
		
		Group temp = new Group();
		for (int i = 0; i < this.numOfPlayers; i++) {
			dice[i] = new Dice(diceX0[i], diceY0[i], color[i], boardLength);
			players[i] = new Player(color[i], homePlace[i][0], homePlace[i][1], path[i], boardLength);
			diceImgGrp[i] = dice[i].createDice("Player " + i, players[i]);
			temp = players[i].generatePlayer();
			gameGrp.getChildren().addAll(diceImgGrp[i], temp);
			for (int j = 0; j < 4; j++) {
				pawnsList.add((Circle) temp.getChildren().get(j));
			}
		}
		
//		System.out.println(pawnsList);
		
		return gameGrp;

	}
	
	public void run() {
		
//		int reached = 0;
//		int currPlayer = 0;
////		dice[currPlayer].rollDice("Player", players[currPlayer]);
//		while (reached != (numOfPlayers - 1)*4) {
//			currPlayer = currPlayer + 1;
//			currPlayer = currPlayer % 4;
////			dice[currPlayer].diceNum = -1;
//			for (int i = 0 ; i < this.numOfPlayers; i++ ) {
//				if (currPlayer == players[i].playerNo) {
//					System.out.println(dice[currPlayer].rollDice("Player", players[currPlayer]));
//					break;
//				}
//			}
//			
//		}
		
	}

}
