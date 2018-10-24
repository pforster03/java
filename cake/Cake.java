package cake;

import java.nio.file.*;
import java.io.*;

import java.net.URL;


public class Cake{
  public boolean isChocolateFlavor;
  public boolean isMapleFrosting;

  // statics don't change
  private static String chocolateRecipie;
  private static String vanillaRecipie;
  private static String chocolateFrostingRecipie;
  private static String mapleFrostingRecipie;

  // vanilla or chocolate cake, chocolate or maple frosting
  public Cake(Boolean isChocolateFlavor, Boolean isMapleFrosting){
    this.isChocolateFlavor = isChocolateFlavor;
    this.isMapleFrosting = isMapleFrosting;

    //recpies
    chocolateRecipie = "2 cups all-purpose flour\n" +
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

    vanillaRecipie = "2 cups (380g) granulated sugar\n" +
      "½ cup (118 ml) vegetable oil\n" +
      "3 large eggs\n" +
      "1 tablespoon (14.8 ml) vanilla extract\n" +
      "1/2 cup(118 ml) light sour cream\n" +
      "2 1/2 cups (350 g) all-purpose flour\n" +
      "3 teaspoons (11.2 g) baking powder\n" +
      "1 teaspoon (5 g) salt\n" +
      "1 1/4 cups (296 ml) milk (I use nonfat)";

    chocolateFrostingRecipie = "2 3/4 cup powdered sugar\n" +
      "6 tbsp unsweetened cocoa powder\n" +
      "6 tbsp butter, softened\n" +
      "5 tbsp 2% milk\n" +
      "1 tsp vanilla extrac";

    mapleFrostingRecipie = "1 stick butter (4 ounces unsalted)\n" +
      "1/3 cup maple syrup\n" +
      "1/2 cup brown sugar (light or dark, packed)\n" +
      "2 1/2 to 3 cups powdered sugar\n" +
      "2 tablespoons light cream (or half-and-half, milk, or evaporated milk; more as needed)\n" +
      "1/2 teaspoon vanilla extract\n" +
      "Optional: 1/2 teaspoon maple flavoring";
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
    //return the correct recipie using terniaries
    return "Cake:\n" + (isChocolateFlavor ? chocolateRecipie : vanillaRecipie) + "\n\nFrosting:\n" + (isMapleFrosting ? chocolateFrostingRecipie : mapleFrostingRecipie);
  }
}
