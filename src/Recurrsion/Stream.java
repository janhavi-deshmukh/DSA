package Recurrsion;

public class Stream {

    public static void main(String[] args) {

        //skip("","baccad");
        //System.out.print(skip2("baccad"));
        System.out.print(skipAppnotApple("baccapplefgappulsj"));

    }

    public static void skip(String p,String up){

        if(up.isEmpty()){
            System.out.print(p);
            return;
        }

        char ch=up.charAt(0);
        if(ch=='a'){
            skip(p,up.substring(1));
        }else{
            skip(p+ch,up.substring(1));
        }
    }

    public static String skip2(String up){

        if(up.isEmpty()){
            return up;
        }

        char ch=up.charAt(0);
        if(ch=='a'){
            return skip2(up.substring(1));
        }else{
            return ch+skip2(up.substring(1));
        }


    }

    public static String skipApple(String up){

        if(up.isEmpty()){
            return "";
        }

        char ch=up.charAt(0);
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return ch+skipApple(up.substring(1));
        }
    }

    public static String skipAppnotApple(String up){

        if(up.isEmpty()){
            return "";
        }

        char ch=up.charAt(0);
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipAppnotApple(up.substring(3));
        }else{
            return ch+skipAppnotApple(up.substring(1));
        }
    }
}
