/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.claviculario.ControladorEventos;

import br.ufsc.ine5605.claviculario.Telas.TelaEvento;
import br.ufsc.ine5605.claviculario.ControladorPrincipal;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ControladorEvento {
    private ArrayList<Evento> eventos;
    private final ControladorPrincipal ctrlPrincipal;
    private final TelaEvento telaEvento;
    
    public ControladorEvento (ControladorPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        eventos = new ArrayList<>();
        telaEvento = new TelaEvento(this);
    }
    
    public void addEventoPositivo(EventoPositivo evento) {
        eventos.add(evento);
    }
    
    public void addEventoNegativo (EventoNegativo evento) {
        eventos.add(evento);
    }
    
    public TelaEvento getTelaEvento() {
        return telaEvento;
    }
    
    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    
    public ControladorPrincipal getControladorPrincipal() {
        return ctrlPrincipal;
    }
    
}
