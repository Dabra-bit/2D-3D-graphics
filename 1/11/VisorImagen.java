import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.Image;
import java.awt.Toolkit;

class VisorImagen extends JFrame {
  private JScrollPane panel;
  private Pantalla pantalla;

  public VisorImagen(String titulo, String archivo, int width, int height) {
    super(titulo);

    Image img = Toolkit.getDefaultToolkit().getImage(archivo);
    this.pantalla = new Pantalla(img);
    this.panel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    getContentPane().add(this.panel);
    this.panel.setViewportView(this.pantalla);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(width, height);
    show();
  }
}
