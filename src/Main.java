import java.util.Scanner;
import java.lang.Math;

public class Main {


    public static void main(String[] arg) {
//
//        System.out.print("enter a number");
//        Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
//
//        int sum=0;
//        for(int i=1;i<num;i++){
//
//            if(num%i==0){
//                sum+=i;
//            }
//        }
//
//        if(sum==num)
//            System.out.print("perfect");
//        else{
//            System.out.print("not");
//        }

        int count=0;
        for(int i=1;i<=31;i++){
            if(i%2==0)
                count++;
        }

        System.out.print(count);


    }
}
