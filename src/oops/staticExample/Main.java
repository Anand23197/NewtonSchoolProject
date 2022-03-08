package oops.staticExample;

public class Main {
    //this is non static method so we can't access in static method
    //so in main function because it is static so we can't call geeting method
    //something which is non static is belongs to objects,
    void geeting(){
        System.out.println("hello world");
        //static method can present in non static method but opposite is not possible
        fun();
    }
    static void fun(){
     /*
        geeting();
        you can't use this because it requires an instance but the function we are
        using it does not depends on instance.
        means: geeting function is non static and fun function is static so we can't
        acees non static method in static method

      */
        //for access non static method we need refrence of their instances in a static context;
        Main obj = new Main();
        obj.geeting();
    }
    public static void main(String[] args) {
        Human anand = new Human(25, "raja",20000,true);
        Human raja = new Human(26,"anand",25000,true);
        Human rani = new Human(36,"rani",25000,true);

        System.out.println(Human.population);

        System.out.println(Human.population);
        System.out.println(Human.population);
        /*
        geeting();
         we can't access because it is non static method.

         */
    }
}
