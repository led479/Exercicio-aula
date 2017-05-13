/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.claviculario.ControladorEmprestimo;

import br.ufsc.ine5605.claviculario.CadastroFuncionarios.Funcionario;
import br.ufsc.ine5605.claviculario.CadastroFuncionarios.TipoFuncionario;
import br.ufsc.ine5605.claviculario.CadastroVeiculos.Veiculo;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoAcessoBloqueado;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoDisponivel;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoMatricula;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoPositivo;
import br.ufsc.ine5605.claviculario.ControladorEventos.EventoVeiculo;
import br.ufsc.ine5605.claviculario.ControladorPrincipal;
import br.ufsc.ine5605.claviculario.Telas.TelaControladorEmprestimo;

/**
 *
 * @author PC
 */
public class ControladorEmprestimo {
    
    private final ControladorPrincipal ctrlPrincipal;
    private final TelaControladorEmprestimo telaCtrlEmp;
    
    public ControladorEmprestimo (ControladorPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        telaCtrlEmp = new TelaControladorEmprestimo(this);
    }
    
    public void pedirMatricula(int matricula) {
        //conteudo
    }
    
    public void pedirPlaca (int placa) {
        //conteudo
    }
    
    public boolean verificarCarrosParaTipoFuncionario (Funcionario funcionario) {
        //conteudo
        
        return false;
    }
    
    
    public ControladorPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
    
    public boolean liberarChaveSePossuirMaisDeUmVeiculo (int matricula, int indicePlaca) {
        if (ctrlPrincipal.getCadFuncionario().procurarFuncionario(matricula)) {
            Funcionario f = ctrlPrincipal.getCadFuncionario().retornarFuncionario(matricula);
            if (f.getTentativasFalhas() < 3) {
                String[] listaVeiculosFuncionario = f.listaVeiculos();
                int tamanho = listaVeiculosFuncionario.length;
                int indice = converteIndice(indicePlaca);
                String placa = listaVeiculosFuncionario[indice];
                Veiculo v = ctrlPrincipal.getCadVeiculo().retornarVeiculo(placa);
                if (v == null) {
                    getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoVeiculo(matricula));
                    f.incementaTentativas();
                    if (f.getTentativasFalhas() == 3) {
                        getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoAcessoBloqueado(matricula));
                    }
                    return false;
                }
                if (v.isDisponibilidade()) {
                    getCtrlPrincipal().getCtrlEvento().addEventoPositivo(new EventoPositivo(matricula, v));
                    v.setDisponibilidade(false);
                    return true;
                } else {
                    getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoDisponivel(matricula, v));
                    return false;
                }
            }
        } else {
            getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoMatricula());
            return false;
        }
        return false;
    }
    
    
    
    public boolean liberarChaveSePossuirUmVeiculo(int matricula) {
        
        if (ctrlPrincipal.getCadFuncionario().procurarFuncionario(matricula)) {
            Funcionario f = ctrlPrincipal.getCadFuncionario().retornarFuncionario(matricula);
            if (f.getTentativasFalhas() < 3) {
                String[] listaVeiculosFuncionario = f.listaVeiculos();
                int tamanho = listaVeiculosFuncionario.length;
                String placa = listaVeiculosFuncionario[0];
                Veiculo v = ctrlPrincipal.getCadVeiculo().retornarVeiculo(placa);
                if (v == null) {
                    //evento.add(new EventoVeiculo (false, veiculo nao permitido)
                    f.incementaTentativas();
                    if (f.getTentativasFalhas() == 3) {
                        //evento.add(new EventoAcessoBloqueado (false, agora funcionario esta bloqueado)
                    }
                    return false;
                } else {
                    if (v.isDisponibilidade() && f.getTentativasFalhas()<3) {
                        getCtrlPrincipal().getCtrlEvento().addEventoPositivo(new EventoPositivo(matricula, v));
                        v.setDisponibilidade(false);
                        return true;
                    } else {
                        getCtrlPrincipal().getCtrlEvento().addEventoNegativo(new EventoDisponivel(matricula, v));
                        return false;
                    }
                }
            }
        } else {
            //evento.add(new EventoMatricula (false, matricula nao existe)
            return false;
        }
        return false;

    }
        
    public boolean devolverChave(int matricula, String placa, double quilometragem) {
    	Funcionario f = ctrlPrincipal.getCadFuncionario().retornarFuncionario(matricula);
    	Veiculo vei = ctrlPrincipal.getCadVeiculo().retornarVeiculo(placa);
    	String[] listaVeiculosFuncionarios = f.listaVeiculos();
    	for(int i = 0; i < listaVeiculosFuncionarios.length; i++){
            if(listaVeiculosFuncionarios[i] != null && listaVeiculosFuncionarios[i].equals(placa) && vei.isDisponibilidade() == false){
                vei.setDisponibilidade(true);
                vei.setQuilometragematual(quilometragem);
                return true;
            }
    	}
    	
    	return false;
    }
    
    public int converteIndice (int indice) {
        return (indice - 1) * 3;
    }
    
    public int converteIndice2 (int indice) {
        return (indice + 3) / 3;
    }
    
    public String[] listaVeiculosFuncionario (int matricula) { //TRATAMENTO DE EXCESSAO AKI
        
        if (ctrlPrincipal.getCadFuncionario().procurarFuncionario(matricula)) {
            return ctrlPrincipal.getCadFuncionario().retornarFuncionario(matricula).listaVeiculos();
        }
        
        return null;
           
        
    }
    
    public TelaControladorEmprestimo getTelaControladorEmprestimo() {
        return this.telaCtrlEmp;
    }
}
