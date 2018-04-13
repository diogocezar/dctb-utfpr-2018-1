interface MyInterface{
   public void method1();
   public void method2();
}
class ExampleInterface1 implements MyInterface{
    public void method1(){
        System.out.println("implementation of method1");
    }
    public void method2(){
        System.out.println("implementation of method2");
    }
    public static void main(String arg[]){
        MyInterface obj = new ExampleInterface1();
        obj.method1();
    }
}