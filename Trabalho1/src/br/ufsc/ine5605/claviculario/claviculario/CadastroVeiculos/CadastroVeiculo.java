package br.ufsc.ine5605.claviculario.CadastroVeiculos;

import br.ufsc.ine5605.claviculario.ControladorPrincipal;
import br.ufsc.ine5605.claviculario.Telas.TelaVeiculo;
import java.util.ArrayList;

public class CadastroVeiculo {
    private ArrayList<Veiculo> veiculos;
    private final ControladorPrincipal ctrlPrincipal;
    private final TelaVeiculo telaVeiculo;


    public CadastroVeiculo(ControladorPrincipal ctrlPrincipal){
        veiculos = new ArrayList<>();
        this.ctrlPrincipal = ctrlPrincipal;
        telaVeiculo = new TelaVeiculo(this);
    }
    
    /* cria uma copia da lista de veiculos contendo
    somente a placa, a marca e o modelo */
    public String[] listaVeiculos() { //TRATAMENTO DE EXCESSAO AKI
        int tamanhoListaVeiculos = veiculos.size();
        //if (tamanhoListaVeiculos > 0)
        String[] listaVeiculos = new String[tamanhoListaVeiculos*3];
        int j = 0; //indice do array listaVeiculos
        for (int i = 0; i < tamanhoListaVeiculos; i++) {
            listaVeiculos[j] = veiculos.get(i).getPlaca();
            listaVeiculos[j+1] = veiculos.get(i).getMarca();
            listaVeiculos[j+2] = veiculos.get(i).getModelo();
            j += 3;
        }
        return listaVeiculos;
    }
   
    public boolean procurarVeiculo(String placa){
        for(Veiculo veiculo: veiculos){
            if(veiculo.getPlaca().equals(placa)){
                    return true;
            }
        }
        return false;
    }

    public boolean addVeiculo(Veiculo veiculo){
        if(veiculo != null && procurarVeiculo(veiculo.getPlaca()) == false){
            veiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean removeVeiculo(Veiculo veiculo){
        if(veiculo != null && procurarVeiculo(veiculo.getPlaca()) == true){
            veiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    public Veiculo retornarVeiculo(String placa){
        Veiculo vei = null;
        for(Veiculo veiculo: veiculos){
            if(veiculo.getPlaca().equals(placa)){
                    vei = veiculo;
            }
        }
        return vei;
    }

    public void alteraQuilometragemAtual(String placa,double novaQuilometragem){
        Veiculo vei = retornarVeiculo(placa);
        if(vei != null){
            vei.setQuilometragematual(novaQuilometragem);
        }
    }





    //testes da aula
    public boolean addVeiculo2(String placa,String modelo,String marca,int ano,double quilometragem) {
        if (!procurarVeiculo(placa)) {
            veiculos.add(new Veiculo(placa, modelo, marca, ano, quilometragem));
            return true;
        }
        return false;
    }


    public boolean removeVeiculo2(String placa) {
        if (procurarVeiculo(placa)) {
            if (ctrlPrincipal.getCadFuncionario().funcionarioPossueVeiculo(placa)) {
                return false;
            } else {
                veiculos.remove(retornarVeiculo(placa));
                return true;
            }
        }
        
        return false;
    }
    
    public boolean alterarDisponibilidadeParaFalse (String placa) {
        if (procurarVeiculo(placa)) {
            retornarVeiculo(placa).setDisponibilidade(false);
            return true;
        }
        return false;
    }
    public boolean alterarDisponibilidadeParaTrue (String placa) {
        if (procurarVeiculo(placa)) {
            retornarVeiculo(placa).setDisponibilidade(true);
            return true;
        }
        return false;
    }
    
    public TelaVeiculo getTelaVeiculo() {
        return this.telaVeiculo;
    }
    
    


}
