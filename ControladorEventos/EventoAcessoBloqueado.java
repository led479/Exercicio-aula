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
public class EventoAcessoBloqueado extends EventoNegativo {


    public EventoAcessoBloqueado(int matricula) {
        super(matricula, null, "Funcionario nao conseguiu acesso ao veiculo 3 vezes e foi bloqueado o acesso aos veiculos");
    }
}
