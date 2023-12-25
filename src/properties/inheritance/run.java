package properties.inheritance;

public class run {

        public static void main(String[] args) {
            Box box=new Box(3,4,2);
            System.out.println(box.h+" "+box.w+" "+box.l);

            Boxweight box2=new Boxweight();
            System.out.println(box2.h+" "+box2.w+" "+box2.l);

        }


}
