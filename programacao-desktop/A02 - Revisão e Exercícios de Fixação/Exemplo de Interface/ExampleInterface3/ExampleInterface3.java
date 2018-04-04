interface A{
   public void aaa();
}
interface B{
   public void aaa();
}
class ExampleInterface3 implements A,B{
   public void aaa(){
        System.out.println("aaa");
   }
   public static void main(String args[]){
        B obj = new ExampleInterface3();
        obj.aaa();
    }
}