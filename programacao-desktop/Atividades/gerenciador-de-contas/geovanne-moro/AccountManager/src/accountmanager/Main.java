package accountmanager;
import javax.swing.JOptionPane;
import controllers.accountManager;

/**
 * @author Samuel T. C. Santos
 * 
 * @see {https://github.com/samueltcsantos/javaoo/tree/master/dev}
 * 
 */
public class Main {

	private static accountManager manager = new accountManager();

	private static final int createAccount = 1;
	private static final int consultBalance = 2;
	private static final int consultAgency = 3;
	private static final int chanceHolder = 4;
	private static final int removeAccount = 5;
	private static final int listAccounts = 6;
	private static final int exit = 7;
	
	public static void main(String[] args) {
		
		Integer opcao = readOptionMenu();
		
		while(opcao != exit){
			switch(opcao){
			case createAccount:
				createNewAccount();
				break;
			case consultBalance:
				consultBalance();
				break;
			case consultAgency:
				consultAgency();
				break;
			case chanceHolder:
				chanceNameHolder();
				break;
			case removeAccount:
				removeAccount();
				break;
			case listAccounts:
				listAccounts();
				break;
			case exit:
				JOptionPane.showMessageDialog(null,"[Programa será encerado!]");
				break;
			 default:
				 JOptionPane.showMessageDialog(null,"Opcao Invalida!");
				 break;
			}
			
			opcao = readOptionMenu();
		}
		
	}
        
        private static void createNewAccount(){
		int number = requestNumberAccount();
		String agency = resquestNameAgency();
		String holder = resquestNameHolder();
		double balance = resquestBalanceAccount();
		manager.createAccount(holder, agency, number, balance);
	}
        
        private static void consultBalance(){
		try {
			int numberAccount = requestNumberAccount();
			double balance = manager.searchBalance(numberAccount);
			JOptionPane.showMessageDialog(null,"Saldo : [" + balance + "]");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
        
        private static void consultAgency(){
		try {
			int numberAccount = requestNumberAccount();
			String nameAgency = manager.searchAgency(numberAccount);
			JOptionPane.showMessageDialog(null,"Agencia : " + nameAgency);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
        
        private static void chanceNameHolder(){
		try {
			int numberAccount = requestNumberAccount();
			String newNameHolder = resquestNameHolder();
			manager.updateNameHolder(numberAccount, newNameHolder);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
        
        private static void removeAccount(){
		try {
			int numberAccount = requestNumberAccount();
			manager.removeAccount(numberAccount);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	private static void listAccounts(){
		String allAccount = manager.listAccount();
		JOptionPane.showMessageDialog(null,allAccount);
	}
	
	private static Integer readOptionMenu(){
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
		String strOption = JOptionPane.showInputDialog(null,menu);
		return Integer.parseInt(strOption);
	}
        
	private static String resquestNameHolder(){
		String name = JOptionPane.showInputDialog(null, "Nome do titular: ");
		return name;
	}
        
	private static String resquestNameAgency(){
		String agency = JOptionPane.showInputDialog(null, "Nome da Agencia: ");
		return agency;
	}
        
	private static Integer requestNumberAccount(){
		String strNumber = JOptionPane.showInputDialog(null, "Numero da Conta: ");
		
		return Integer.parseInt(strNumber);
	}
        
	private static double resquestBalanceAccount(){
		String strBalance = JOptionPane.showInputDialog(null, "Saldo da Conta");
		return Double.parseDouble(strBalance);
	}
}