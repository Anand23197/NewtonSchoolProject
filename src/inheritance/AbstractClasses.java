package inheritance;
//if class is abstract we have to make at least
//one method as abstract
abstract class A{
   abstract void call(int a);

}
// we can either make child class is abstract class
// or we can define the method of parent class
abstract class B extends A{
    void call(int a){
        System.out.println("value of a"+ a);
    }
}
class C extends A{
    void  call(int a){

    }
}
public class AbstractClasses {
    public static void main(String[] args) {

    }
}
