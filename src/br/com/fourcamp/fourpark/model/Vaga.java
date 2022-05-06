package br.com.fourcamp.fourpark.model;

import java.util.HashMap;

public class Vaga {
		
	private Integer posicao;
	private String horaEntrada;
	private String horaSaida;
	private Veiculo veiculo;
	private Boolean ocupado;

	public Vaga() {
		ocupado = false;
	}

	public Vaga(Integer posicao) {
		this.posicao = posicao;
		ocupado = false;
	}
	
	
	public Vaga(Integer posicao, String horaEntrada, Veiculo veiculo) {
		super();
		this.posicao = posicao;
		this.horaEntrada = horaEntrada;
		this.veiculo = veiculo;
		ocupado = true;
	}


	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}
	public Boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String listarVagasOcupadas(HashMap<Integer, Vaga> vagas) {
		String retorno = "vagas  ocupadas \n";
		for(int x = 1; x <= vagas.size(); x++) {
			Vaga vaga = vagas.get(x);
			if(vaga.getOcupado()) {
				retorno += "\nVaga: "+vaga.getPosicao()+", veiculo placa: "+ vaga.getVeiculo().getPlaca() + ", proprietario :" + vaga.getVeiculo().getProprietario();
				
			} 
			
			
		}
		return retorno;
	}
	public String listarVagasDisponiveis(HashMap<Integer, Vaga> vagas) {
		String retorno = "";
		for(int x = 1; x <= vagas.size(); x++) {
			if(!vagas.get(x).getOcupado()) {
			retorno = retorno +	" vaga "+ x + " disponivel!	\n";				
			} 
		}
		return retorno;
		
	}
	
	public String popularVaga(HashMap<Integer, Vaga> vagas) {
		vagas.put(posicao, this);
		String retorno =  "======================="
						+ "\n Carro inserido na vaga com sucesso!"
						+ "\n=======================";
		
		return retorno;
		
	}
	

	public boolean validarVaga( HashMap<Integer, Vaga> vagas) {
		if(posicao < 1 || posicao > 50) {
			return  false;
			
		} else {
			return verificarVagaOcupada(vagas);
		}
		
	}

	

	public boolean verificarVagaOcupada( HashMap<Integer, Vaga> vagas) {
		Vaga vaga = vagas.get(posicao);
		return !vaga.getOcupado();
	}

	public String desocuparPorVaga(HashMap<Integer, Vaga> vagas, Integer opcao) {
		if(vagas.get(opcao).getOcupado()) {
			vagas.put(opcao, new Vaga());
			return "Vaga desocupada com sucesso";
		} else {
			return "A vaga ja estava livre";
		}
		
	}

	public Boolean desocuparPorPlaca(HashMap<Integer, Vaga> vagas, String placa) {
		Boolean retorno = false;
		for(int x=1; x<= vagas.size(); x++) {
			
			Vaga vaga = vagas.get(x);
			Veiculo veiculo = vaga.getVeiculo();
			if(veiculo != null) {
				if(veiculo.getPlaca().equals(placa)) {
					vagas.put(x, new Vaga());
					retorno = true;
				}
			}
			
		}
		return retorno;
		
	}

}
