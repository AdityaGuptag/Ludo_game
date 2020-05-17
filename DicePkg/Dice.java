package DicePkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import AnimationPkg.DiceAnimation;
import Players.Player;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Dice {
	private final int diceLen = 60;
	public int x0;
	public int y0;
//	private int numOnDice;
	public int[] color;
	public int boardLength;
	public int diceNum = 0;
	public Group allImages;
	private ImageView one;
	private ImageView two;
	private ImageView three;
	private ImageView four;
	private ImageView five;
	private ImageView six;

	public Dice(int x0, int y0, int[] color, int boardLength) {
		this.x0 = x0;
		this.y0 = y0;
//		this.numOnDice = 0;
		this.color = color;
		this.boardLength = boardLength;
		this.allImages = new Group();
	}

	public Group createDice(String msg, Player player) throws FileNotFoundException {
		Image dice_one = new Image(new FileInputStream("C:\\Users\\aditya\\eclipse-workspace-java\\FirstJavaFXProject\\src\\DicePkg\\one.png"));
		Image dice_two = new Image(new FileInputStream("C:\\Users\\aditya\\eclipse-workspace-java\\FirstJavaFXProject\\src\\DicePkg\\two.png"));
		Image dice_three = new Image(new FileInputStream("C:\\Users\\aditya\\eclipse-workspace-java\\FirstJavaFXProject\\src\\DicePkg\\three.png"));
		Image dice_four = new Image(new FileInputStream("C:\\Users\\aditya\\eclipse-workspace-java\\FirstJavaFXProject\\src\\DicePkg\\four.png"));
		Image dice_five = new Image(new FileInputStream("C:\\Users\\aditya\\eclipse-workspace-java\\FirstJavaFXProject\\src\\DicePkg\\five.png"));
		Image dice_six = new Image(new FileInputStream("C:\\Users\\aditya\\eclipse-workspace-java\\FirstJavaFXProject\\src\\DicePkg\\six.png"));
		one = new ImageView(dice_one);
		two = new ImageView(dice_two);
		three = new ImageView(dice_three);
		four = new ImageView(dice_four);
		five = new ImageView(dice_five);
		six = new ImageView(dice_six);
//		Group allImages = new Group();
		allImages.getChildren().addAll(one);//, two, three, four, five, six);
		allImages.setTranslateX(x0);
		allImages.setTranslateY(y0);
		one.setFitHeight(diceLen);
		one.setFitWidth(diceLen);
		two.setFitHeight(diceLen);
		two.setFitWidth(diceLen);
		three.setFitHeight(diceLen);
		three.setFitWidth(diceLen);
		four.setFitHeight(diceLen);
		four.setFitWidth(diceLen);
		five.setFitHeight(diceLen);
		five.setFitWidth(diceLen);
		six.setFitHeight(diceLen);
		six.setFitWidth(diceLen);

		allImages.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				System.out.println(msg);
				Random rnd = new Random();
				
				diceNum = 1+rnd.nextInt(6);
//				System.out.println("Random generated : " + diceNum);
				DiceAnimation.rollDice(diceNum, allImages, six, one, five, three, two, four);
				
//				Pawn.move(diceNum);
				player.setNumOnDice(diceNum);
			}

		});

//		playerGrp.getChildren().add(allImages);
		return allImages;
	}

	public int rollDice(String msg, Player player) {
		
		return diceNum;	
	}
}
