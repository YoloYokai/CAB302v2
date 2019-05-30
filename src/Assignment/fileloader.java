package Assignment;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class fileloader {
    public static ArrayList<DrawingCommand> updatecommands(Graphics2D canvas, ArrayList<drawnShape> shapes) {
        ArrayList<DrawingCommand> output = new ArrayList<>();
        boolean fillstate = shapes.get(0).getfillstate();
        if (fillstate) {
            output.add(new PropertyCommand("#" + Integer.toHexString(shapes.get(0).getShapeFill().getRGB()).substring(2), DrawingCommand.DrawCommands.FILL));
        }
        Color pen = shapes.get(0).getShapeStroke();
        output.add(new PropertyCommand("#" + Integer.toHexString(shapes.get(0).getShapeFill().getRGB()).substring(2), DrawingCommand.DrawCommands.PEN));
        Color fill = shapes.get(0).getShapeFill();

        for (drawnShape a : shapes) {
            if (fillstate && !a.getfillstate()) {
                output.add(new PropertyCommand("OFF", DrawingCommand.DrawCommands.FILL));
                fillstate = false;
            }
            if (fill != a.getShapeFill()) {
                output.add(new PropertyCommand("#" + Integer.toHexString(a.getShapeFill().getRGB()).substring(2), DrawingCommand.DrawCommands.FILL));
                fillstate = true;
                fill = a.getShapeFill();
            }
            if (pen != a.getShapeStroke()) {
                output.add(new PropertyCommand("#" + Integer.toHexString(a.getShapeStroke().getRGB()).substring(2), DrawingCommand.DrawCommands.PEN));
                pen = a.getShapeStroke();
            }

            ArrayList<Double> tmpcoords = new ArrayList<>();
            PathIterator test = a.getShape().getPathIterator(null);

            if (a.getType() == DrawingCommand.DrawCommands.PLOT) {
                // output.add(new CreationCommand());
            } else if (a.getType() == DrawingCommand.DrawCommands.LINE) {

            } else if (a.getType() == DrawingCommand.DrawCommands.ELLIPSE) {

            } else if (a.getType() == DrawingCommand.DrawCommands.RECTANGLE) {

            } else if (a.getType() == DrawingCommand.DrawCommands.POLYGON) {


            }
        }
        return output;
    }
    public static ArrayList<drawnShape> updateCanvas(Graphics2D canvas, ArrayList<DrawingCommand> commands) {
        boolean fill = false;
        Color pencolor = new Color(1);
        Color fillcolor = new Color(1);
        ArrayList<drawnShape> output = new ArrayList<>();
        double width = canvas.getClip().getBounds().getWidth();
        double height = canvas.getClip().getBounds().getHeight();

        for (DrawingCommand a : commands) {
            if (a.type() != DrawingCommand.DrawCommands.FILL && a.type() != DrawingCommand.DrawCommands.PEN) {
                canvas.setPaint(pencolor);
                canvas.draw(CmdtoShape(a, width, height));
                if (fill) {
                    canvas.setPaint(fillcolor);
                    canvas.fill(CmdtoShape(a, width, height));
                }
                output.add(new drawnShape(CmdtoShape(a, width, height), fillcolor, fill, pencolor, a.type()));
            }

            if (a.type() == DrawingCommand.DrawCommands.FILL) {
                if (a.property().contains("OFF")) {
                    fill = false;
                } else {
                    fillcolor = Color.decode(a.property());
                    fill = true;
                }
            }
            if (a.type() == DrawingCommand.DrawCommands.PEN) {
                pencolor = Color.decode(a.property());
            }

        }
        return output;
    }

    private static Shape CmdtoShape(DrawingCommand input, double width, double height) {
        Shape output;
        ArrayList<Double> positions = input.coordinates();
        if (input.type() == DrawingCommand.DrawCommands.PLOT) {
            output = new Line2D.Double(positions.get(0) * width, positions.get(1) * height, positions.get(0) * width, positions.get(1) * height);
        } else if (input.type() == DrawingCommand.DrawCommands.LINE) {
            output = new Line2D.Double(positions.get(0) * width, positions.get(1) * height, positions.get(2) * width, positions.get(3) * height);
        } else if (input.type() == DrawingCommand.DrawCommands.ELLIPSE) {

            output = new Ellipse2D.Double(positions.get(0) * width, positions.get(1) * height, Math.abs((positions.get(0) - positions.get(2)) * width), Math.abs((positions.get(3) - positions.get(1)) * height));
        } else if (input.type() == DrawingCommand.DrawCommands.RECTANGLE) {
            output = new Rectangle2D.Double(positions.get(0) * width, positions.get(1) * height, Math.abs((positions.get(0) - positions.get(2)) * width), Math.abs((positions.get(3) - positions.get(1)) * height));
        } else if (input.type() == DrawingCommand.DrawCommands.POLYGON) {
            ArrayList<Double> x = new ArrayList<>();
            ArrayList<Double> y = new ArrayList<>();
            for (int i = 0; i < input.coordinates().size(); i += 2) {
                x.add(input.coordinates().get(i) * width);
                y.add(input.coordinates().get(i + 1) * height);
            }
            int[] xout = new int[x.size()];
            for (int i = 0; i < xout.length; i++) {
                xout[i] = x.get(i).intValue();
            }
            int[] yout = new int[y.size()];
            for (int i = 0; i < yout.length; i++) {
                yout[i] = y.get(i).intValue();
            }
            output = new Polygon(xout, yout, x.size());
        } else {
            output = null;
        }

        return output;
    }
}
