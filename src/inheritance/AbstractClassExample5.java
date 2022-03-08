package inheritance;
abstract  class  K{
    abstract  void test();

    void display(){
        System.out.println("In display()");
    }
}
class  L extends  K{
    @Override
    void test() {

    }
}
public class AbstractClassExample5 {
    L l = new L();
}
