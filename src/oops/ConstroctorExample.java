package oops;
class Teacher{
    int rno;
    String name;
    double salary;
    //constructor is special type of function which
    Teacher(int rno, String name, double salary){
        this.rno = rno;
        this.name = name;
        this.salary = salary;
    }
    Teacher(){
        //this is how we call a constructor from another constructor
        this(21, "rahul", 22.6);
    }

    void changeName(String chang){
        name = chang;
    }
    void greeting(){
        System.out.println(name);
    }

}
public class ConstroctorExample {
    public static void main(String[] args) {
        Teacher tc = new Teacher(15,"anand", 22.5);
        Teacher rahul = new Teacher(25,"raj",33.6);
        Teacher and = new Teacher();
        System.out.println(and.name);

        Teacher one  = new Teacher();
        Teacher two = one;
        one.name = "something";
        System.out.println(two.name);
        rahul.changeName("rajwade");
        rahul.greeting();

    }
}
