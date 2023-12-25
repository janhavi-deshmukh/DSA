
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Grades {

//    Marks        Grade
//91-100         AA
//81-90          AB
//71-80          BB
//61-70          BC
//51-60          CD
//41-50          DD
//<=40          Fail
    static void displayGrades(int num){
        int orignal=num;

        if(orignal>91 && orignal<100){
            System.out.print("Grade AA");
        }
        if(orignal >81 && orignal<90){
            System.out.print("Grade AB");
        }
        if(orignal >71 && orignal<80){
            System.out.print("Grade BB");
        }
        if(orignal >61 && orignal<70){
            System.out.print("Grade BC");
        }
        if(orignal >51 && orignal<60){
            System.out.print("Grade CD");
        }
        if(orignal >41 && orignal<50){
            System.out.print("Grade DD");
        }
        if(orignal<=40)
            System.out.print("Fail!");

    }

    static int Factorial(int num){
        int orignal=num;
        int product=1;
        for (int i = 1; i <=orignal ; i++) {
            product*=i;
        }
        return product;
    }

    static boolean isPalindrome(int num){
        int orignal=num;
        int reverse=0;

        while(orignal>0){
             reverse=(reverse*10)+(orignal%10);
             orignal/=10;
        }

        return num==reverse;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

//        displayGrades(num);
//
//        int ans=Factorial(num);
//        System.out.print(ans);

        System.out.print(isPalindrome(num));


    }
}
