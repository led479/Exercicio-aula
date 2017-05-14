package br.ufsc.ine5605.claviculario.Telas;

import br.ufsc.ine5605.claviculario.CadastroVeiculos.CadastroVeiculo;
import java.util.Scanner;

public class TelaVeiculo {
    private final Scanner teclado;
    private final CadastroVeiculo cadVeiculo;

    public TelaVeiculo(CadastroVeiculo cadVeiculo){
            teclado = new Scanner(System.in);
            this.cadVeiculo = cadVeiculo;
    }

    public void exibirTela(){
        int fazer = 0;

        do {
            System.out.println("\n===========Tela de Veiculos============");
            System.out.println("1 - Cadastrar Novo Veiculo");
            System.out.println("2 - Remover Veiculo Cadastrado");
            System.out.println("3 - Ver Caracteristicas de Veiculo");
            System.out.println("4 - Alterar Quilometragem de Veiculo");
            System.out.println("5 - Verificar a Lista dos Veiculos");
            System.out.println("0 - Encerrar Operecao");
            do {
                System.out.println("Qual opcao deseja: ");
                fazer = teclado.nextInt();
            } while(fazer < 0 || fazer > 5);

            switch(fazer){
                case 1: 
                    cadastraVeiculo();
                    break;
                case 2:
                    removeVeiculo();
                    break;
                case 3:
                    descreveVeiculo();
                    break;
                case 4:
                    alteraQuilometragem();
                    break;
                case 5:
                    exibeVeiculos();
                    break;
                default:
                    System.out.println("Operacao encerrada");
            }
        }while(fazer != 0);

    }

    private void cadastraVeiculo() {
        System.out.println("Digite a placa do novo veiculo:");
        String placa = teclado.next();

        System.out.println("Digite o modelo do novo veiculo:");
        String modelo = teclado.next();

        System.out.println("Digite a marca do novo veiculo:");
        String marca = teclado.next();

        System.out.println("Digite o ano do novo veiculo");
        int ano = teclado.nextInt();

        System.out.println("Digite a quilometragem atual do novo veiculo:");
        double quilometragem = teclado.nextDouble();

        if(cadVeiculo.addVeiculo2(placa, modelo, marca, ano, quilometragem)){
            System.out.println("Veiculo adicionado com sucesso!");
        }else{
            System.out.println("Nao foi possivel cadastrar o veiculo");
        }
    }

    private void removeVeiculo() {
        if(cadVeiculo.removeVeiculo2(pedePlaca())){
            System.out.println("Veiculo removido com sucesso!");
        }else{
            System.out.println("Nao foi possivel remover o veiculo (talvez algum funcionario tenha este veiculo cadastrado)");
        }

    }

    private void descreveVeiculo() {
        String placa = pedePlaca();

        if(cadVeiculo.procurarVeiculo(placa)){
            System.out.println("Placa: " + cadVeiculo.retornarVeiculo(placa).getPlaca());
            System.out.println("Modelo: " + cadVeiculo.retornarVeiculo(placa).getModelo());
            System.out.println("Marca: " + cadVeiculo.retornarVeiculo(placa).getMarca());
            System.out.println("Ano: " + cadVeiculo.retornarVeiculo(placa).getAno());
            System.out.println("Quilometragem Atual: " + cadVeiculo.retornarVeiculo(placa).getQuilometragemAtual());
            if(cadVeiculo.retornarVeiculo(placa).isDisponibilidade()){
                    System.out.println("Disponivel: Sim");
            }else{
                    System.out.println("Disponivel: Nao");
            }
        }else{
            System.out.println("Veiculo nao encontrado");
        }

    }

    private void exibeVeiculos() {
        String[] listaVeiculos = cadVeiculo.listaVeiculos();
        int tamanho = listaVeiculos.length;
        for (int i = 0; i < tamanho; i+=3) {
            System.out.println("===================");
            System.out.println("Placa: " + listaVeiculos[i]);
            System.out.println("Marca: " + listaVeiculos[i+1]);
            System.out.println("Modelo: " + listaVeiculos[i+2]); 
        }
        System.out.println("===================");
    }

    private void alteraQuilometragem() {
        String placa = pedePlaca();

        if (cadVeiculo.procurarVeiculo(placa)) {
            double quilometragemAntiga = cadVeiculo.retornarVeiculo(placa).getQuilometragemAtual();
            System.out.println("Digite a nova quilometragem: ");
            double novaQuilometragem = teclado.nextDouble();
            cadVeiculo.alteraQuilometragemAtual(placa, novaQuilometragem);
            System.out.println("Quilometragem atual alterada de " + quilometragemAntiga + " para " + novaQuilometragem);
        } else {
            System.out.println("Nao foi possivel alterar a quilometragem do veiculo");
        }
        
    }


    private String pedePlaca(){
        System.out.println("Digite a placa do veiculo que procura:");
        String placa = teclado.next();
        return placa;
    }
}


