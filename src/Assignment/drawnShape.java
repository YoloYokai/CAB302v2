package Assignment;

import java.awt.*;

public class drawnShape {
    private Shape coordinates;
    private Color shapeFill;
    private boolean shapeFillbool;
    private Color shapeStroke;

    public drawnShape(Shape coords, Color fill, Boolean fillstate, Color pen) {
        this.coordinates = coords;
        this.shapeFill = fill;
        this.shapeFillbool = fillstate;
        this.shapeStroke = pen;
    }

    public Shape getshape() {
        return this.coordinates;
    }

    public Color getShapeFill() {
        return this.shapeFill;
    }

    public Color getShapeStroke() {
        return this.shapeStroke;
    }

    public boolean getfillstate() {
        return this.shapeFillbool;
    }
}
