package br.ufsc.ine5605.claviculario.Telas;

import br.ufsc.ine5605.claviculario.CadastroFuncionarios.TipoFuncionario;
import br.ufsc.ine5605.claviculario.CadastroFuncionarios.Funcionario;
import br.ufsc.ine5605.claviculario.CadastroFuncionarios.CadastroFuncionario;
import br.ufsc.ine5605.claviculario.CadastroVeiculos.Veiculo;
import java.util.ArrayList;
import java.util.Scanner;

public class TelaFuncionario {
    private final Scanner teclado;
    private final CadastroFuncionario cadFuncionario;
	
    public TelaFuncionario(CadastroFuncionario cadFuncionario) {
        super();
        teclado = new Scanner(System.in);
        this.cadFuncionario = cadFuncionario;
    }
	
    public void exibirTela(){
        int fazer = 0;

        do {
            System.out.println("\n===========Tela de Funcionarios============");
            System.out.println("1 - Cadastrar Novo Funcionario");
            System.out.println("2 - Remover Funcionario Cadastrado");
            System.out.println("3 - Ver Caracteristicas de Funcionario");
            System.out.println("4 - Alterar Cargo de Funcionario");
            System.out.println("5 - Verificar a Lista de Funcionarios");
            System.out.println("6 - Remover Veiculo de Todos os Funcionarios");
            System.out.println("0 - Encerrar Operecao");
            do {
                System.out.println("Qual opcao deseja: ");
                fazer = teclado.nextInt();
            } while(fazer < 0 || fazer > 6);

            switch(fazer){
                case 1: 
                    cadastraFuncionario();
                    break;
                case 2:
                    removeFuncionario();
                    break;
                case 3:
                    descreveFuncionario();
                    break;
                case 4:
                    alteraCargo();
                    break;
                case 5:
                    exibeFuncionarios();
                    break;
                case 6:
                    removeVeiculoDosFuncionarios();
                    break;
                default:
                    System.out.println("Operacao encerrada");
            }
        }while(fazer != 0);

	
	
}

	

    private void cadastraFuncionario() {

        System.out.println("Digite o numero de matricula do novo funcionario:");
        int matricula = teclado.nextInt();

        System.out.println("Digite o nome do novo funcionario:");
        String nome = teclado.next();

        System.out.println("Escolha um tipo de funcionario:");
        TipoFuncionario tipoFuncionario = escolherTipoFuncionario();

        System.out.println("Digite a data de nascimento do novo funcionario:");
        String dataNascimento = teclado.next();

        System.out.println("Digite o telefone do novo funcionario");
        int telefone = teclado.nextInt();
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        String[] listaVeiculos = cadFuncionario.listaVeiculos();
        int tamanho = listaVeiculos.length;
        
        if (tipoFuncionario == TipoFuncionario.DIRETORIA) {
            //adiciona todos
            if (tamanho == 0) {
                System.out.println("Lista de veiculos vazia, nenhum veiculo adicionado");
            } else {
                for (int i = 0; i < tamanho; i+=3) {
                    veiculos.add(cadFuncionario.retornarVeiculo(listaVeiculos[i]));
                }
                System.out.println("Permissao a todos os veiculos concedida");
            }
            
        } else { 
            //exibe todos os veiculos
            for (int i = 0; i < tamanho; i+=3) {
                System.out.println("===================");
                System.out.println("Placa: " + listaVeiculos[i]);
                System.out.println("Marca: " + listaVeiculos[i+1]);
                System.out.println("Modelo: " + listaVeiculos[i+2]); 
            }
            System.out.println("===================");
            
            System.out.println("Digite a placa dos veiculos aos quais o funcionario tera acesso: (digite 0 para parar)");
            int controle = 1;
            
            while (controle != 0) {
                System.out.println("Placa: ");
                String placa = teclado.next();
                if (placa.equals("0")) {
                    controle = 0;
                }
                if (cadFuncionario.retornarVeiculo(placa) == null) {
                    System.out.println("Nao foi possivel adicionar o veiculo");
                } else {
                    veiculos.add(cadFuncionario.retornarVeiculo(placa));
                }
                
            }
        }
        
        
        if(cadFuncionario.addFuncionario(matricula, nome, tipoFuncionario, dataNascimento, telefone, veiculos)){
            System.out.println("Funcionario adicionado com sucesso!");
        }else{
            System.out.println("Nao foi possivel cadastrar o funcionario");
        }

    }


