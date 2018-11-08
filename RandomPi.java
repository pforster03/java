import javax.swing.JOptionPane;
import javax.swing.*;
import java.math.MathContext;
import java.math.BigDecimal;
import java.awt.*;

public class RandomPi{
  static BigDecimal inside;
  static final Integer MAX = 10;

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

  static class MultithreadingDemo extends Thread{
    public void run(JProgressBar progressBar, MathContext context, BigDecimal one, Integer num){
      BigDecimal x;
      BigDecimal y;
      x = new BigDecimal(Math.random(), context);
      y = new BigDecimal(Math.random(), context);
      if (((x.multiply(x, context).add(y.multiply(y, context), context)).compareTo(one)) == -1)
        inside = inside.add(one);
      progressBar.setValue(num);
    }
  }

  public static void main(String[] args){
    JFrame frame = new JFrame("Calculating...");
    frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    MathContext context = MathContext.UNLIMITED;

    inside = new BigDecimal(0, context);
    String str = JOptionPane.showInputDialog("Enter number of trials");
    BigDecimal trials = new BigDecimal(str, context);
    str = JOptionPane.showInputDialog("Enter output precision");
    Integer precision = Integer.parseInt(str);

    String plain = trials.toPlainString();
    String trials2 = plain.substring(0, Math.min(plain.length(), MAX));
    JProgressBar progressBar = new JProgressBar(0, Integer.parseInt(trials2));
    progressBar.setString("Computing x and y...");
    progressBar.setValue(0);
    progressBar.setStringPainted(true);
    progressBar.setIndeterminate(false);

    frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

    frame.getContentPane().add(progressBar, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);

    BigDecimal one = new BigDecimal(1, context);

    for(BigDecimal j = new BigDecimal(0, context); trials.compareTo(j) == 1; j = j.add(one, context)){
      MultithreadingDemo object = new MultithreadingDemo();
      object.start();
      object.run(progressBar, context, one, Integer.parseInt(j.toString().substring(0, Math.min(j.toString().length(), MAX))));
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
    frame2.setExtendedState(frame2.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    displayNumber(number.toString(), frame2);
  }
}
