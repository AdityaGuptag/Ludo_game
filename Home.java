
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Home {
    public int boardLength;
    public int x0;
    public int y0;
    public int[] color;
    public Home(int X, int Y, int boardLength, int[] color) {
    	this.boardLength = boardLength;
        this.x0 = X;
        this.y0 = Y;
        this.color = color;
    }

    public Group createHome() {
    	int homeLength = boardLength*2/5;
        Rectangle rect = new Rectangle(this.x0, this.y0, homeLength, homeLength);
        Rectangle innerRect = new Rectangle(x0+homeLength/6, y0+homeLength/6, homeLength*2/3, homeLength*2/3);
        rect.setSmooth(true);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.rgb(this.color[0], this.color[1], this.color[2]));
        innerRect.setFill(Color.WHITE);
        innerRect.setArcWidth(20);
        innerRect.setArcHeight(20);
        Rotate rotateInner = new Rotate(45, x0+homeLength/2, y0+homeLength/2);
        innerRect.getTransforms().add(rotateInner);

        Circle circle1 = new Circle(x0+homeLength/2, y0+(homeLength/2)-35, boardLength/30);
        Circle circle2 = new Circle(x0+homeLength/2+35, y0+homeLength/2, boardLength/30);
        Circle circle3 = new Circle(x0+homeLength/2, y0+(homeLength/2)+35, boardLength/30);
        Circle circle4 = new Circle(x0+homeLength/2-35, y0+homeLength/2, boardLength/30);
        circle1.setFill(Color.rgb(color[0], color[1], color[2]));
        circle2.setFill(Color.rgb(color[0], color[1], color[2]));
        circle3.setFill(Color.rgb(color[0], color[1], color[2]));
        circle4.setFill(Color.rgb(color[0], color[1], color[2]));
        Group homeGrp = new Group();
        homeGrp.getChildren().addAll(rect, innerRect, circle1, circle2, circle3, circle4);
        return homeGrp;
    }

}
