package br.ufsc.ine5605.claviculario.Telas;

import br.ufsc.ine5605.claviculario.ControladorPrincipal;
import java.util.Scanner;

public class TelaInicial {
    private ControladorPrincipal ctrlPrincipal;
    private Scanner teclado;

    public TelaInicial(ControladorPrincipal ctrlPrincipal) {
        //super();
        this.ctrlPrincipal = ctrlPrincipal;
        teclado = new Scanner(System.in);
    }


    public void exibirTela(){
        int fazer = 0;

        do {
            System.out.println("\n===========Tela Inical============");
            System.out.println("1 - Tela de veiculos");
            System.out.println("2 - Tela de Funcionarios");
            System.out.println("3 - Tela Controlador de Emprestimos");
            System.out.println("4 - Tela de Eventos");
            System.out.println("0 - Encerrar Operecao");
            do {
                System.out.println("Qual opcao deseja: ");
                fazer = teclado.nextInt();
            } while(fazer < 0 || fazer > 4);

            switch(fazer){
                case 1: 
                    telaVeiculos();
                    break;
                case 2:
                    telaFuncionarios();
                    break;
                case 3:
                    telaControladorEmprestimos();
                    break;
                case 4:
                    telaEventos();
                    break;
                default:
                    System.out.println("Operacao encerrada");
            }
        }while(fazer != 0);

	
	
    }


	private void telaVeiculos() {
            ctrlPrincipal.telaVeiculo();
		
	}


	private void telaFuncionarios() {
            ctrlPrincipal.telaFuncionario();
		
	}


	private void telaControladorEmprestimos() {
            ctrlPrincipal.telaControladorEmprestimo();
		
	}

    private void telaEventos() {
        ctrlPrincipal.telaEvento();
    }
	
}
