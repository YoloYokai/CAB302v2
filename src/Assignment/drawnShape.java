package Assignment;

import java.awt.*;
import java.util.ArrayList;

public class drawnShape {
    private Shape shape;
    private Color shapeFill;
    private boolean shapeFillbool;
    private Color shapeStroke;
    private DrawingCommand.DrawCommands type;
    private ArrayList<Double> coords;

    public drawnShape(Shape shape, Color fill, Boolean fillstate, Color pen, DrawingCommand.DrawCommands type, ArrayList<Double> cordinates ) {
        this.shape = shape;
        this.shapeFill = fill;
        this.shapeFillbool = fillstate;
        this.shapeStroke = pen;
        this.type = type;
        if (type == DrawingCommand.DrawCommands.PLOT) {
            System.out.println(cordinates);
        }
        this.coords = cordinates;
    }

    public ArrayList<Double> getPos(){
        return coords;
    }

    public Shape getShape() {
        return this.shape;
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
