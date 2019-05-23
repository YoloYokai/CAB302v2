import java.util.ArrayList;

public interface DrawingCommand {
    DrawCommands type();

    ArrayList<Double> coordinates();

    String property();

    enum DrawCommands {
        LINE("LINE"), RECTANGLE("RECTANGLE"), PEN("PEN"), FILL("FILL"), PLOT("PLOT");

        private String string;

        DrawCommands(String string) {
            this.string = string;
        }

        public String price() {
            return string;
        }
    }
}

class LineCommand implements DrawingCommand {
    private ArrayList<Double> values;

    public void Linecommand(ArrayList<Double> coodinates) {
        this.values = coodinates;
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

    public void Linecommand(ArrayList<Double> coodinates) {
        this.values = coodinates;
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
