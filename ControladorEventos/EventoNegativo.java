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
public abstract class EventoNegativo implements Evento{

    private final int matricula;
    private final Veiculo veiculo;
    private final String descricao;

    public EventoNegativo(int matricula, Veiculo veiculo, String descricao) {
        this.matricula = matricula;
        this.veiculo = veiculo;
        this.descricao = descricao;
    }


    @Override
    public int getMatricula() {
        return matricula;
    }

    @Override
    public Veiculo getVeiculo() {
        return veiculo;
    }
    
    @Override
    public String getDescricao() {
        return descricao;
    }
    
    
}

