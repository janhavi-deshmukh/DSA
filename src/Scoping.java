
import java.lang.Math;
import java.util.Scanner;
public class Scoping {
  public static void main(String[] args){

      System.out.println("enter number");
      Scanner input=new Scanner(System.in);
      int num=input.nextInt();
      System.out.println(isArmstrong(num));

  }

  static boolean isArmstrong(int n){

      int original= n;
      int sum=0;
      while(n>0){

         int rem=n%10;
          sum+=rem*rem*rem;
          n=n/10;
      }
      return sum==original;
  }
}
