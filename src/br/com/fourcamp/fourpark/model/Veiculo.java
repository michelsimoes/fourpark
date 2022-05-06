package br.com.fourcamp.fourpark.model;

public class Veiculo {
	private String placa;
	private String modelo;
	private String marca;
	private String proprietario;
	
	
	
	public Veiculo() {
	
	}
	
	
	public Veiculo(String placa, String modelo, String marca, String proprietario) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.proprietario = proprietario;
	}


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
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	

}
