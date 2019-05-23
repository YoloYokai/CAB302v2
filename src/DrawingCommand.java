import java.util.ArrayList;

public interface DrawingCommand {
    DrawCommands type();

    ArrayList<Double> coordinates();

    String property();

    enum DrawCommands {
        LINE("LINE"), PEN("PEN"), FILL("FILL"), PLOT("PLOT");

        private String string;

        DrawCommands(String string) {
            this.string = string;
        }

        public String price() {
            return string;
        }
    }
}
