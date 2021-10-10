import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prac2 extends JFrame implements ActionListener {
    
    private JPanel panel;

    private JLabel lblTest;
    private JTextArea txtAreaDesc;
    private JButton btnSend;
    private JCheckBox chkBoxVacc;
    private JRadioButton rdoBtnMasc;
    private JRadioButton rdoBtnFem;
    private ButtonGroup btnGrpGend;
    private JList lstMajor;
    private JComboBox cmbBoxSchool;
    private JScrollBar scroll;
    private JTable tblRndNumb;
    private JMenu menu;
    private JMenuBar mnBarFile;
    private JOptionPane optPaneMsg;


    public Prac2() {
        super("Frame y componentes");
        
        
        
        // Add graphic zone
        this.panel = new JPanel();
        getContentPane().add(this.panel, BorderLayout.CENTER);

        // Add menu bar
        this.mnBarFile = new JMenuBar();
        this.menu = new JMenu("Archivo");
        this.menu.add(this.addMenuItem("Opcion 1", '1')); // Option 1
        this.menu.addSeparator(); // Separator
        this.menu.add(this.addMenuItem("Opcion 2", '2')); // Option 2
        this.mnBarFile.add(this.menu); // Add file menu to the bar
        getContentPane().add(this.mnBarFile, BorderLayout.SOUTH);

        // Name label
        this.lblTest = new JLabel("Label test");
        this.lblTest.setLocation(50, 50);
        this.panel.add(this.lblTest);

        // Text box description
        this.txtAreaDesc = new JTextArea("Descripction");
        this.txtAreaDesc.setLocation(50, 100);
        this.panel.add(this.txtAreaDesc);

        // Window properties
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); // Disable window risizing
        setSize(600, 600); // Set window size
        setLocationRelativeTo(null); // Open window in the center of the screen

        // Set visible
        setVisible(true);
    }

    private JMenuItem addMenuItem(String name, int abbr) {
        // Generate new option
        JMenuItem tempOpt = new JMenuItem(name, abbr);
        tempOpt.addActionListener(this);
        tempOpt.setActionCommand(name);

        return tempOpt;
    }

    public void actionPerformed(ActionEvent e) {

    }
}
