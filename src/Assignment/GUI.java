package Assignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {

    JButton clearBtn, blackBtn, blueBtn, greenBtn, redBtn, magentaBtn,
            orangeBtn, yellowBtn, plotBtn, lineBtn, rectangleBtn, ellipseBtn,
            polygonBtn, fillBtn;
    Paint drawArea;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
            } else if (e.getSource() == redBtn) {
                drawArea.red();
            } else if (e.getSource() == magentaBtn) {
                drawArea.magenta();
            } else if (e.getSource() == orangeBtn) {
                drawArea.orange();
            } else if (e.getSource() == yellowBtn) {
                drawArea.yellow();
            }
        }
    };

    public static void main(String[] args) {
        new GUI().show();
    }

    public void show() {
        // create main frame
        JFrame frame = new JFrame("Swing Paint");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // create draw area
        drawArea = new Paint();

        // add to content pane
        content.add(drawArea, BorderLayout.CENTER);
        // create controls to apply colors and call clear feature
        JPanel controls = new JPanel();

        // create buttons
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionListener);
        blackBtn.setBackground(Color.BLACK);
        blueBtn = new JButton("Blue");
        blueBtn.setBackground(Color.BLUE);
        blueBtn.addActionListener(actionListener);
        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionListener);
        greenBtn.setBackground(Color.GREEN);
        redBtn = new JButton("Red");
        redBtn.addActionListener(actionListener);
        redBtn.setBackground(Color.RED);
        magentaBtn = new JButton("Magenta");
        magentaBtn.addActionListener(actionListener);
        magentaBtn.setBackground(Color.MAGENTA);
        orangeBtn = new JButton("Orange");
        orangeBtn.addActionListener(actionListener);
        orangeBtn.setBackground(Color.ORANGE);
        yellowBtn = new JButton("Yellow");
        yellowBtn.addActionListener(actionListener);
        yellowBtn.setBackground(Color.YELLOW);

        // add buttons to panel
        controls.add(blackBtn);
        controls.add(magentaBtn);
        controls.add(redBtn);
        controls.add(orangeBtn);
        controls.add(yellowBtn);
        controls.add(greenBtn);
        controls.add(blueBtn);
        controls.add(clearBtn);

        // add to top of content pane
        content.add(controls, BorderLayout.NORTH);

        // create panel to switch between tools
        JPanel tools = new JPanel();

        // create buttons for tools
        plotBtn = new JButton("Plot");
        plotBtn.addActionListener(actionListener);
        lineBtn = new JButton("Line");
        lineBtn.addActionListener(actionListener);
        rectangleBtn = new JButton("Rectangle");
        rectangleBtn.addActionListener(actionListener);
        ellipseBtn = new JButton("Ellipse");
        ellipseBtn.addActionListener(actionListener);
        polygonBtn = new JButton("Polygon");
        polygonBtn.addActionListener(actionListener);
        fillBtn = new JButton("Fill");
        fillBtn.addActionListener(actionListener);


        // add buttons to tools panel
        tools.add(plotBtn);
        tools.add(lineBtn);
        tools.add(rectangleBtn);
        tools.add(ellipseBtn);
        tools.add(polygonBtn);
        tools.add(fillBtn);

        // add to bottom of content pane
        content.add(tools, BorderLayout.SOUTH);


        // add menu bar
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
        frame.setJMenuBar(mb);

        frame.setSize(600, 600);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show the swing paint result
        frame.setVisible(true);
    }
}