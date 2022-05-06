package br.com.fourcamp.fourpark;


import java.util.HashMap;
import java.util.Scanner;

import br.com.fourcamp.fourpark.model.Vaga;
import br.com.fourcamp.fourpark.model.Veiculo;

public class Principal {

	public static void main(String[] args) {
		
		HashMap<Integer, Vaga> vagas = new HashMap<>();
		
		for(int x=1; x<=50; x++) {
			
			Vaga vaga = new Vaga(x);
			vagas.put(x, vaga);
			
		}
		System.out.println("foram criadas " + vagas.size() +" vagas" );
		Integer opcao;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n\nInsira uma opçao:\n 1- vagas disponiveis\n 2- vagas ocupadas\n 3- Entrada de veiculo\n 4- desocupar vaga\n 5- sair");
			Vaga vagag =  new Vaga();
			opcao = sc.nextInt();
			
			if(opcao == 1) {
				String retorno = vagag.listarVagasDisponiveis(vagas);
				System.out.println(retorno);
				
			} else if(opcao == 2) {
				
				String retorno = vagag.listarVagasOcupadas(vagas);
				System.out.println(retorno);
			}
			else if(opcao == 3) {
				 String placa;
				 String modelo;
				 String marca;
				 String proprietario;

				 String horaentrada;
				 Integer posicaoVaga;
				 
				 System.out.println("Insira uma placa:");
				 placa = sc.next();
				
				 System.out.println("Insira o modelo do veículo:");
				 modelo = sc.next();
				
				 System.out.println("Insira a  marca do veículo:");
				 marca = sc.next();
				
				 System.out.println("Insira o nome do proprietario:");
				 proprietario = sc.next();
				 
				
				 System.out.print("Qual a hora de entrada:");
				 horaentrada = sc.next();
				 while(true) {
					 System.out.print("Selecione a vaga:");
					 
					 posicaoVaga = sc.nextInt();
					 
					 Veiculo veiculo = new Veiculo(placa, modelo, marca, proprietario);
					 vagag.setPosicao(posicaoVaga);
					 if(vagag.validarVaga( vagas)) {
						 Vaga vaga = new Vaga(posicaoVaga, horaentrada, veiculo);
						 	
						 
						String retorno = vaga.popularVaga(vagas);
						System.out.println(retorno);
						
						 break;
					 }
					 else {
						 System.out.println("nao possivel utilizar a vaga selecionada;");
					 }
			 	}
			}
			else if(opcao == 4) {
				vagag = new Vaga();
				while(true) {
					System.out.println("Insira uma opçao\n 1- selecionar por vaga\n 2- selecionar por placa\n 0- sair");
					opcao = sc.nextInt();
					if(opcao ==1) {
						System.out.println("Insira a vaga a desocupar");
						Integer vaga = sc.nextInt();
						System.out.println("Insira o horário de saida");
						String saida = sc.next();
						System.out.println(vagag.desocuparPorVaga(vagas, vaga));
						break;
					}else if(opcao == 2) {
						System.out.println("Insira a placa que está desocupando");
						String placa = sc.next();
						System.out.println("Insira o horário de saida");
						String saida = sc.next();
						if(vagag.desocuparPorPlaca(vagas, placa)) {
							System.out.println("Vaga desocupada.");
							break;
							
						} else {
							System.out.println("Placa não encontrada, tente novamente");
						}
					}else if(opcao == 0) {
						break;
					} else {
						System.out.println("Opção inválida, tente novamente");
						
					}
				}
				
			}
			else if(opcao == 5) {
				break;
			} else {
				System.out.println("Opção inválida, tente denovo!");
				
			}
			
			
		}
		sc.close();
		
	}

	
}
