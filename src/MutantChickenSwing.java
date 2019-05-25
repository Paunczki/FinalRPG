import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MutantChickenSwing {

  public static void main(String avg[]) throws Exception {
    BufferedImage img = ImageIO.read(new File(
        "MutantAlienChicken.jpg"));
    ImageIcon icon = new ImageIcon(img);
    JFrame frame = new JFrame();
    frame.setLayout(new FlowLayout());
    frame.setSize(1000,1000);
    JLabel lbl = new JLabel();
    lbl.setIcon(icon);
    frame.add(lbl);
    frame.setVisible(true);
    
    Thread.sleep(3000);
    frame.setVisible(false);
    frame.dispose();
  }
}