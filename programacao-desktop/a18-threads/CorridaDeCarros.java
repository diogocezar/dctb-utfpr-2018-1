class CarroCorrendoThread extends Thread {
   String nome;
   int distanciaCorrida = 0;
   int distanciaTotalCorrida;
   static int colocacao = 0;
   public CarroCorrendoThread(String nome, int distanciaTotalCorrida){
      super(nome);
      this.distanciaTotalCorrida = distanciaTotalCorrida;
      this.nome = nome;
   }
   public void carroImprimindoSituacao(){
      System.out.println("O " + nome +  " já percorreu " + distanciaCorrida + "/" + distanciaTotalCorrida + "km");
   }
   public void carroCorrendo(){
      distanciaCorrida += (int) (Math.random() * 8);
      if (distanciaCorrida > distanciaTotalCorrida) {
         distanciaCorrida = distanciaTotalCorrida;
      }
   }
   public void carroPitStop(){
      System.out.println(nome + " parou no PitStop");
      yield();
   }
   public void colocacaoCarro(){
      colocacao++;
      System.out.println(nome + " foi o " + colocacao + " colocado");
   }
   public void run (){
      while (distanciaCorrida < distanciaTotalCorrida) {
         carroCorrendo();
         carroImprimindoSituacao();
         //carroPitStop();
      }
      colocacaoCarro();
   }
}
public class CorridaDeCarros {
   final static int NUM_CARROS = 5;
   final static int DISTANCIA = 50;
   public static void main (String[] args) {
   System.out.println("Começou a corrida!");
   for (int i = 1; i <= NUM_CARROS; i++)
      new CarroCorrendoThread("CARRO_" + i, DISTANCIA).start();
   }
}