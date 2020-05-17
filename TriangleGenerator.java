

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class TriangleGenerator {
    public double x0, y0, x1, y1, x2, y2;
    public int[] color;
    public boolean borderReq = true;
    public TriangleGenerator(int x0, int y0, int x1, int y1, int x2, int y2, int[] color) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public TriangleGenerator(int x0, int y0, int x1, int y1, int x2, int y2, int[] color, boolean borderReq) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.borderReq = borderReq;
    }

    public Polygon create() {
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{
                x0, y0,
                x1, y1,
                x2, y2
        });
        triangle.setFill(Color.rgb(color[0], color[1], color[2]));
        if (borderReq) {
            triangle.setStroke(Color.BLACK);
        }
        return triangle;
    }
}
