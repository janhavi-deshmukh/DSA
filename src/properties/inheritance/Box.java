package properties.inheritance;

public class Box {

    double l;
    double h;
    double w;

    Box(){
        this.h=-1;
        this.w=-1;
        this.l=-1;
    }

    Box(double side){
        this.h=side;
        this.w=side;
        this.l=side;
    }

    Box(double l,double h,double w){
        this.h=h;
        this.w=w;
        this.l=l;
    }

    Box(Box old){
        this.w=old.w;
        this.h=old.h;
        this.l=old.l;
    }

    public void info(){
        System.out.println("running Box");
    }

}
