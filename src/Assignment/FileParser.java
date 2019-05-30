package Assignment;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileParser {
    private ArrayList<DrawingCommand> dFile = new ArrayList<>();

    public ArrayList<DrawingCommand> getdFile() {
        return dFile;
    }

    public void setdFile(ArrayList<DrawingCommand> a) {
        this.dFile = a;
    }

    public ArrayList<DrawingCommand> loadfile() {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));// + "\\Vec");
        FileFilter filter = new FileNameExtensionFilter("vec files", "vec");
        chooser.setFileFilter(filter);
        List<String> commands = new ArrayList<>();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                String command = reader.readLine();
                while (command != null && command != "null") {
                    commands.add(command);
                    command = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {}
            dFile.clear();
            for (int i = 0; i < commands.size(); i++) {

                String[] coordstring = commands.get(i).split(" ");
                ArrayList<Double> coordsdouble = new ArrayList<>();
                String properties = null;
                if(!commands.get(i).contains("PEN")&&!commands.get(i).contains("FILL")){
                    for (int j = 1; j < coordstring.length; j++){coordsdouble.add(Double.parseDouble(coordstring[j]));}
                } else{
                    for (int j = 1; j < coordstring.length; j++){
                        properties=(coordstring[j]);
                    }
                }
                if (commands.get(i).contains(DrawingCommand.DrawCommands.LINE.cmd())) {
                    dFile.add(new CreationCommand(coordsdouble, DrawingCommand.DrawCommands.LINE, commands.get(i)));
                } else if (commands.get(i).contains(DrawingCommand.DrawCommands.RECTANGLE.cmd())) {
                    dFile.add(new CreationCommand(coordsdouble, DrawingCommand.DrawCommands.RECTANGLE, commands.get(i)));
                } else if (commands.get(i).contains(DrawingCommand.DrawCommands.ELLIPSE.cmd())) {
                    dFile.add(new CreationCommand(coordsdouble, DrawingCommand.DrawCommands.ELLIPSE, commands.get(i)));
                } else if (commands.get(i).contains(DrawingCommand.DrawCommands.PLOT.cmd())) {
                    dFile.add(new CreationCommand(coordsdouble, DrawingCommand.DrawCommands.PLOT, commands.get(i)));
                } else if (commands.get(i).contains(DrawingCommand.DrawCommands.PEN.cmd())) {
                    dFile.add(new PropertyCommand(properties, DrawingCommand.DrawCommands.PEN, commands.get(i)));
                } else if (commands.get(i).contains(DrawingCommand.DrawCommands.FILL.cmd())) {
                    dFile.add(new PropertyCommand(properties, DrawingCommand.DrawCommands.FILL, commands.get(i)));
                }

            }

            return (dFile);
        }
        return null;
    }
    public void printcmds() {
        for (DrawingCommand a : dFile) {
            System.out.print(a.type().name() + " ");
            if (a.type().name() == "PEN" || a.type().name() == "FILL") {
                System.out.print(a.property() + " ");
            } else {
                for (double b : a.coordinates()) {
                    System.out.print(b + " ");
                }
            }
            System.out.println(" ");
        }
    }
    public void addcommand(DrawingCommand a){
        this.dFile.add(a);
    }
    public void savefile(ArrayList<DrawingCommand> input) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));// + "\\Vec");
        FileFilter filter = new FileNameExtensionFilter("vec files", "vec");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showSaveDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file + ".vec"));
                for (DrawingCommand k : input) {
                    writer.write(k.tostring());
                    writer.newLine();
                }
                writer.close();
            } catch (IOException e) {
            }
        }
    }
}
