package br.ufsc.ine5605.claviculario.CadastroFuncionarios;

import br.ufsc.ine5605.claviculario.CadastroVeiculos.Veiculo;
import java.util.ArrayList;

public class Funcionario {
	private int numeroMatricula;
	private String nome;
	private TipoFuncionario tipoFuncionario;
	private String dataNascimento;
	private int telefone;
        private int tentativasFalhas;
        private ArrayList<Veiculo> veiculosDisponiveis;
	
        public Funcionario(int numeroMatricula, String nome, TipoFuncionario tipoFuncionario, String dataNascimento, int telefone, ArrayList<Veiculo> veiculosDisponiveis) {
            super();
            this.numeroMatricula = numeroMatricula;
            this.nome = nome;
            this.tipoFuncionario = tipoFuncionario;
            this.dataNascimento = dataNascimento;
            this.telefone = telefone;
            this.veiculosDisponiveis = veiculosDisponiveis;
            tentativasFalhas = 0;
	}
        
	public int getNumeroMatricula() {
            return numeroMatricula;
	}
	public void setNumeroMatricula(int numeroMatricula) {
            this.numeroMatricula = numeroMatricula;
	}
	public String getNome() {
            return nome;
	}
	public void setNome(String nome) {
            this.nome = nome;
	}
	public TipoFuncionario getTipoFuncionario() {
            return tipoFuncionario;
	}
	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
            this.tipoFuncionario = tipoFuncionario;
	}
	public String getDataNascimento() {
            return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
	}
	public int getTelefone() {
            return telefone;
	}
	public void setTelefone(int telefone) {
            this.telefone = telefone;
	}
        public int getTentativasFalhas() {
            return tentativasFalhas;
        }
        public void incementaTentativas() {
            tentativasFalhas++;
        }
        
        public void addVeiculo(String placa,String modelo,String marca,int ano,double quilometragem) {
            if (!procurarVeiculo(placa)) {
                veiculosDisponiveis.add(new Veiculo(placa, modelo, marca, ano, quilometragem));
            }
        }
        
        public void addVeiculo2 (Veiculo veiculo) {
            if (!procurarVeiculo(veiculo.getPlaca())) {
                veiculosDisponiveis.add(veiculo);
            }
        }
        
        public boolean procurarVeiculo(String placa) {
            for(Veiculo veiculo: veiculosDisponiveis){
                if(veiculo.getPlaca().equals(placa)){
                    return true;
                }
            }
            return false;
        }
        
        public Veiculo retornarVeiculo(String placa) {
            for (Veiculo v : veiculosDisponiveis) {
                if (v.getPlaca().equals(placa)) {
                    return v;
                }
            }
            return null;
        }
        
        public boolean removeVeiculo (String placa) {
            if(procurarVeiculo(placa)) {
                veiculosDisponiveis.remove(retornarVeiculo(placa));
                return true;
            }
            return false;
        }
        
        
        public String[] listaVeiculos() { //TRATAMENTO DE EXCESSAO AKI
        int tamanhoListaVeiculos = veiculosDisponiveis.size();
        //if (tamanhoListaVeiculos > 0)
        String[] listaVeiculos = new String[tamanhoListaVeiculos*3];
        int j = 0; //indice do array listaVeiculos
        for (int i = 0; i < tamanhoListaVeiculos; i++) {
            listaVeiculos[j] = veiculosDisponiveis.get(i).getPlaca();
            listaVeiculos[j+1] = veiculosDisponiveis.get(i).getMarca();
            listaVeiculos[j+2] = veiculosDisponiveis.get(i).getModelo();
            j += 3;
        }
        return listaVeiculos;
        }
	
	
	
	
}
