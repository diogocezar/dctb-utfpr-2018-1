interface A{
   public void aaa();
}
interface B{
   public int aaa();
}
class Central implements A,B{
   public void aaa(){
       // isso está errado!
   }
   public int aaa(){
       // isso está errado!
   }
   public static void main(String args[]){
       // ...
   }
}