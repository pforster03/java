package compoundinterest;

public class CompoundInterest{
 //This class presents various ways to compute compound interest
 // on a yearly basis. In addition it includes a method - findRate -
 // which, given a start amount, a target amount, and a number of
 // years, finds and returns the interest rate that will yield the target
 // amount after accumulation for the given number of years.
 private double rate;
 private double amount;
 private double fee = 0.0; // yearly fee
 private int years;
 final double tolerance = 100.00; // used by findRate

 public  CompoundInterest(double r, double start, int years){
   amount = start;
   rate = r;
   this.years = years;
 }

 public  CompoundInterest(double r, double start, int years, double fee){
   amount = start;
   rate = r;
   this.fee = fee;
   this.years = years;
 }

 public  CompoundInterest(){
   amount = 0.0;
   rate = 0.0;
   years = 0;
 }

 public double getAmount(){
   return amount;
 }

 public double getFee(){
   return fee;
 }

 public void setFee(double fee){
   this.fee = fee;
 }

 public double getRate(){
   return rate;
 }

 public double calcAmt(){
   // calculates amount accrued for given rate, start amount
   // a fee is deducted every year
   double  amt = amount;
   for(int y = 0; y < years; y++)
     amt = (1 + rate)*amt - fee;
   return(amt);
 }

 public double calcAmt(double someAmt,int years,double r){
   // r is any interest rate, amount any start amount
   // calculates amount accrued for this rate, initial amount
   double amt = someAmt;
   for(int y = 0; y < years; y++)
     amt = (1 + r)*amt - fee;
   return(amt);
 }

 public double findRate(double amt, double target,int years){
   // returns rate at which amt reaches target exactly (within tolerance)
   // after given number of years.
   // Uses binary search to find this rate.
   // low and high always bracket the sought-after rate
   // mid is rate midway between high and low. If mid yields an amt
   // that's below target, mid and high bracket sought-after rate
   // otherwise, low and mid bracket sought-after rate
   double low = 0.0;
   double high = findUpBound(amt,target,years);
   double mid = (high + low)/2; // mid: middle rate
   double curRate = mid;
   double curAmt = calcAmt(amt, years, mid);
   while (Math.abs(curAmt - target) > tolerance){
     System.out.println("current middle rate: " + mid);
     if (curAmt > target)
     {
       high = mid;
       mid = (mid + low)/2;
     }
     else
     {
       low = mid;
       mid = (mid+high)/2;
     }
     curAmt = calcAmt(amt, years, mid);
   } // end loop
   return mid;
 }

 public double findUpBound(double amt, double target, int years){
   // given an amt, method crudely finds a rate with this property:
   // compounding at this rate for given number of years,
   // accumulated  amount will exceed target
   final double increment = .10; //guess, going up by 10% each year
   double rate = increment;
   while(calcAmt(amt,years,rate) < target){
     rate = rate + increment;
   } // loop
   return rate;
 }
}
