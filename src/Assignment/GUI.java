package Assignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {

    JButton blackBtn, cyanBtn, greenBtn, redBtn, magentaBtn,
            orangeBtn, yellowBtn, plotBtn, lineBtn, rectangleBtn, ellipseBtn,
            polygonBtn, fillBtn;
    Paint drawArea;
    ActionListener actionListener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == blackBtn) {
                drawArea.black();
            } else if (e.getSource() == cyanBtn) {
                drawArea.cyan();
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
            } else if (e.getSource() == plotBtn) {
                drawArea.plot();
            } else if (e.getSource() == lineBtn) {
                drawArea.line();
            } else if (e.getSource() == rectangleBtn) {
                drawArea.rectangle();
            } else if (e.getSource() == ellipseBtn) {
                drawArea.ellipse();;
            } else if (e.getSource() == polygonBtn) {
                drawArea.polygon();
            } else if (e.getSource() == fillBtn) {
                drawArea.fill();
            }
        }
    };

    public static void main(String[] args) {
        new GUI().show();
    }

    public void show() {
        // create main frame
        JFrame frame = new JFrame("Sketchy");
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
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionListener);
        blackBtn.setForeground(Color.WHITE);
        blackBtn.setBackground(Color.BLACK);
        cyanBtn = new JButton("Cyan");
        cyanBtn.setBackground(Color.CYAN);
        cyanBtn.addActionListener(actionListener);
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
        controls.add(cyanBtn);

        // add to top of content pane
        content.add(controls, BorderLayout.NORTH);

        // create panel to switch between tools
        JPanel tools = new JPanel();

        //add images to buttons
        Icon plot = new ImageIcon(getClass().getResource("plot.png"));
        Icon line = new ImageIcon(getClass().getResource("line.png"));
        Icon rectangle = new ImageIcon(getClass().getResource("rectangle.png"));
        Icon ellipse = new ImageIcon(getClass().getResource("ellipse.png"));
        Icon polygon = new ImageIcon(getClass().getResource("polygon.png"));
        Icon fill = new ImageIcon(getClass().getResource("fill.png"));


        // create buttons for tools
        plotBtn = new JButton(plot);
        plotBtn.addActionListener(actionListener);
        lineBtn = new JButton(line);
        lineBtn.addActionListener(actionListener);
        rectangleBtn = new JButton(rectangle);
        rectangleBtn.addActionListener(actionListener);
        ellipseBtn = new JButton(ellipse);
        ellipseBtn.addActionListener(actionListener);
        polygonBtn = new JButton(polygon);
        polygonBtn.addActionListener(actionListener);
        fillBtn = new JButton(fill);
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
        JMenu help;
        JMenuItem save, load, undo;
        file=new JMenu("File");
        edit=new JMenu("Edit");
        help=new JMenu("Help");
        save=new JMenuItem("Save");
        load=new JMenuItem("Load");
        undo=new JMenuItem("Undo");
        file.add(save); file.add(load);
        edit.add(undo);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        frame.setJMenuBar(mb);

        frame.setSize(600, 600);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show the swing paint result
        frame.setVisible(true);
    }
}