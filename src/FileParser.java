import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Vec");
        FileFilter filter = new FileNameExtensionFilter("vec files", "vec");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            try {
                BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                List<String> commands = new ArrayList<>();
                String command = reader.readLine();
                while (command != null && command != "null") {
                    commands.add(command);
                    command = reader.readLine();
                }
                reader.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }

        }
    }
}
