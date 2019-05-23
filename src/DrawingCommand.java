import java.util.ArrayList;

public interface DrawingCommand {
    DrawCommands type();

    ArrayList<Double> coordinates();

    String property();

    enum DrawCommands {
        LINE("LINE"),
        RECTANGLE("RECTANGLE"),
        ELLIPSE("ELLIPSE"),
        PEN("PEN"),
        FILL("FILL"),
        PLOT("PLOT");

        private String string;

        DrawCommands(String string) {
            this.string = string;
        }

        public String cmd() {
            return string;
        }
    }
}
class LineCommand implements DrawingCommand {
    private ArrayList<Double> values;

    public LineCommand(ArrayList<Double> coordinates){
        this.values = coordinates;
    }

    public DrawCommands type() {
        return (DrawCommands.LINE);
    }

    public ArrayList<Double> coordinates() {
        return values;
    }
    public String property() {
        return null;
    }
}
class RectangleCommand implements DrawingCommand {
    private ArrayList<Double> values;

    public RectangleCommand(ArrayList<Double> coordinates) {
        this.values = coordinates;
    }

    public DrawCommands type() {
        return (DrawCommands.RECTANGLE);
    }

    public ArrayList<Double> coordinates() {
        return values;
    }
    public String property() {
        return null;
    }
}
class EllipseCommand implements DrawingCommand {
    private ArrayList<Double> values;

    public EllipseCommand(ArrayList<Double> coordinates) {
        this.values = coordinates;
    }

    public DrawCommands type() {
        return (DrawCommands.ELLIPSE);
    }

    public ArrayList<Double> coordinates() {
        return values;
    }
    public String property() {
        return null;
    }
}
class PlotCommand implements DrawingCommand {
    private ArrayList<Double> values;

    public PlotCommand(ArrayList<Double> coordinates) {
        this.values = coordinates;
    }

    public DrawCommands type() {
        return (DrawCommands.PLOT);
    }

    public ArrayList<Double> coordinates() {
        return values;
    }
    public String property() {
        return null;
    }
}

class PenCommand implements DrawingCommand {
    private String property;

    public PenCommand(String propertyin) {
        this.property = propertyin;
    }

    public DrawCommands type() {
        return (DrawCommands.PEN);
    }

    public ArrayList<Double> coordinates() {
        return null;
    }
    public String property() {
        return property;
    }
}
class FillCommand implements DrawingCommand {
    private String property;

    public FillCommand(String propertyin) {
        this.property = propertyin;
    }

    public DrawCommands type() {
        return (DrawCommands.PEN);
    }

    public ArrayList<Double> coordinates() {
        return null;
    }
    public String property() {
        return property;
    }
}
