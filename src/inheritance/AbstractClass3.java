package inheritance;
abstract  class E{
    abstract  void call();
    abstract  void callThisToo();

    void concrete(){
        System.out.println("this is a concrete method");
    }
}
abstract class  F extends E{
    @Override
    void call() {

    }
}
class  G extends  F{
    @Override
    void call() {
        System.out.println("in class G");
    }

    @Override
    void callThisToo() {
        System.out.println(" method of G");
    }
}
public class AbstractClass3 {
    public static void main(String[] args) {
        G g = new G();
        g.call();
        g.callThisToo();
    }
}
