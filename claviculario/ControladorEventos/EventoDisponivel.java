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
public class EventoDisponivel extends EventoNegativo {

    public EventoDisponivel(int matricula, Veiculo veiculo) {
        super(matricula, veiculo, "Funcionario nao conseguiu acesso ao veiculo pois veiculo nao esta disponivel");
    }
    
}
