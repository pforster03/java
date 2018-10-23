package cake;

import java.nio.file.*;
import java.io.*;

import java.net.URL;


public class Cake{
  public boolean isChocolateFlavor;
  public boolean isMapleFrosting;
  public static String chocolate;
  public static String vanilla;

  // vanilla or chocolate cake, chocolate or maple frosting
  public Cake(Boolean isChocolateFlavor, Boolean isMapleFrosting){
    this.isChocolateFlavor = isChocolateFlavor;
    this.isMapleFrosting = isMapleFrosting;
    chocolate = "2 cups all-purpose flour\n" +
      "2 cups sugar\n" +
      "3/4 cup unsweetened cocoa powder\n" +
      "2 teaspoons baking powder\n" +
      "1 1/2 teaspoons baking soda\n" +
      "1 teaspoon salt\n" +
      "1 teaspoon espresso powder\n" +
      "1 cup milk buttermilk, almond, or coconut milk\n" +
      "1/2 cup vegetable canola oil, or melted coconut oil\n" +
      "2 large eggs\n" +
      "2 teaspoons vanilla extract\n" +
      "1 cup boiling water";
    vanilla = "2 cups (380g) granulated sugar\n" +
      "½ cup (118 ml) vegetable oil\n" +
      "3 large eggs\n" +
      "1 tablespoon (14.8 ml) vanilla extract\n" +
      "½ cup(118 ml) light sour cream\n" +
      "2 ½ cups (350 g) all-purpose flour\n" +
      "3 teaspoons (11.2 g) baking powder\n" +
      "1 teaspoon (5 g) salt\n" +
      "1 ¼ cups (296 ml) milk (I use nonfat)";
  }

  //toggles canada on this Cake
  public void canada(Boolean isReallyCanada){
    this.isMapleFrosting = true;
  }

  public Boolean isCanada(){
    return this.isMapleFrosting;
  }

  public static void burnCake(Cake cake){
    cake = null;
  }

  public String getRecpie(){
    return (isChocolateFlavor ? chocolate : vanilla);
  }
}
