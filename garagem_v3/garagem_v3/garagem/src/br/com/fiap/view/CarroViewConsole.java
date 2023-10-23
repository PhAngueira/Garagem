package br.com.fiap.view;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import br.com.fiap.controller.CarroController;

public class CarroViewConsole {

	public static void main(String[] args) {
		String aux, escolha = "sim", placa, cor, descricao;
		int opcao;
		CarroController carro = new CarroController();
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Escolha:" 
						+ "\n(1) Insere\n(2) Altera\n(3) Exclui\n(4) Lista");
				opcao = Integer.parseInt(aux);
				placa = JOptionPane.showInputDialog("Placa do Carro:");
				switch (opcao) {
				case 1:
					cor = JOptionPane.showInputDialog("Cor do Carro:");
					descricao = JOptionPane.showInputDialog("Descricao do Carro:");
					System.out.println(carro.insereCarro(placa, cor, descricao));
					break;
				case 2:
					cor = JOptionPane.showInputDialog("Nova cor do Carro:");
					descricao = JOptionPane.showInputDialog("Nova descricao do Carro:");
					System.out.println(carro.alteraCarro(placa, cor, descricao));
					break;
				case 3:
					System.out.println(carro.excluiCarro(placa));
					break;
				case 4:
					ArrayList<String> consulta = carro.listaUmCarro(placa);
					if (consulta != null) {
						JOptionPane.showMessageDialog(null, "Dados do Carro:\n\n"
								+ "Placa: " + consulta.get(0) + "\n"
								+ "Cor: " + consulta.get(1) + "\n"
								+ "Descricao: " + consulta.get(2) + "\n");
					} else {
						JOptionPane.showMessageDialog(null, "Placa inexistente");
					}					
					break;
				default:
					System.out.println("Escolha incorreta!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
		JOptionPane.showMessageDialog(null, "Fim de Programa!");
	}
}

