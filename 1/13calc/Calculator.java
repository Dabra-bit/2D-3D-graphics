import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class Calculator extends JFrame implements Runnable {
    
    private JLabel displayLbl;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnPoint;
    private JButton btnEquals;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMult;
    private JButton btnDiv;

    public Calculator(String windowName, int width, int height) {
        super(windowName);
        setSize(width, height);
        setWindowConfig();

        initComponents();
        createCalculator();
    }

    private void setWindowConfig() {
        // Close application on window close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // Disable window risizing
        setLocationRelativeTo(null); // Open window in the center of the screen
    }

    private void initComponents() {
        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btnPoint = new JButton(".");
        btnEquals = new JButton("=");
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnMult = new JButton("x");
        btnDiv = new JButton("/");
    }

    private void createCalculator() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        setLayout(new GridLayout(5, 4));

        add(btn7);
        add(btn8);
        add(btn9);
        add(btnPlus);
        
        add(btn4);
        add(btn5);
        add(btn6);
        add(btnMinus);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btnMult);

        add(btnPoint);
        add(btn0);
        add(btnEquals);
        add(btnDiv);
    }

    @Override
    public void run() {

    }
}
