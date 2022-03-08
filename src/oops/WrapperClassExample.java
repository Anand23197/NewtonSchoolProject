package oops;

import javax.print.attribute.standard.Sides;

class Finali{
    //if we are using final keyword in data type declaration we can't change its value
    //final keywords only works with premitive data type not with instance variable
    //with final keyword we need to initialize the variable otherwise it is error
    //with non premitive data type final keyword will work eg. final Anand av = new Anand();

    final int ANAND = 10;
    String name;
    public Finali(String name){
        this.name = name;
    }

}
class FinalizeExample{
    String name;

 FinalizeExample(String name){
        this.name = name;
 }
    //finalize is same like distructor in c++.
    //it removes garbage because at one time only object can refer to one reference variable
    @Override
    protected void finalize() throws Throwable {
        System.out.println("object is destroyed");
    }
}
public class WrapperClassExample {
    public static void main(String[] args) {
        //wrapper class converts primitive data type to objects
        Integer c = 50;
        Integer d = 60;
        swapp(c,d);

        int a = 10;
        int b = 20;
        //here actual value will not change
        swap(a,b);
        System.out.println(a + " " + b);
        //with non premitive data type final keyword will work eg. final Anand av = new Anand();
       final Finali fn = new Finali("anand vishwakarma");
       fn.name = "vishwakarma";
       //when a non premitive is final we can't assign the value
      /* fn = new Finali("raja"); */

     /*   FinalizeExample f;
        for(int i = 0;i<1000000000; i++){
            f = new FinalizeExample("random name");
        }

      */
    }

    //swaping will not work here because whatever changing happening only in this
    //method is happennig and there is no any kind of concept of pass by refrence
    //in java. only call by value supported by java
    static  void swap(int a , int b){
        int temp = a;
        a = b;
        b = temp;
    }
    //here swapping will also not work althouth we are passing by refrence of Integer object
    //because wrapper class are final that's way we can't change its value
    static void swapp(Integer c, Integer d){
        Integer temp = c;
        c = d;
        d = temp;
    }
}
