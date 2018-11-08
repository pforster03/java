import javax.swing.JOptionPane;
import javax.swing.*;
import java.math.MathContext;
import java.math.BigDecimal;
import java.awt.*;

public class RandomPi{
  public static void displayNumber(String number, JFrame frame){
    StringBuilder sb = new StringBuilder("PI approx\n");
    sb.append(number);
    JTextArea jta = new JTextArea(sb.toString());
    @SuppressWarnings("serial")
    JScrollPane jsp = new JScrollPane(jta){
      @Override
      public Dimension getPreferredSize() {
        return new Dimension(480, 320);
      }
    };

    frame.getContentPane().add(jsp, BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args){
    JFrame frame = new JFrame("Calculating...");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MathContext context = MathContext.UNLIMITED;

    BigDecimal inside = new BigDecimal(0, context);
    String str = JOptionPane.showInputDialog("Enter number of trials");
    BigDecimal trials = new BigDecimal(str, context);
    str = JOptionPane.showInputDialog("Enter output precision");
    Integer precision = Integer.parseInt(str);

    JProgressBar progressBar = new JProgressBar(0, Integer.parseInt(trials.toPlainString()));
    progressBar.setString("Computing x and y...");
    progressBar.setValue(0);
    progressBar.setStringPainted(true);
    progressBar.setIndeterminate(false);

    frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

    frame.getContentPane().add(progressBar, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);


    BigDecimal one = new BigDecimal(1, context);

    BigDecimal x;
    BigDecimal y;
    for(BigDecimal j = new BigDecimal(0, context); trials.compareTo(j) == 1; j = j.add(one, context)){
      x = new BigDecimal(Math.random(), context);
      y = new BigDecimal(Math.random(), context);
      // System.out.println(x + " " + y + " " + (x.multiply(x, context).add(y.multiply(y, context), context)) + " " + ((x.multiply(x, context).add(y.multiply(y, context), context)).compareTo(one)));
      if (((x.multiply(x, context).add(y.multiply(y, context), context)).compareTo(one)) == -1)
      inside = inside.add(one);
      progressBar.setValue(Integer.parseInt(j.toString()));
    }
    progressBar.setIndeterminate(true);
    BigDecimal four = new BigDecimal(4, context);
    progressBar.setString("Multiplying...");
    BigDecimal multiplied = four.multiply(inside, context);
    progressBar.setString("Dividing...");
    BigDecimal number = multiplied.divide(trials, precision, BigDecimal.ROUND_HALF_UP);

    progressBar.remove(frame.getContentPane());
    progressBar = null;
    frame.setVisible(false);
    frame.remove(0);
    JFrame frame2 = new JFrame("PI approx");
    displayNumber(number.toString(), frame2);
  }
}
