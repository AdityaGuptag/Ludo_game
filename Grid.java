
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid {
	public int x0;
	public int y0;
    public int[] redColor;
    public int[] greenColor;
    public int[] blueColor;
    public int[] yellowColor;

    public Grid(int x0, int y0, int[] redColor, int[] greenColor, int[] blueColor, int[] yellowColor) {
    	this.x0 = x0;
    	this.y0 = y0;
        this.redColor = redColor;
        this.greenColor = greenColor;
        this.blueColor = blueColor;
        this.yellowColor = yellowColor;
    }

    Group gridGroup = new Group();
    public Group createGrid(int boardLength) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
            	int rectWidth = boardLength/15;
                Rectangle rect = new Rectangle(x0 + j * rectWidth, y0 + i * rectWidth, rectWidth, rectWidth);
//                Rectangle rect = new Rectangle(30, 30);		//width = 30, height = 30
                rect.setStroke(Color.BLACK);
                rect.setId(Integer.toString(i) + '_' + Integer.toString(j));
//                System.out.println(rect.getId());
                if ((j >= 1 && j <= 5 && i == 7) || (i == 6 && j == 1)) {
                    rect.setFill(Color.rgb(redColor[0], redColor[1], redColor[2]));
                }
                else if ((j == 7 && i >= 9 && i <= 13) || (i == 13 && j == 6)) {
                    rect.setFill((Color.rgb(blueColor[0], blueColor[1], blueColor[2])));
                }
                else if ((j == 7 && i >= 1 && i <= 5) || (i == 1 && j == 8)) {
                    rect.setFill((Color.rgb(greenColor[0], greenColor[1], greenColor[2])));
                }
                else if ((j >= 9 && j <= 13 && i == 7) || (i == 8 && j == 13)) {
                    rect.setFill(Color.rgb(yellowColor[0], yellowColor[1], yellowColor[2]));
                }
                else {
                    rect.setFill(Color.WHITE);
                }
                gridGroup.getChildren().add(rect);
            }
        }

        return gridGroup;
    }



}