    private void removeFuncionario() {
        if(cadFuncionario.removeFuncionario(pedeMatricula())){
            System.out.println("Funcionario removido com sucesso");
        }else{
            System.out.println("Nao foi possivel remover o funcionario");
        }

    }

    private void descreveFuncionario() {
        int matricula = pedeMatricula();
        if(cadFuncionario.procurarFuncionario(matricula)){
            Funcionario f = cadFuncionario.retornarFuncionario(matricula);
            System.out.println("Numero de Matricula: " + f.getNumeroMatricula());
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getTipoFuncionario());
            System.out.println("Data de Nascimento: " + f.getDataNascimento());
            System.out.println("Telefone: " + f.getTelefone());
            System.out.println("Veiculos aos quais o funcionario possui acesso: ");
            String[] listaVeiculos = f.listaVeiculos();
            int tamanho = listaVeiculos.length;
            for (int i = 0; i < tamanho; i+=3) {
                System.out.println("===================");
                System.out.println("Placa: " + listaVeiculos[i]);
                System.out.println("Marca: " + listaVeiculos[i+1]);
                System.out.println("Modelo: " + listaVeiculos[i+2]); 
            }
            System.out.println("===================");
            
            } else{
            System.out.println("Nao foi possivel encontrar este funcionario");
            }

        }

    private void alteraCargo() {
        int matricula = pedeMatricula();

        if(cadFuncionario.procurarFuncionario(matricula)){
            Funcionario f = cadFuncionario.retornarFuncionario(matricula);
            System.out.println("Escolha o novo cargo do funcionario:");
            TipoFuncionario tipoFuncionario = escolherTipoFuncionario();
            f.setTipoFuncionario(tipoFuncionario);
            System.out.println("Cargo alterado com sucesso");
        }else{
            System.out.println("Funcionario nao encontrado");
        }

    }

    private void exibeFuncionarios() {
        String[] listaFuncionarios = cadFuncionario.listaFuncionarios();
        int tamanho = listaFuncionarios.length;
        for (int i = 0; i < tamanho; i+=3) {
            System.out.println("===================");
            System.out.println("Matricula: " + listaFuncionarios[i]);
            System.out.println("Nome: " + listaFuncionarios[i+1]); 
            System.out.println("Cargo: " + listaFuncionarios[i+2]);
        }
        System.out.println("===================");

    }

    private int pedeMatricula(){
        System.out.println("Digite a matricula do funcionario que procura:");
        int matricula = teclado.nextInt();
        return matricula;
    }

    private TipoFuncionario escolherTipoFuncionario(){
        int tipo = 0;
        TipoFuncionario tipoFuncionario = null;
        do{
            System.out.println("1 - DIRETORIA\n"
                                             + "2 - GERENCIA\n"
                                             + "3 - OUTRO");

             tipo = teclado.nextInt();
        }while (tipo < 0 || tipo >3);

        switch (tipo){
            case 1:
                tipoFuncionario = TipoFuncionario.DIRETORIA;
                break;
            case 2:
                tipoFuncionario = TipoFuncionario.GERENCIA;
                break;
            case 3:
                tipoFuncionario = TipoFuncionario.OUTRO;
        }

        return tipoFuncionario;
    }

    private void removeVeiculoDosFuncionarios() {
        System.out.println("Insira a placa do veiculo que deseja remover: ");
        String placa = teclado.next();
        if (cadFuncionario.removeVeiculoDosFuncionarios(placa)) {
            System.out.println("Veiculo removido com sucesso");
        } else {
            System.out.println("Nao foi possivel remover o veiculo");
        }
        
    }
}
	