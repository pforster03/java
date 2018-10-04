public class Average{
  public static void main(String[] args) {

  }
  public double average(Integer... nums){
    int sum = 0;
    for (int i : nums) {
      sum += i;
    }
    return sum / nums.length;
  }
}
