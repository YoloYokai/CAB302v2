package Assignment;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;


public class GUI extends JFrame {
    JButton blackBtn, cyanBtn, greenBtn, redBtn, magentaBtn,
            orangeBtn, yellowBtn, plotBtn, lineBtn, rectangleBtn, ellipseBtn,
            polygonBtn, noFillBtn, fillBtn;

    // Used to monitor which shape is selected
    int currentAction = 1;
    int currentColour = 1;
    boolean fill = false;

    // Stores drawing rules
    Graphics2D graphSettings;

    // Default stroke and fill colours
    Color strokeColor = Color.BLACK, fillColor = Color.BLACK;

    public static void main(String[] args) {
        new GUI();
    }

    // Defines JFrame default settings
    public GUI() {
        // Default window width and height
        this.setSize(800, 600);

        // Sets window title to application name
        this.setTitle("Sketchy");

        // Closes the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adds menu bar and items
        JMenuBar mb=new JMenuBar();
        JMenu file, edit, help;
        JMenuItem save, load, undo;

        file=new JMenu("File");
        edit=new JMenu("Edit");
        help=new JMenu("Help");
        save=new JMenuItem("Save");
        load=new JMenuItem("Load");
        undo=new JMenuItem("Undo");

        file.add(save);
        file.add(load);
        edit.add(undo);
        mb.add(file);
        mb.add(edit);
        mb.add(help);

        this.setJMenuBar(mb);

        // Navigates files via the menu bar
        FileParser parser = new FileParser();
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parser.loadfile();
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parser.savefile(parser.getdFile());

            }
        });

        // Swing box to hold the tool buttons
        Box toolBox = Box.createHorizontalBox();

        // Creates a JPanel to hold the box
        JPanel toolPanel = new JPanel();

        //Calls a function to create buttons
        plotBtn = makeButtons("./src/Assignment/plot.png", 1);
        lineBtn = makeButtons("./src/Assignment/line.png", 2);
        rectangleBtn = makeButtons("./src/Assignment/rectangle.png", 3);
        ellipseBtn = makeButtons("./src/Assignment/ellipse.png", 4);
        polygonBtn = makeButtons("./src/Assignment/polygon.png", 5);

        blackBtn = makeColourButtons("./src/Assignment/black.png", 1 );
        cyanBtn = makeColourButtons("./src/Assignment/cyan.png", 2 );
        greenBtn = makeColourButtons("./src/Assignment/green.png", 3);
        redBtn = makeColourButtons("./src/Assignment/red.png", 4 );
        magentaBtn = makeColourButtons("./src/Assignment/magenta.png", 5);
        orangeBtn = makeColourButtons("./src/Assignment/orange.png", 6);
        yellowBtn = makeColourButtons("./src/Assignment/yellow.png", 7);

        //Pass true/false value depending on if the shape is being filled in
        noFillBtn = makeFillButtons("./src/Assignment/nofill.png", 6, true);
        fillBtn = makeFillButtons("./src/Assignment/fill.png", 7, false);


        // Shows the frame
        this.setVisible(true);

        // add buttons to tools panel
        toolBox.add(plotBtn);
        toolBox.add(lineBtn);
        toolBox.add(rectangleBtn);
        toolBox.add(ellipseBtn);
        toolBox.add(polygonBtn);
        toolBox.add(noFillBtn);
        toolBox.add(fillBtn);

        // Add the box of buttons to the panel
        toolPanel.add(toolBox);

        // Position the buttons in the bottom of the frame
        this.add(toolPanel, BorderLayout.SOUTH);

        // Creates new JPanel for colour swatches
        JPanel colours = new JPanel();

        // Add colour buttons to panel
        colours.add(blackBtn);
        colours.add(cyanBtn);
        colours.add(magentaBtn);
        colours.add(redBtn);
        colours.add(orangeBtn);
        colours.add(yellowBtn);
        colours.add(greenBtn);


        // Add to top of content pane
        this.add(colours, BorderLayout.NORTH);

        // Make the drawing area take up the rest of the frame
        this.add(new Canvas(), BorderLayout.CENTER);

        // Show the frame
        this.setVisible(true);
    }

    // Produces buttons with supplied images as icons
    // ActionNum associates buttons with which shapes is being drawn
    public JButton makeButtons(String iconFile, final int actionNum) {
        JButton aButton = new JButton();
        Icon butIcon = new ImageIcon(iconFile);
        aButton.setIcon(butIcon);

        // Make the proper actionPerformed method execute when the
        // specific button is pressed
        aButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                currentAction = actionNum;
            }
        });

        return aButton;
    }

    // Produces colour buttons with supplied images as icons
    public JButton makeColourButtons(String iconFile, final int colourNum) {
        JButton aButton = new JButton();
        Icon butIcon = new ImageIcon(iconFile);
        aButton.setIcon(butIcon);

        // Make the proper actionPerformed method execute when the
        // specific button is pressed
        aButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                currentColour = colourNum;
                if (colourNum == 1){
                    fill = true;
                    strokeColor = Color.BLACK;
                    fillColor = Color.BLACK;
                }
                else if (colourNum == 2){
                    fill = true;
                    strokeColor = Color.CYAN;
                    fillColor = Color.CYAN;
                }
                else if (colourNum == 3){
                    fill = true;
                    strokeColor = Color.GREEN;
                    fillColor = Color.GREEN;
                }
                else if (colourNum == 4){
                    fill = true;
                    strokeColor = Color.RED;
                    fillColor = Color.RED;
                }
                else if (colourNum == 5){
                    fill = true;
                    strokeColor = Color.MAGENTA;
                    fillColor = Color.MAGENTA;
                }
                else if (colourNum == 6){
                    fill = true;
                    strokeColor = Color.ORANGE;
                    fillColor = Color.ORANGE;
                }
                else if (colourNum == 7){
                    fill = true;
                    strokeColor = Color.YELLOW;
                    fillColor = Color.YELLOW;
                }
            }
        });
        return aButton;
    }

    // Similar function to above, but includes a color chooser with dialogue
    public JButton makeFillButtons(String iconFile, final int actionNum, final boolean nofill) {
        JButton aButton = new JButton();
        Icon butIcon = new ImageIcon(iconFile);
        aButton.setIcon(butIcon);

        aButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (nofill) {
                    strokeColor = JColorChooser.showDialog(null, "Choose a Stroke", Color.BLACK);
                } else {
                    fillColor = JColorChooser.showDialog(null, "Choose a Fill", Color.BLACK);
                    fill = true;
                }
            }
        });

        return aButton;
    }

    private class Canvas extends JComponent
    {

        // ArrayLists that contain each shape drawn along with
        // that shapes stroke and fill

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        ArrayList<Color> shapeFill = new ArrayList<Color>();
        ArrayList<Color> shapeStroke = new ArrayList<Color>();

        Point drawStart, drawEnd;

        // Monitors events on the drawing area of the frame

        public Canvas()
        {

            this.addMouseListener(new MouseAdapter()
            {

                public void mousePressed(MouseEvent e)
                {

                    if(currentAction != 1){

                        // When the mouse is pressed get x & y position

                        drawStart = new Point(e.getX(), e.getY());
                        drawEnd = drawStart;
                        repaint();

                    }
                    if(currentAction == 1){

                        int x = e.getX();
                        int y = e.getY();

                        Shape aShape = null;

                        strokeColor = fillColor;

                        aShape = drawLine(x, y, e.getX(), e.getY());

                        shapes.add(aShape);
                        shapeFill.add(fillColor);
                        shapeStroke.add(strokeColor);
                        repaint();
                    }
                }

                public void mouseReleased(MouseEvent e)
                {

                    if(currentAction != 1){

                        // Create a shape using the starting x & y
                        // and finishing x & y positions

                        Shape aShape = null;

                        if (currentAction == 2){
                            aShape = drawLine(drawStart.x, drawStart.y,
                                    e.getX(), e.getY());
                        } else if (currentAction == 3) {
                            // Create a new rectangle using x & y coordinates
                            aShape = drawRectangle(drawStart.x, drawStart.y,
                                    e.getX(), e.getY());
                        } else if (currentAction == 4){
                            aShape = drawEllipse(drawStart.x, drawStart.y,
                                    e.getX(), e.getY());
                        }

                        // Add shapes, fills and colors to their ArrayLists
                        shapes.add(aShape);
                        shapeStroke.add(strokeColor);

                        // Add fill colour if applicable
                        if (fill == true){
                            shapeFill.add(fillColor);
                        }

                        // repaint the drawing area
                        drawStart = null;
                        drawEnd = null;

                        repaint();

                    }

                }
            } );

            this.addMouseMotionListener(new MouseMotionAdapter()
            {

                public void mouseDragged(MouseEvent e)
                {
                    // Get the final x & y position after the mouse is dragged

                    drawEnd = new Point(e.getX(), e.getY());
                    repaint();
                }
            } );
        }


        public void paint(Graphics g)
        {
            // Class used to define the shapes to be drawn
            graphSettings = (Graphics2D)g;

            // Antialiasing cleans up the jagged lines and defines rendering rules
            graphSettings.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            // Defines the line width of the stroke
            graphSettings.setStroke(new BasicStroke(4));

            // Iterators created to cycle through strokes and fills
            Iterator<Color> strokeCounter = shapeStroke.iterator();
            Iterator<Color> fillCounter = shapeFill.iterator();

            for (Shape s : shapes)
            {
                // Grabs the next stroke from the color arraylist
                graphSettings.setPaint(strokeCounter.next());

                graphSettings.draw(s);

                if (fill == true){
                    // Grabs the next fill from the color arraylist
                    graphSettings.setPaint(fillCounter.next());
                    graphSettings.fill(s);
                }
            }

            // Guide shape used for drawing
            if (drawStart != null && drawEnd != null)
            {
                // Makes the guide shape transparent and gray
                graphSettings.setComposite(AlphaComposite.getInstance(
                        AlphaComposite.SRC_OVER, 0.40f));
                graphSettings.setPaint(Color.LIGHT_GRAY);

                Shape aShape = null;

                if (currentAction == 2){
                    // Create a new line using x & y coordinates
                    aShape = drawLine(drawStart.x, drawStart.y,
                            drawEnd.x, drawEnd.y);
                } else

                if (currentAction == 3){
                    // Create a new rectangle using x & y coordinates

                    aShape = drawRectangle(drawStart.x, drawStart.y,
                            drawEnd.x, drawEnd.y);
                } else

                if (currentAction == 4) {

                    // Create a new ellipse using x & y coordinates
                    aShape = drawEllipse(drawStart.x, drawStart.y,
                            drawEnd.x, drawEnd.y);
                }

                graphSettings.draw(aShape);
            }
        }

        // Helper function for drawing the rectangle correctly
        private Rectangle2D.Float drawRectangle(
                int x1, int y1, int x2, int y2)
        {
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);

            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            return new Rectangle2D.Float(
                    x, y, width, height);
        }

        // Helper function for drawing the ellipse correctly
        private Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2)
        {

            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            return new Ellipse2D.Float(
                    x, y, width, height);
        }

        // Helper function for drawing lines
        private Line2D.Float drawLine(
                int x1, int y1, int x2, int y2)
        {

            return new Line2D.Float(
                    x1, y1, x2, y2);
        }

        // Helper function for broke stroke height/width
        private Ellipse2D.Float drawBrush(
                int x1, int y1, int brushStrokeWidth, int brushStrokeHeight)
        {

            return new Ellipse2D.Float(
                    x1, y1, brushStrokeWidth, brushStrokeHeight);

        }

    }
}