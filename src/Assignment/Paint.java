package Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Paint extends JComponent {

    public int pentype = 2;
    // Image in which we're going to draw
    private Image image;
    // Graphics2D object ==> used to draw on
    private Graphics2D g2;
    // Mouse coordinates
    private int currentX, currentY, oldX, oldY;

    public Paint() {
        if (pentype == 0) {
            setDoubleBuffered(false);
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    // save coord x,y when the mouse is pressed
                    oldX = e.getX();
                    oldY = e.getY();
                }
            });
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent e) {
                    // coord x,y when dragging mouse
                    currentX = e.getX();
                    currentY = e.getY();

                    if (g2 != null) {
                        // draw line if g2 context is not null
                        g2.drawLine(oldX, oldY, currentX, currentY);
                        // refresh draw area to repaint
                        repaint();
                        // store current coords x,y as olds x,y
                        oldX = currentX;
                        oldY = currentY;
                    }
                }
            });
        } else if (pentype == 1) {
            setDoubleBuffered(false);
            addMouseListener(new MouseAdapter() {
                boolean point = false;

                public void mousePressed(MouseEvent e) {
                    // save coord x,y when the mouse is pressed
                    if (!point) {
                        oldX = e.getX();
                        oldY = e.getY();
                        point = true;
                    } else {
                        currentX = e.getX();
                        currentY = e.getY();

                        if (g2 != null) {
                            // draw line if g2 context is not null
                            g2.drawLine(oldX, oldY, currentX, currentY);
                            // refresh draw area to repaint
                            repaint();
                            point = false;
                        }
                    }
                }
            });
        } else if (pentype == 2) {
            setDoubleBuffered(false);
            addMouseListener(new MouseAdapter() {
                boolean point = false;

                public void mousePressed(MouseEvent e) {

                    // save coord x,y when the mouse is pressed
                    if (!point) {
                        oldX = e.getX();
                        oldY = e.getY();
                        point = true;
                    } else {
                        currentX = e.getX();
                        currentY = e.getY();

                        if (g2 != null) {
                            // draw line if g2 context is not null
                            if (oldX < currentX && oldY < currentY) {
                                g2.drawRect(oldX, oldY, currentX - oldX, currentY - oldY);
                            } else if (currentX < oldX && oldY < currentY) {
                                g2.drawRect(currentX, oldY, oldX - currentX, currentY - oldY);
                            } else if (oldX > currentX && oldY > currentY) {
                                g2.drawRect(currentX, currentY, oldX - currentX, oldY - currentY);
                            } else if (oldX < currentX && currentY < oldY) {
                                g2.drawRect(oldX, currentY, currentX - oldX, oldY - currentY);
                            }
                            // refresh draw area to repaint
                            repaint();
                            point = false;
                        }
                    }
                }
            });
        } else if (pentype == 3) {

        } else if (pentype == 4) {

        } else if (pentype == 5) {
        }
    }

    public void update(ArrayList<DrawingCommand> a) {
        for (DrawingCommand cmd : a) {
            if (g2 != null) {
                ArrayList<Integer> Coords = new ArrayList<>();

                if (cmd.property() == null) {
                    System.out.println(cmd.tostring());
                    boolean x = true;
                    for (Double b : cmd.coordinates()) {
                        if (x) {
                            Coords.add((int) (b * this.getSize().width));
                            x = false;
                        } else {
                            Coords.add((int) (b * this.getSize().height));
                            x = true;
                        }
                    }
                    if (cmd.type() == DrawingCommand.DrawCommands.LINE) {
                        g2.drawLine(Coords.get(0), Coords.get(1), Coords.get(2), Coords.get(3));
                        repaint();
                    } else if (cmd.type() == DrawingCommand.DrawCommands.RECTANGLE) {
                        if (true)
                            g2.drawRect(Coords.get(0), Coords.get(1), Coords.get(2) - Coords.get(0), Coords.get(3) - Coords.get(1));
                        repaint();
                    } else if (cmd.type() == DrawingCommand.DrawCommands.PLOT) {
                        g2.drawLine(Coords.get(0), Coords.get(1), Coords.get(0), Coords.get(1));
                    }
                } else {
                    if (cmd.type() == DrawingCommand.DrawCommands.FILL) {

                    }
                }

            }
        }
    }
    protected void paintComponent(Graphics g) {
        if (image == null) {
            // image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        g2.setPaint(Color.white);
        // draws white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
    public void red() {
        // apply red colour
        g2.setPaint(Color.red);
    }
    public void black() {
        //apply black colour
        g2.setPaint(Color.black);
    }
    public void magenta() {
        //apply magenta colour
        g2.setPaint(Color.magenta);
    }
    public void green() {
        //apply green colour
        g2.setPaint(Color.green);
    }
    public void cyan() {
        //apply blue colour
        g2.setPaint(Color.cyan);
    }

    public void orange() {
        //apply orange colour
        g2.setPaint(Color.orange);
    }

    public void yellow() {
        //apply yellow colour
        g2.setPaint(Color.yellow);
    }

    public void plot() {
        pentype = 0;
    }

    public void line() {
        pentype = 1;
    }

    public void rectangle() {
        pentype = 2;
    }

    public void ellipse() {
        pentype = 3;
    }

    public void polygon() {
        pentype = 4;
    }

    public void fill() {
        pentype = 5;
    }
}