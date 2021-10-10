import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Dimension;

class Pantalla extends JPanel {
  private Image imagen;

  public Pantalla(Image img) {
    this.imagen = img;
  }

  public void paint(Graphics g) {
    super.paint(g);

    Dimension tam = new Dimension(this.imagen.getWidth(this), this.imagen.getHeight(this));
    setPreferredSize(tam);
    setMinimumSize(tam);
    setMaximumSize(tam);
    setSize(tam);
    update(g);
  }

  public void update(Graphics g) {
    g.drawImage(this.imagen, 0, 0, this);
  }
}
