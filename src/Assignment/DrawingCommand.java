package Assignment;

import java.util.ArrayList;

public interface DrawingCommand {
    DrawCommands type();

    ArrayList<Double> coordinates();

    String property();

    String tostring();

    enum DrawCommands {
        LINE("LINE"),
        RECTANGLE("RECTANGLE"),
        ELLIPSE("ELLIPSE"),
        POLYGON("POLYGON"),
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

class CreationCommand implements DrawingCommand {
    private ArrayList<Double> values;
    private DrawCommands cmdtype;
    private String cmdstring;

    public CreationCommand(ArrayList<Double> coordinates, DrawCommands type, String cmdstring) {
        this.values = coordinates;
        this.cmdtype = type;
        this.cmdstring = type.toString() + " " + coordinates.toString().replace('[', ' ').replace(',', ' ').replace(']', ' ');

    }

    public DrawCommands type() {
        return (cmdtype);
    }

    public ArrayList<Double> coordinates() {
        return values;
    }

    public String property() {
        return null;
    }

    public String tostring() {
        return cmdstring;

    }
}

class PropertyCommand implements DrawingCommand {
    private String property;
    private DrawCommands cmdtype;
    private String cmdstring;

    public PropertyCommand(String propertyin, DrawCommands type, String cmdstring) {
        this.property = propertyin;
        this.cmdtype = type;
        this.cmdstring = type.toString() + " " + propertyin;
    }

    public DrawCommands type() {
        return (cmdtype);
    }

    public ArrayList<Double> coordinates() {
        return null;
    }

    public String property() {
        return property;
    }

    public String tostring() {
        return cmdstring;
    }
}
