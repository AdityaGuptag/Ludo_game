
import javafx.scene.Group;

public class Board {
    public int[] color1;
    public int[] color2;
    public int[] color3;
    public int[] color4;
    public int x0;
    public int y0;
    public int boardLength;
    public Group baseGrid;

    public Board(int x0, int y0, int boardLength, int[] color1, int[] color2, int[] color3, int[] color4) {
        this.x0 = x0;
        this.y0 = y0;
        this.boardLength = boardLength;
    	this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }

    public Group createLudoBoard() {
        Grid grid = new Grid(x0, y0, color1, color2, color3, color4);	//return a grid pane
        Home redHouse = new Home(x0, y0, boardLength, color1);
        Home greenHouse = new Home(x0+(boardLength*3/5), y0, boardLength, color2);
        Home blueHouse = new Home(x0, y0+(boardLength*3/5), boardLength, color3);
        Home yellowHouse = new Home(x0+(boardLength*3/5), y0+(boardLength*3/5), boardLength, color4);
        FinalDestination finalDest = new FinalDestination(x0, y0);
        
        this.baseGrid = grid.createGrid(boardLength);
        Group homeRed = redHouse.createHome();
        Group homeGreen = greenHouse.createHome();
        Group homeBlue = blueHouse.createHome();
        Group homeYellow = yellowHouse.createHome();
        Group finalDestBlock = finalDest.create(boardLength);
//        this.baseGrid.setId("base_grid");
//        homeRed.setId("red_home");
//        homeGreen.setId("green_home");
//        homeBlue.setId("blue_home");
//        homeYellow.setId("yellow_home");
//        finalDestBlock.setId("final_home");
        Group root = new Group();
        root.getChildren().addAll(this.baseGrid, homeRed, homeGreen, homeBlue, homeYellow, finalDestBlock);
//        root.getChildren().addAll(baseGrid.createGrid());
        return root;
    }
    
    public Group getGrid() {
    	return this.baseGrid;
    }
}
