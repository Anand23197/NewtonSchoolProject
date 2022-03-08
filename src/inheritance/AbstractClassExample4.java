package inheritance;
abstract  class  H{
    abstract void add();
}
class I extends H{
    void add(){
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;

        System.out.println("sum in class"+ sum);
    }
}
class  J extends H{
    void add(){
        int num1 = 20;
        int num2 = 30;
        int sum = num1 + num2;

        System.out.println("sum in class"+ sum);
    }
}
public class AbstractClassExample4 {
    J j = new J();


}
