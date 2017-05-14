/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.claviculario.Telas;

import br.ufsc.ine5605.claviculario.ControladorEventos.ControladorEvento;
import br.ufsc.ine5605.claviculario.ControladorEventos.Evento;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoAcessoBloqueado;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoMatricula;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoVeiculo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class TelaEvento {
    private final ControladorEvento ctrlEvento;
    private final Scanner teclado;
    
    public TelaEvento (ControladorEvento ctrlEvento) {
        this.ctrlEvento = ctrlEvento;
        teclado = new Scanner(System.in);
    }
    
    public void exibirTela() {
        int fazer = 0;

        do {
            System.out.println("\n===========Tela de Eventos============");
            System.out.println("1 - Exibir lista de Eventos");
            System.out.println("2 - Exibir lista de Eventos positivos");
            System.out.println("3 - Exibir lista de Eventos nos quais a matricula foi digitada errada");
            System.out.println("4 - Exibir lista de Eventos nos quais o funcionario nao possue acesso ao veiculo");
            System.out.println("5 - Exibir lista de Eventos nos quais o veiculo estava indisponivel");
            System.out.println("6 - Filtrar lista de Eventos pela matricula do funcionario");
            System.out.println("7 - Filtrar lsita de Eventos pela placa do veiculo");
            System.out.println("0 - Encerrar Operecao");
            do {
                System.out.println("Qual opcao deseja: ");
                fazer = teclado.nextInt();
            } while(fazer < 0 || fazer > 7);

            switch(fazer){
                case 1: 
                    exibeEventos();
                    break;
                case 2:
                    exibeEventosPositivos();
                    break;
                case 3:
                    exibeEventosMatriculas();
                    break;
                case 4:
                    exibeEventosVeiculos();
                    break;
                case 5:
                    exibeEventosDisponiveis();
                    break;
                case 6:
                    exibeEventosPelaMatricula();
                    break;
                case 7:
                    exibeEventosPelaPlaca();
                    break;
                default:
                    System.out.println("Operacao encerrada");
            }
        }while(fazer != 0);

	
    }

    
    private void exibeEventos() {
        ArrayList<String> listaEventos = ctrlEvento.listaEventos();
        for (String s : listaEventos) {
            System.out.println(s);
        }
    }

    private void exibeEventosPositivos() {
        ArrayList<String> eventosPositivos = ctrlEvento.eventosPositivos();
        for (String s : eventosPositivos) {
            System.out.println(s);
        }    
    }

    private void exibeEventosMatriculas() {
        ArrayList<String> eventosMatriculas = ctrlEvento.eventosMatriculas();
        for (String s : eventosMatriculas) {
            System.out.println(s);
        }    
    }

    private void exibeEventosVeiculos() {
        ArrayList<String> eventosVeiculos = ctrlEvento.eventosVeiculos();
        for (String s : eventosVeiculos) {
            System.out.println(s);
        }    
    }

    private void exibeEventosDisponiveis() {
        ArrayList<String> eventosDisponiveis = ctrlEvento.eventosDisponiveis();
        for (String s : eventosDisponiveis) {
            System.out.println(s);
        }    
    }

    private void exibeEventosPelaMatricula() {
        ArrayList<String> eventosPelaMatricula = ctrlEvento.eventosPelaMatricula(pedeMatricula());
        for (String s : eventosPelaMatricula) {
            System.out.println(s);
        }    
    }

    private void exibeEventosPelaPlaca() {
        ArrayList<String> eventosPelaPlaca = ctrlEvento.eventosPelaPlaca(pedePlaca());
        for (String s : eventosPelaPlaca) {
            System.out.println(s);
        }    
    }

    private int pedeMatricula(){
        System.out.println("Digite a matricula do funcionario: ");
        int matricula = teclado.nextInt();
        return matricula;
    }

    private String pedePlaca(){
        System.out.println("Digite a placa do veiculo: ");
        String placa = teclado.next();
        return placa;
    }
    
    
    
}
