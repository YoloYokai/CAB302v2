import com.sun.source.tree.SwitchTree;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileParser {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Vec");
        FileFilter filter = new FileNameExtensionFilter("vec files", "vec");
        chooser.setFileFilter(filter);
        List<String> commands = new ArrayList<>();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            try {
                BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                String command = reader.readLine();
                while (command != null && command != "null") {
                    commands.add(command);
                    command = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {}
            ArrayList<DrawingCommand> dFile = new ArrayList<>();
            for (int i = 0; i < commands.size(); i++) {

                String[] coordstring = commands.get(i).split(" ");
                ArrayList<Double> coordsdouble = new ArrayList<>();
                String properties = null;
                if(!commands.get(i).contains("PEN")&&!commands.get(i).contains("FILL")){
                    for (int j = 1; j < coordstring.length; j++){coordsdouble.add(Double.parseDouble(coordstring[j]));}
                }
                else{
                    for (int j = 1; j < coordstring.length; j++){
                    properties=(coordstring[j]);
                }
                }
                if(commands.get(i).contains(DrawingCommand.DrawCommands.LINE.cmd())){dFile.add(new LineCommand(coordsdouble));}
                else if(commands.get(i).contains(DrawingCommand.DrawCommands.RECTANGLE.cmd())){dFile.add(new RectangleCommand(coordsdouble));}
                else if(commands.get(i).contains(DrawingCommand.DrawCommands.ELLIPSE.cmd())){dFile.add(new EllipseCommand(coordsdouble));}
                else if(commands.get(i).contains(DrawingCommand.DrawCommands.RECTANGLE.cmd())){dFile.add(new RectangleCommand(coordsdouble));}

            }
            for (DrawingCommand a : dFile) {
                System.out.print(a.type().name()+" ");
                if(a.type().name()!="PEN" && a.type().name()!="FILL"){
                for (double b : a.coordinates()) {
                    System.out.print(b+" ");
                }
                System.out.println(" ");
            }
        }
    }
}}
