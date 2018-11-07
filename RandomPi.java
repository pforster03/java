import javax.swing.JOptionPane;
import java.math.MathContext;
import java.math.BigDecimal;

public class RandomPi{
  public static void main(String[] args){
    MathContext context = MathContext.UNLIMITED;

    BigDecimal inside = new BigDecimal(0, context);
    String str = JOptionPane.showInputDialog("Enter number of trials");
    BigDecimal trials = new BigDecimal(str, context);

    BigDecimal one = new BigDecimal(1, context);

    BigDecimal x;
    BigDecimal y;
    for(BigDecimal j = new BigDecimal(0, context); trials.compareTo(j) == 1; j = j.add(one, context)){
      x = new BigDecimal(Math.random(), context);
      y = new BigDecimal(Math.random(), context);
      // System.out.println(x + " " + y + " " + (x.multiply(x, context).add(y.multiply(y, context), context)) + " " + ((x.multiply(x, context).add(y.multiply(y, context), context)).compareTo(one)));
      if (((x.multiply(x, context).add(y.multiply(y, context), context)).compareTo(one)) == -1)
        inside = inside.add(one);
    }
    System.out.println("exit");
    BigDecimal four = new BigDecimal(4, context);
    // System.out.println("hi" + (four.multiply(inside, context)).divide(trials, 999999999, BigDecimal.ROUND_HALF_UP));
    // JOptionPane.showMessageDialog(null, "pi guess: " + (four.multiply(inside, context)).divide(trials, 999999999, BigDecimal.ROUND_HALF_UP));
  }
}
