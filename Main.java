
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Hello World!");
        
//        int[] redPathX = {1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6};
//        int[] redPathY = {6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7};
//        
//        int[] greenPathX = {8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7};
//        int[] greenPathY = {1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,1,2,3,4,5,6};
//        
//        int[] bluePathX = {6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,7,7,7,7,7,7};
//        int[] bluePathY = {13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8};
//        
//        int[] yellowPathX = {13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,8,8,8,8,8,8,9,10,11,12,13,14,14,13,12,11,10,9,8};
//        int[] yellowPathY = {8,8,8,8,8,9,10,11,12,13,14,14,14,13,12,11,10,9,8,8,8,8,8,8,7,6,6,6,6,6,6,5,4,3,2,1,0,0,0,1,2,3,4,5,6,6,6,6,6,6,7,7,7,7,7,7,7};
        
    	int x0 = 100;
    	int y0 = 100;
    	int boardLength = 450;
        int[][] colors = {
	        		{237, 24, 9},				//Red
	        		{12, 240, 23}, 				//Green
	        		{12, 35, 240}, 				//Blue
	        		{247, 212, 12}				//Yellow
        		};        
        
        Board board = new Board(x0, y0, boardLength, colors[0], colors[1], colors[2], colors[3]);
        Group boardGrp = board.createLudoBoard();
        Group grpMain = new Group();
        GameLoop gl = new GameLoop(4, colors);
        Group gameInit = gl.initialiseGame();
        
        grpMain.getChildren().addAll(boardGrp, gameInit);
        
        Scene scene = new Scene(grpMain, boardLength+200, boardLength+200);
        primaryStage.setResizable(false);
//        Group grp = (Group) boardGrp.getChildren().get(0);
//        System.out.println(grp.getChildren());
        primaryStage.setScene(scene);
        primaryStage.show();
//        gl.run();
    	
    }
} 
