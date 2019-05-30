package Assignment;

import java.awt.*;

public class drawnShape {
    private Shape coordinates;
    private Color shapeFill;
    private boolean shapeFillbool;
    private Color shapeStroke;
    private DrawingCommand.DrawCommands type;

    public drawnShape(Shape coords, Color fill, Boolean fillstate, Color pen, DrawingCommand.DrawCommands type) {
        this.coordinates = coords;
        this.shapeFill = fill;
        this.shapeFillbool = fillstate;
        this.shapeStroke = pen;
        this.type = type;
    }

    public Shape getShape() {
        return this.coordinates;
    }

    public DrawingCommand.DrawCommands getType() {
        return this.type;
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
