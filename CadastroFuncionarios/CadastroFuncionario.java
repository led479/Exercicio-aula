package br.ufsc.ine5605.claviculario.CadastroFuncionarios;

import br.ufsc.ine5605.claviculario.ControladorPrincipal;
import br.ufsc.ine5605.claviculario.CadastroVeiculos.Veiculo;
import br.ufsc.ine5605.claviculario.Telas.TelaFuncionario;
import java.util.ArrayList;

public class CadastroFuncionario {
    private ArrayList<Funcionario> funcionarios;
    private final TelaFuncionario telaFuncionario;
    private final ControladorPrincipal ctrlPrincipal;
    
    
    public CadastroFuncionario(ControladorPrincipal ctrlPrincipal) {
        //super();
        funcionarios = new ArrayList<>();
        this.ctrlPrincipal = ctrlPrincipal;
        telaFuncionario = new TelaFuncionario(this);
    }

    public boolean procurarFuncionario(int numeroMatricula){
        for(Funcionario funcionario:funcionarios){
            if(funcionario.getNumeroMatricula() == numeroMatricula){
                return true;
            }
        }
        return false;
    }

    public Funcionario retornarFuncionario(int matricula){
        Funcionario f = null;
        for(Funcionario funcionario : funcionarios){
            if(funcionario != null && funcionario.getNumeroMatricula() == matricula){
                    f = funcionario;
            }
        }

        return f;
    }

    public boolean addFuncionario(int numeroMatricula, String nome, TipoFuncionario tipoFuncionario, String dataNascimento, int telefone, ArrayList<Veiculo> veiculos){
        if(procurarFuncionario(numeroMatricula) == false){
            funcionarios.add(new Funcionario(numeroMatricula, nome, tipoFuncionario, dataNascimento, telefone, veiculos));
            return true;
        }
        return false;
    }

    public boolean removeFuncionario(int numeroMatricula){
        if(procurarFuncionario(numeroMatricula)){
            for(Funcionario funcionario: funcionarios){
                if(funcionario.getNumeroMatricula()==numeroMatricula){
                    funcionarios.remove(funcionario);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean alteraFuncionario(int numeroMatricula, TipoFuncionario tipoFuncionario){
        Funcionario f = retornarFuncionario(numeroMatricula);
        if(f != null){
            f.setTipoFuncionario(tipoFuncionario);
        }


        return false;
    }

    public String[] listaFuncionarios(){
        String[] listaFuncionarios = new String[funcionarios.size()*3];

        for(Funcionario funcionario:funcionarios){
            int tamanhoListaFuncionarios = funcionarios.size();
            int j = 0;
            if(funcionario != null){
                for (int i = 0; i < tamanhoListaFuncionarios; i++) {
                    listaFuncionarios[j] = funcionarios.get(i).getNumeroMatricula()+ "";
                    listaFuncionarios[j+1] = funcionarios.get(i).getNome();	
                    listaFuncionarios[j+2] = funcionarios.get(i).getTipoFuncionario() + "";
                    j+=3;
                }
            }
        }

        return listaFuncionarios;
    }
    
    public String[] listaVeiculos() {
        return ctrlPrincipal.getCadVeiculo().listaVeiculos();
    }
    
    public Veiculo retornarVeiculo(String placa) {
        return ctrlPrincipal.getCadVeiculo().retornarVeiculo(placa);
    }
    
    public ArrayList<Funcionario> getListaFuncionario () {
        return funcionarios;
    }
    
    public TelaFuncionario getTelaFuncionario() {
        return this.telaFuncionario;
    }
    
    public boolean funcionarioPossueVeiculo (String placa) {
        for (Funcionario f : funcionarios) {
            if (f.procurarVeiculo(placa)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean removeVeiculoDosFuncionarios (String placa) {
        int controle = 0;
        for (Funcionario f : funcionarios) {
            if (f.procurarVeiculo(placa)) {
                f.removeVeiculo(placa);
                controle++;
            }
        }
        if (controle==0) {
            return false;
        } else {
            return true;
        }
    }
    
    
    
    

}
