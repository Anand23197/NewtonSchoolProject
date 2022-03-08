package oops.staticExample;

public class Human {
    int age;
    String name;
    int salary;
    boolean married;
    //when a member is declared static it can be accessed before any of the object
    // of class is being created and without refrencing of the object
    static int population;
     public Human(int age, String name, int salary, boolean married){
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        //population is static variable that's way it is free from object. so we acceess it waya
         //class name directly we don't need this.population because this is an object.
        Human.population += 1;
    }
}
