package StringProblems;

public class palindromeFormation {

    public static boolean checkPalindromeFormation(String a, String b) {

        String aprefix="";
        String asuffix="";
        String bprefix="";
        String bsuffix="";

        for(int i=0;i<a.length();i++){

            if(i==0){
                aprefix="";
                asuffix=a.substring(0,a.length());

                bprefix="";
                bsuffix=b.substring(0,b.length());
            }
            else{

                aprefix+=a.substring(0,i);
                asuffix+=a.substring(i,a.length());

                bprefix+=a.substring(0,i);
                bsuffix+=a.substring(i,a.length());
            }


            if(isPalindrome(aprefix+bsuffix) || isPalindrome(bprefix+asuffix)){
                return true;
            }

        }

        return false;
    }

    public static boolean isPalindrome(String s){


        int end=s.length()-1;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(end)){
                return false;
            }
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        String a="ulacfd";
        String b="jizalu";

        System.out.print(checkPalindromeFormation(a,b));
    }
}
