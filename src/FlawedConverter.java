// Try this out in DrJava

// I refuse to provide any comments
// because I am evil. You try to figure
// this out...hee hee hee...
// There are 5 errors in this code.
// Can you find and fix them so it runs
// and gives correct results?

// Submit your corrected result with comments

// on the errors you found, here

public class FlawedConverter{
  public static void main(String[] args){
    String myName = "Freddy Krueger";
    int myAge = 57;//removed years
    int myHeightInches = 74;//fix caps
    double conversionFactor = 2.54;//add variable
    double myHeightCM = (myHeightInches*conversionFactor);//make it a double
    System.out.println("Name: "+ myName);//remove assignment operator
    System.out.println("Age: "+ myAge);
    System.out.println("Height: "+ myHeightInches);
    System.out.println("HeightCM: "+ myHeightCM);
  }
}
