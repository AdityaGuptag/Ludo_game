
import javafx.scene.Group;

public class FinalDestination {
	public int x0;
	public int y0;
	
    public FinalDestination(int x0, int y0) {
    	this.x0 = x0;
    	this.y0 = y0;
	}

	public Group create(int boardLength) {
        Group finalDest = new Group();
        int finalDestLen = boardLength/5;
        int homeLength = boardLength*2/5;
        int x_mid_point = (x0 + (x0 + boardLength)) / 2;
        int y_mid_point = (y0 + (y0 + boardLength)) / 2;
        TriangleGenerator RedTriangle = new TriangleGenerator(x0+homeLength, y0+homeLength,
        		x0+homeLength, y0+homeLength+finalDestLen, x_mid_point, y_mid_point, new int[]{237, 24, 9});
        TriangleGenerator GreenTriangle = new TriangleGenerator(x0+homeLength+finalDestLen, y0+homeLength,
        		x0+homeLength, y0+homeLength, x_mid_point, y_mid_point, new int[]{12, 240, 23});
        TriangleGenerator BlueTriangle = new TriangleGenerator(x0+homeLength, y0+homeLength+finalDestLen,
        		x0+homeLength+finalDestLen, y0+homeLength+finalDestLen, x_mid_point, y_mid_point, new int[]{12, 35, 240});
        TriangleGenerator YellowTriangle = new TriangleGenerator(x0+homeLength+finalDestLen,
        		y0+homeLength+finalDestLen, x0+homeLength+finalDestLen, y0+homeLength, x_mid_point, y_mid_point, new int[]{247, 212, 12});
        finalDest.getChildren().addAll(RedTriangle.create(), GreenTriangle.create(),
                YellowTriangle.create(), BlueTriangle.create());
//        finalDest.getChildren().addAll(RedTriangle.create());
        return finalDest;
    }
}
