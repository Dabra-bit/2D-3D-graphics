import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MiniPaint extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    private JPanel area;
    private JLabel status;
    private Image buffer;
    private Image tempImg;

    private final int PUNTOS = 1;
    private final int LINEAS = 2;
    private final int RECTANGULOS = 3;
    private final int CIRCULOS = 4;

    private int modo;
    private int x, y;

    public MiniPaint() {
        super("Minipaint 2.0");

        JMenuBar menuBar = new JMenuBar(); // Menu bar
        JMenu menu;

        // *************************** Menú archivo ***************************
        menu = new JMenu("Archivo");

        // Opción Nuevo
        menu.add(this.getNewOption("Nuevo", 'N'));

        menu.addSeparator();

        // Opción Salir
        menu.add(this.getNewOption("Salir", 'S'));

        menuBar.add(menu); // Add file menu to the bar
        // *************************** Menú archivo ***************************

        // *************************** Menú modo ***************************
        menu = new JMenu("Modo");

        // Opción Puntos
        menu.add(this.getNewOption("Puntos", 'P'));

        menu.addSeparator();

        // Opción Lineas
        menu.add(this.getNewOption("Líneas", 'L'));

        menu.addSeparator();

        // Opción Rectángulos
        menu.add(this.getNewOption("Rectángulos", 'R'));

        menu.addSeparator();

        // Opción Círculos
        menu.add(this.getNewOption("Círculos", 'C'));

        menuBar.add(menu); // Add mode menu to the bar
        // *************************** Menú modo ***************************

        this.area = new JPanel();
        this.area.addMouseListener(this);
        this.area.addMouseMotionListener(this);
        this.status = new JLabel("Status", JLabel.LEFT);

        // Assing menues bar
        setJMenuBar(menuBar);

        // Add graphic zone
        getContentPane().add(this.area, BorderLayout.CENTER);

        // Add status bar
        getContentPane().add(this.status, BorderLayout.SOUTH);

        this.modo = PUNTOS;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        this.buffer = this.area.createImage(this.area.getWidth(), this.area.getHeight());
    }

    private JMenuItem getNewOption(String name, int abbr) {
        // Generate new option
        JMenuItem tempOpt = new JMenuItem(name, abbr);
        tempOpt.addActionListener(this);
        tempOpt.setActionCommand(name);

        return tempOpt;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Nuevo":
                this.area.getGraphics().clearRect(0, 0, this.area.getWidth(), this.area.getHeight());
                this.buffer = this.area.createImage(this.area.getWidth(), this.area.getHeight());
                break;

            case "Salir":
                // JOptionPane for confirmation
                int confirmed = JOptionPane.showConfirmDialog(this, "¿En verdad desea salir?", "Confirmación",
                        JOptionPane.YES_NO_CANCEL_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose();
                    System.exit(0);
                }
                break;

            case "Puntos":
                this.modo = PUNTOS;
                break;

            case "Líneas":
                this.modo = LINEAS;
                break;

            case "Rectángulos":
                this.modo = RECTANGULOS;
                break;

            case "Círculos":
                this.modo = CIRCULOS;
                break;

            default:
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();

        this.tempImg = this.area.createImage(this.area.getWidth(), this.area.getHeight());
        this.tempImg.getGraphics().drawImage(this.buffer, 0, 0, this);
    }

    public void mouseReleased(MouseEvent e) {
        this.buffer.getGraphics().drawImage(this.tempImg, 0, 0, this);
    }

    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }

    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getDefaultCursor());
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = this.tempImg.getGraphics();

        int e_x = e.getX();
        int e_y = e.getY();
        int start_x = e_x > x ? x : e_x;
        int start_y = e_y > y ? y : e_y;

        int rectWidth = Math.abs(e_x - x);
        int rectHeight = Math.abs(e_y - y);

        switch(modo) {
            case PUNTOS:
                g.fillOval(e.getX(), e.getY(), 1, 1);
                this.area.getGraphics().drawImage(this.tempImg, 0, 0, this);
                break;

            case LINEAS:
                g.drawImage(this.buffer, 0, 0, area);
                g.drawLine(x, y, e.getX(), e.getY());
                this.area.getGraphics().drawImage(this.tempImg, 0, 0, this);
                break;
            
            case RECTANGULOS:
                g.drawImage(this.buffer, 0, 0, area);
                g.drawRect(start_x, start_y, rectWidth, rectHeight);
                this.area.getGraphics().drawImage(this.tempImg, 0, 0, this);
                break;

            case CIRCULOS:
                g.drawImage(this.buffer, 0, 0, area);
                g.drawOval(start_x, start_y, rectWidth, rectHeight);
                this.area.getGraphics().drawImage(this.tempImg, 0, 0, this);
                break;

            default:
        }
    }

    public void mouseMoved(MouseEvent e) {
        this.status.setText("x=" + e.getX() + ",y=" + e.getY());
    }

    public static void main(String[] args) {
        new MiniPaint();
    }
}
