package app;
import javax.swing.JOptionPane;
import controllers.GerenciadorDeConta;

/**
 * @author Samuel T. C. Santos
 * 
 * @see {https://github.com/samueltcsantos/javaoo/tree/master/dev}
 * 
 */
public class Main {

	private static GerenciadorDeConta gerenciador = new GerenciadorDeConta();

	private static final int CRIAR_CONTA = 1;
	private static final int CONSULTA_SALDO = 2;
	private static final int CONSULTA_AGENCIA = 3;
	private static final int ALTERAR_TITULAR = 4;
	private static final int REMOVER_CONTA = 5;
	private static final int LISTAR_CONTAS = 6;
	private static final int SAIR_DO_PROGRAMA = 7;
	
	public static void main(String[] args) {
		
		Integer opcao = lerOpcaoDoMenu();
		
		while(opcao != SAIR_DO_PROGRAMA){
			switch(opcao){
			case CRIAR_CONTA:
				criarNovaConta();
				break;
			case CONSULTA_SALDO:
				consultarSaldo();
				break;
			case CONSULTA_AGENCIA:
				consultarAgencia();
				break;
			case ALTERAR_TITULAR:
				alterarNomeDoTitular();
				break;
			case REMOVER_CONTA:
				removerConta();
				break;
			case LISTAR_CONTAS:
				listarContas();
				break;
			case SAIR_DO_PROGRAMA:
				JOptionPane.showMessageDialog(null,"[Programa será encerado!]");
				break;
			 default:
				 JOptionPane.showMessageDialog(null,"Opcao Invalida!");
				 break;
			}
			
			opcao = lerOpcaoDoMenu();
		}
		
	}
	
	private static void listarContas(){
		String todasAsContas = gerenciador.listarContas();
		JOptionPane.showMessageDialog(null,todasAsContas);
	}
	
	private static void removerConta(){
		try {
			int numeroDaConta = solicitarNumeroDaConta();
			gerenciador.removerConta(numeroDaConta);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	private static void alterarNomeDoTitular(){
		try {
			int numeroDaConta = solicitarNumeroDaConta();
			String novoNomeDoTitular = solicitarNomeDoTitular();
			gerenciador.atualizarNomeDoTitular(numeroDaConta, novoNomeDoTitular);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	private static void consultarAgencia(){
		try {
			int numeroDaConta = solicitarNumeroDaConta();
			String nomeDaAgencia = gerenciador.pesquisarAgencia(numeroDaConta);
			JOptionPane.showMessageDialog(null,"Agencia : " + nomeDaAgencia);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	private static void consultarSaldo(){
		try {
			int numeroDaConta = solicitarNumeroDaConta();
			double saldo = gerenciador.pesquisarSaldo(numeroDaConta);
			JOptionPane.showMessageDialog(null,"Saldo : [" + saldo + "]");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	private static void criarNovaConta(){
		int numero = solicitarNumeroDaConta();
		String agencia = solicitarNomeDaAgencia();
		String titular = solicitarNomeDoTitular();
		double saldo = solicitarSaldoDaConta();
		gerenciador.criarConta(titular, agencia, numero, saldo);
	}
	private static Integer lerOpcaoDoMenu(){
		String menu = "[-------- Menu ---------]";
		menu += "\n[1] - Criar Conta";
		menu += "\n[2] - Consultar Saldo";
		menu += "\n[3] - Consultar Agencia";
		menu += "\n[4] - Alterar Titular";
		menu += "\n[5] - Remover Conta";
		menu += "\n[6] - Listar Contas";
		menu += "\n[7] - Sair";
		menu += "\n[ ------------------------- ]";
		menu += "\nInforme sua opcao: ";
		String strOpcao = JOptionPane.showInputDialog(null,menu);
		return Integer.parseInt(strOpcao);
	}
	private static String solicitarNomeDoTitular(){
		String nome = JOptionPane.showInputDialog(null, "Nome do titular: ");
		return nome;
	}
	private static String solicitarNomeDaAgencia(){
		String agencia = JOptionPane.showInputDialog(null, "Nome da Agencia: ");
		return agencia;
	}
	private static Integer solicitarNumeroDaConta(){
		String strNumero = JOptionPane.showInputDialog(null, "Numero da Conta: ");
		
		return Integer.parseInt(strNumero);
	}
	private static double solicitarSaldoDaConta(){
		String strSaldo = JOptionPane.showInputDialog(null, "Saldo da Conta");
		return Double.parseDouble(strSaldo);
	}
}