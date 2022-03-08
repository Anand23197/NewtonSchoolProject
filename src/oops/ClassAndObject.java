package oops;
//class is name group of methods and properties
//class is logical construct
class Student{
    int rno;
    String name;
    float marks = 20.5f;
}
public class ClassAndObject {
    public static void main(String[] args) {
        //this std is just the refrence of class Student type
        //std is available in stack memory
        Student std;
        //object is physical reality i.e. occupying space in memory
        //new keyword dynamically allocates memory & return refrence variable to it
        //object stored in heap memory
        //in below example Student student1 allocate memory in compile time
        //after equal new Student() will allocate memory in run time
        Student student1 = new Student();
        student1.rno = 11;
        student1.marks = 2.55f;
        student1.name = "anand";
        System.out.println(student1.name + " " + student1.rno + " " + student1.marks);
    }
}
