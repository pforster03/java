import javax.swing.JLabel;
import javax.swing.text.JTextComponent;

public class Graphics{
  public static void main(String[] args){
    JTextComponent x = new JTextComponent();
    JLabel label = new JLabel("Text-Only Label");
    label.setVisible(true);
    x.add(label);
  }
}
