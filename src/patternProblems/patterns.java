package patternProblems;

public class patterns {

    public static void main(String[] args) {

//        pattern1(4);
//        pattern2(4);
//        pattern3(4);
//        pattern4(4);
//        pattern5(5);
//        pattern28(10);

         uptraingle(3,0);
    }

    public static void pattern1(int n){
        for(int row=1;row<=n;row++){
            for(int col=1;col<=n;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){
        for(int row=1;row<=n;row++){
            for(int col=1;col<=row;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        System.out.println();
        for(int row=1;row<=n;row++){
            for(int col=n-(row-1);col>=1;col--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n){
        System.out.println();
        for(int row=1;row<=n;row++){
            for(int col=1;col<=row;col++){
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    public static void pattern5(int n){
        System.out.println();
        for(int row=1;row<2*n;row++){

            int col=row>n ? 2*n-row:row;
            for( int c=col;c>=1;c--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern28(int n){
        System.out.println();
        for(int row=1;row<2*n;row++){

            int col=row>n ? 2*n-row:row;

            int spaces=n-col;
            for(int i=1;i<=spaces;i++){
                System.out.print(" ");
            }
            for( int c=col;c>=1;c--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void uptraingle(int r,int c){
        if(r==0){
            return;
        }

        if(c<r){
            uptraingle(r,c+1);
            System.out.print("*");
        }else{
            uptraingle(r-1,0);
            System.out.println();
        }
    }


}
