package oops.singleton;

public class Singleton {
    //it is just a class which you can create only one object
    private Singleton(){

    }
    private static Singleton instance;

    static public Singleton getInstance(){
        //check whether 1 obj only is created or not
        if(instance == null){
            instance = new Singleton();
        }
        return  instance;
    }

    public static void main(String[] args) {

    }
}
