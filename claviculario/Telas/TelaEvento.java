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
            System.out.println("0 - Encerrar Operecao");
            do {
                System.out.println("Qual opcao deseja: ");
                fazer = teclado.nextInt();
            } while(fazer < 0 || fazer > 1);

            switch(fazer){
                case 1: 
                    exibeEventos();
                    break;
                default:
                    System.out.println("Operacao encerrada");
            }
        }while(fazer != 0);

	
    }

    private void exibeEventos() {
        ArrayList<Evento> eventos = ctrlEvento.getEventos();
        for (Evento evento : eventos) {
            System.out.println("==============================");
            if (!(evento instanceof EventoMatricula)) {
                 System.out.println("Matricula: " + evento.getMatricula());
            }
            if (!(evento instanceof EventoVeiculo) && !(evento instanceof EventoMatricula) && !(evento instanceof EventoAcessoBloqueado)) {
                System.out.println("Placa: " + evento.getVeiculo().getPlaca());
                System.out.println("Marca: " + evento.getVeiculo().getMarca());
                System.out.println("Modelo: " + evento.getVeiculo().getModelo());
            }

            System.out.println("Descricao: " + evento.getDescricao());
        }
        System.out.println("==============================");
    }
}
