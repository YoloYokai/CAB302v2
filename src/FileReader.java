import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "\\Vec");
        FileFilter filter = new FileNameExtensionFilter("vec files", "vec");
        //chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            //chooser.getSelectedFile().canRead();
            // File Vec = new File(chooser.getSelectedFile().getAbsolutePath());
            //FileReader R = new FileReader(Vec);
            //BufferedReader br = new BufferedReader();
        }
    }
}
