package oops.staticExample;
//outer class can't be static. only inner class can be static
public class InnerClasses {
    static class Test{
        String name;
        public Test(String name){
            this.name = name;
        }
        @Override
        public String toString(){
            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("kunal");
        Test b = new Test("anand");
        System.out.println(a.name);
        System.out.println(b.name);
        System.out.println(a);
    }
}
