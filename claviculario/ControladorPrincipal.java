package br.ufsc.ine5605.claviculario;

import br.ufsc.ine5605.claviculario.CadastroFuncionarios.CadastroFuncionario;
import br.ufsc.ine5605.claviculario.CadastroVeiculos.CadastroVeiculo;
import br.ufsc.ine5605.claviculario.ControladorEmprestimo.ControladorEmprestimo;
import br.ufsc.ine5605.claviculario.ControladorEventos.ControladorEvento;
import br.ufsc.ine5605.claviculario.Telas.TelaInicial;

public class ControladorPrincipal {
	
    private final CadastroFuncionario cadFuncionario;
    private final CadastroVeiculo cadVeiculo;
    private final ControladorEmprestimo ctrlEmp;
    private final ControladorEvento ctrlEvento;
    private final TelaInicial telaInicial;
        

    
    public ControladorPrincipal() {
        cadFuncionario = new CadastroFuncionario(this);
        cadVeiculo = new CadastroVeiculo(this);
        ctrlEmp = new ControladorEmprestimo(this);
        ctrlEvento = new ControladorEvento(this);
        telaInicial = new TelaInicial(this);
    }
	


    public CadastroFuncionario getCadFuncionario() {
        return cadFuncionario;
    }

    public CadastroVeiculo getCadVeiculo() {
        return cadVeiculo;
    }
    
    public ControladorEvento getCtrlEvento() {
        return ctrlEvento;
    }
    
    
    public void inicia() {
        telaInicial.exibirTela();
    }
    
    public void telaVeiculo() {
        cadVeiculo.getTelaVeiculo().exibirTela();
    }
    
    public void telaFuncionario() {
        cadFuncionario.getTelaFuncionario().exibirTela();
    }


    public void telaControladorEmprestimo() {
        ctrlEmp.getTelaControladorEmprestimo().exibirTela();
    }

    public void telaEvento() {
        ctrlEvento.getTelaEvento().exibirTela();
    }



}
