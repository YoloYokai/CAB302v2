package Assignment;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;


public class GUI {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame("Swing Assignment.Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.setSize(800,800);
        f.setVisible(true);
        f.add(new MyPanel());
        JMenuBar mb=new JMenuBar();
        JMenu file;
        JMenu edit;
        JMenuItem save, load, undo, redo;
        file=new JMenu("File");
        edit=new JMenu("Edit");
        save=new JMenuItem("Save");
        load=new JMenuItem("Load");
        undo=new JMenuItem("Undo");
        redo=new JMenuItem("Redo");
        file.add(save); file.add(load);
        edit.add(undo); edit.add(redo);
        mb.add(file);
        mb.add(edit);
        f.setJMenuBar(mb);
    }
}