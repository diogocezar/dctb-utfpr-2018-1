package gerenciadordecontas;

import controllers.GerenciadorDeContas;
import javax.swing.JOptionPane;

/**
 * @author Samuel T. C. Santos
 *
 * @see {https://github.com/samueltcsantos/javaoo/tree/master/dev}
 *
 */
public class Main {

    private static final GerenciadorDeContas gerenciador = new GerenciadorDeContas();

    private static final int CRIAR_CONTA = 1;
    private static final int CONSULTA_SALDO = 2;
    private static final int CONSULTA_AGENCIA = 3;
    private static final int ALTERAR_TITULAR = 4;
    private static final int REMOVER_CONTA = 5;
    private static final int LISTAR_CONTAS = 6;
    private static final int SAIR_DO_PROGRAMA = 7;

    public static void main(String[] args) {

        Integer opcao = lerOpcaoDoMenu();

        while (opcao != SAIR_DO_PROGRAMA) {
            switch (opcao) {
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
                    JOptionPane.showMessageDialog(null, "[Programa será encerado!]");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao Invalida!");
                    break;
            }

            opcao = lerOpcaoDoMenu();
        }

    }

    private static void listarContas() {
        String todasAsContas = gerenciador.listarContas();
        if (todasAsContas.equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado!");
        } else {
            JOptionPane.showMessageDialog(null, todasAsContas);

        }
    }

    private static boolean removerConta() {

        int numeroDaConta = solicitarNumeroDaConta();
        if (numeroDaConta == -1) {
            return false;
        }
        if (!gerenciador.removerConta(numeroDaConta)) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado");
        }
        return true;
    }

    private static boolean alterarNomeDoTitular() {

        int numeroDaConta = solicitarNumeroDaConta();
        if (numeroDaConta == -1) {
            return false;
        }
        String novoNomeDoTitular = solicitarNomeDoTitular();
        if (gerenciador.atualizarNomeDoTitular(numeroDaConta, novoNomeDoTitular)) {
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
        }
        return true;
    }

    private static boolean consultarAgencia() {

        int numeroDaConta = solicitarNumeroDaConta();
        if (numeroDaConta == -1) {
            return false;
        }
        String nomeDaAgencia = gerenciador.pesquisarAgencia(numeroDaConta);
        if (!(nomeDaAgencia == null)) {
            JOptionPane.showMessageDialog(null, "Agencia : " + nomeDaAgencia);
        } else {
            JOptionPane.showMessageDialog(null, "Agencia não encontrada!");

        }
        return true;
    }

    private static boolean consultarSaldo() {

        int numeroDaConta = solicitarNumeroDaConta();
        if (numeroDaConta == -1) {
            return false;
        }
        double saldo = gerenciador.pesquisarSaldo(numeroDaConta);
        if (!(saldo == -1)) {
            JOptionPane.showMessageDialog(null, "Saldo : [" + saldo + "]");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
        }
        return true;
    }

    private static boolean criarNovaConta() {
        int numero = solicitarNumeroDaConta();
        if (numero == -1) {
            return false;
        }
        String agencia = solicitarNomeDaAgencia();
        String titular = solicitarNomeDoTitular();
        double saldo = solicitarSaldoDaConta();
        if (saldo == -1) {
            return false;
        }
        if (!gerenciador.criarConta(titular, agencia, numero, saldo)) {
            JOptionPane.showMessageDialog(null, "Conta já existente!");
        }
        return true;
    }

    private static Integer lerOpcaoDoMenu() {
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
        String strOpcao = JOptionPane.showInputDialog(null, menu);
        if (strOpcao == null) {
            System.exit(0);
        }
        try {
            return Integer.parseInt(strOpcao);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String solicitarNomeDoTitular() {
        String nome = JOptionPane.showInputDialog(null, "Nome do titular: ");
        return nome;
    }

    private static String solicitarNomeDaAgencia() {
        String agencia = JOptionPane.showInputDialog(null, "Nome da Agencia: ");
        return agencia;
    }

    private static Integer solicitarNumeroDaConta() {
        String strNumero = JOptionPane.showInputDialog(null, "Numero da Conta: ");
        if (strNumero == null) {
            return -1;
        }
        try {
            return Integer.parseInt(strNumero);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato de conta Invalido");
            return solicitarNumeroDaConta();
        }
    }

    private static double solicitarSaldoDaConta() {
        String strSaldo = JOptionPane.showInputDialog(null, "Saldo da Conta");
        if (strSaldo == null) {
            return -1;
        }
        try {
            return Double.parseDouble(strSaldo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Formato de saldo Invalido");
            return solicitarSaldoDaConta();
        }
    }
}
