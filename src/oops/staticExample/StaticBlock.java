package oops.staticExample;

public class StaticBlock {
    static int a = 4;
    static int b;
    // this will only run first time when the first obj is create i.e. when
    //class  is loaded for the first time.
    static {
        System.out.println("i am in static block");
        b = a*5;
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

    }
}
