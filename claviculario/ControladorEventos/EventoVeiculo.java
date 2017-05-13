/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.claviculario.ControladorEventos;

import br.ufsc.ine5605.claviculario.CadastroVeiculos.Veiculo;

/**
 *
 * @author PC
 */
public class EventoVeiculo extends EventoNegativo {

    public EventoVeiculo(int matricula) {
        super(matricula, null, "Funcionario nao conseguiu retirar o veiculo pois veiculo nao existe");
    }
    
}
