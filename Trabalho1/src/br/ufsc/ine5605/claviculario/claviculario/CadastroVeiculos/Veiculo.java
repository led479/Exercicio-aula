package br.ufsc.ine5605.claviculario.CadastroVeiculos;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private double quilometragematual;
    private boolean disponibilidade;

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public double getQuilometragemAtual() {
        return quilometragematual;
    }
    public void setQuilometragematual(double quilometragematual) {
        this.quilometragematual = quilometragematual;
    }
    public boolean isDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Veiculo(String placa, String modelo, String marca, int ano, double quilometragematual) {
        //super();
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.quilometragematual = quilometragematual;
        this.disponibilidade = true;
    }
    
	

	
}
