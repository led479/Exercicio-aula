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
    
    public ArrayList<String> eventosPositivos() {
        ArrayList<String> eventosPositivos = new ArrayList<>();
        for (Evento evento : eventos) { 
            if (evento instanceof EventoPositivo) {
                eventosPositivos.add("==================");
                eventosPositivos.add("Descricao: " + evento.getDescricao());
                eventosPositivos.add("Matricula: " + evento.getMatricula());
                eventosPositivos.add("Placa: " + evento.getVeiculo().getPlaca());
                eventosPositivos.add("Modelo: " + evento.getVeiculo().getModelo());
                eventosPositivos.add("Marca: " + evento.getVeiculo().getMarca());
            }
        }
        eventosPositivos.add("==================");
        return eventosPositivos;
    }
    
    public ArrayList<String> eventosVeiculos() {
        ArrayList<String> eventosVeiculos = new ArrayList<>();
        for (Evento evento : eventos) { 
            if (evento instanceof EventoVeiculo) {
                eventosVeiculos.add("==================");
                eventosVeiculos.add("Descricao: " + evento.getDescricao());
                eventosVeiculos.add("Matricula: " + evento.getMatricula());
            }
        }
        eventosVeiculos.add("==================");
        return eventosVeiculos;
    }
    
    public ArrayList<String> eventosMatriculas() {
        ArrayList<String> eventosMatriculas = new ArrayList<>();
        for (Evento evento : eventos) { 
            if (evento instanceof EventoMatricula) {
                eventosMatriculas.add("==================");
                eventosMatriculas.add("Descricao: " + evento.getDescricao());
            }
            
        }
        eventosMatriculas.add("==================");
        return eventosMatriculas;
    }
    
    public ArrayList<String> eventosDisponiveis() {
        ArrayList<String> eventosDisponiveis = new ArrayList<>();
        for (Evento evento : eventos) { 
            if (evento instanceof EventoDisponivel) {
                eventosDisponiveis.add("==================");
                eventosDisponiveis.add("Descricao: " + evento.getDescricao());
                eventosDisponiveis.add("Matricula: " + evento.getMatricula());
                eventosDisponiveis.add("Placa: " + evento.getVeiculo().getPlaca());
                eventosDisponiveis.add("Modelo: " + evento.getVeiculo().getModelo());
                eventosDisponiveis.add("Marca: " + evento.getVeiculo().getMarca());
            }
        }
        eventosDisponiveis.add("==================");
        return eventosDisponiveis;
    }
    
    public ArrayList<String> eventosPelaMatricula(int matricula) {
        ArrayList<String> eventosPelaMatricula = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getMatricula() == 0) {
            } else {
                if (evento.getMatricula() == matricula) {
                    eventosPelaMatricula.add("==============================");
                    eventosPelaMatricula.add("Matricula: " + evento.getMatricula());
                    if (evento.getVeiculo() == null) {
                    } else {
                        eventosPelaMatricula.add("Placa: " + evento.getVeiculo().getPlaca());
                        eventosPelaMatricula.add("Marca: " + evento.getVeiculo().getMarca());
                        eventosPelaMatricula.add("Modelo: " + evento.getVeiculo().getModelo());
                    }
                    eventosPelaMatricula.add("Descricao: " + evento.getDescricao());
                }
            }
        }
        eventosPelaMatricula.add("==================");
        return eventosPelaMatricula;
    }
    

    
        public ArrayList<String> eventosPelaPlaca(String placa) {
        ArrayList<String> eventosPelaPlaca = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getVeiculo() == null) {
            } else {
                if (evento.getVeiculo().getPlaca().equals(placa)) {
                    eventosPelaPlaca.add("==============================");
                    if (!(evento instanceof EventoMatricula)) {
                        eventosPelaPlaca.add("Matricula: " + evento.getMatricula());
                    }
                    eventosPelaPlaca.add("Placa: " + evento.getVeiculo().getPlaca());
                    eventosPelaPlaca.add("Marca: " + evento.getVeiculo().getMarca());
                    eventosPelaPlaca.add("Modelo: " + evento.getVeiculo().getModelo());
                    eventosPelaPlaca.add("Descricao: " + evento.getDescricao());
                }
            }
        }
        eventosPelaPlaca.add("==============================");
        return eventosPelaPlaca;
    }
    
    public ArrayList<String> listaEventos() {
        ArrayList<String> listaEventos = new ArrayList<>();
        for (Evento evento : eventos) {
            listaEventos.add("==============================");
            if (evento.getMatricula() == 0) {
            } else {
                listaEventos.add("Matricula: " + evento.getMatricula());
            }
            if (evento.getVeiculo() == null) {
            } else {
                listaEventos.add("Placa: " + evento.getVeiculo().getPlaca());
                listaEventos.add("Marca: " + evento.getVeiculo().getMarca());
                listaEventos.add("Modelo: " + evento.getVeiculo().getModelo());
            }

            listaEventos.add("Descricao: " + evento.getDescricao());
        }
        listaEventos.add("==============================");
        return listaEventos;
    }
    
    
}
