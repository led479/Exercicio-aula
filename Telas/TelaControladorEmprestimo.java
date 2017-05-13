package br.ufsc.ine5605.claviculario.Telas;

import br.ufsc.ine5605.claviculario.CadastroFuncionarios.Funcionario;
import java.util.Scanner;

import br.ufsc.ine5605.claviculario.ControladorEmprestimo.ControladorEmprestimo;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoAcessoBloqueado;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoMatricula;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoVeiculo;

public class TelaControladorEmprestimo {
	
    private ControladorEmprestimo ctrlEmp;
    private Scanner teclado;

    public TelaControladorEmprestimo(ControladorEmprestimo ctrEmp) {
        super();
        teclado = new Scanner(System.in);
        this.ctrlEmp = ctrEmp;
    }
	
    public void exibirTela(){
        int fazer = 0;

        do {
            System.out.println("\n===========Controlador de Emprestimos============");
            System.out.println("1 - Liberar Chave");
            System.out.println("2 - Devolver Chave");
            /*System.out.println("3 - Ver Caracteristicas de Funcionario");
            System.out.println("4 - Alterar Cargo de Funcionario");
            System.out.println("5 - Verificar a Lista de Funcionarios");*/
            System.out.println("0 - Voltar para Tela Inicial");
            do {
                System.out.println("Qual opcao deseja: ");
                fazer = teclado.nextInt();
            } while(fazer < 0 || fazer > 5);

            switch(fazer){
                case 1: 
                    liberaChave();
                    break;
                case 2:
                    devolveChave();
                    break;
             /*   case 3:
                    descreveFuncionario();
                    break;
                case 4:
                    alteraCargo();
                    break;
                case 5:
                    exibeFuncionarios();
                    break;*/
                default:
                    System.out.println("Operacao encerrada");
            }
        }while(fazer != 0);

	
    }
    
    

	private void liberaChave() {
            System.out.println("Digite a matricula do funcionario que deseja usar o carro");
            int matricula = teclado.nextInt();
            Funcionario f = ctrlEmp.getCtrlPrincipal().getCadFuncionario().retornarFuncionario(matricula);
            if (f == null) {
                System.out.println("Matricula invalida");
                ctrlEmp.getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoMatricula());
            } else {
                if (f.getTentativasFalhas()>=3) {
                    System.out.println("Funcionario bloqueado ao acesso de veiculos");
                } else {
                    String[] listaVeiculosFuncionario = ctrlEmp.listaVeiculosFuncionario(matricula);
                    int tamanho = listaVeiculosFuncionario.length;
                    if (tamanho < 4) {
                        if (ctrlEmp.liberarChaveSePossuirUmVeiculo(matricula)) {
                            System.out.println("Chave liberada");
                        } else {
                            System.out.println("Nao foi possivel liberar a chave");
                        }
                    } else {
                        for (int i = 0; i < tamanho; i+=3) {
                            System.out.println("===================");
                            System.out.println("Veiculo: " + ctrlEmp.converteIndice2(i));
                            System.out.println("Placa: " + listaVeiculosFuncionario[i]);
                            System.out.println("Marca: " + listaVeiculosFuncionario[i+1]);
                            System.out.println("Modelo: " + listaVeiculosFuncionario[i+2]); 
                        }
                        System.out.println("===================");
                        System.out.println("Digite o numero do veiculo que deseja: ");
                        int indice = teclado.nextInt();
                        if (indice > tamanho/3) {
                            System.out.println("Voce nao possue acesso ao veiculo.");
                            f.incementaTentativas();
                            ctrlEmp.getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoVeiculo(matricula));
                            if (f.getTentativasFalhas() == 3) {
                                System.out.println("Acesso bloqueado aos veiculos");
                                ctrlEmp.getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoAcessoBloqueado(matricula));
                            }
                        } else {
                            if (ctrlEmp.liberarChaveSePossuirMaisDeUmVeiculo(matricula, indice)) {
                                System.out.println("Chave liberada");
                            } else {
                                System.out.println("Nao foi possivel liberar a chave");
                            }
                        }
                    }
                }
            }
            

            
	}

	private void devolveChave() {
            System.out.println("Digite a matricula do funcionario que vai devolver o carro");
            int matricula = teclado.nextInt();
            if (ctrlEmp.getCtrlPrincipal().getCadFuncionario().retornarFuncionario(matricula) == null) {
                System.out.println("Matricula Invalida");
            } else {
                System.out.println("Digite a placa do veiculo devolvido: ");
                String placa = teclado.next();
                System.out.println("Digite a nova quilometragem: ");
                double quilometragem = teclado.nextDouble();

                if(ctrlEmp.devolverChave(matricula, placa, quilometragem)){
                        System.out.println("Veiculo devolvido com sucesso");
                }else{
                        System.out.println("Nao foi possivel cadastrar a devolucao, tente novamente");
                }
            }
	
	}	
}

	

