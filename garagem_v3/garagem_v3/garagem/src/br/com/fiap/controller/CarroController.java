package br.com.fiap.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.model.bean.Carro;
import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.dao.Conexao;

public class CarroController {
	
	public String insereCarro(String placa,String cor,String descricao)
		throws ClassNotFoundException, SQLException {
		String resultado;
		Connection con = Conexao.abrirConexao();
		CarroDAO carroDao = new CarroDAO(con);
		Carro carro = new Carro();
		carro.setPlaca(placa);
		carro.setCor(cor);
		carro.setDescricao(descricao);
		resultado = carroDao.inserir(carro);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String alteraCarro(String placa,String cor,String descricao)
			throws ClassNotFoundException, SQLException {
			String resultado;
			Connection con = Conexao.abrirConexao();
			CarroDAO carroDao = new CarroDAO(con);
			Carro carro = new Carro();
			carro.setPlaca(placa);
			carro.setCor(cor);
			carro.setDescricao(descricao);
			resultado = carroDao.alterar(carro);
			Conexao.fecharConexao(con);
			return resultado;
	}
	
	public String excluiCarro(String placa)
			throws ClassNotFoundException, SQLException {
			String resultado;
			Connection con = Conexao.abrirConexao();
			CarroDAO carroDao = new CarroDAO(con);
			Carro carro = new Carro();
			carro.setPlaca(placa);
			resultado = carroDao.excluir(carro);
			Conexao.fecharConexao(con);
			return resultado;
	}
	
	public ArrayList<String> listaUmCarro(String placa) 
			throws ClassNotFoundException, SQLException {
		ArrayList<String> resultado = new ArrayList<String>();
		Connection con = Conexao.abrirConexao();
		CarroDAO carroDao = new CarroDAO(con);
		resultado = carroDao.listaUm(placa);
		Conexao.fecharConexao(con);
		if (resultado != null) {
			return resultado;
		} else {
			return null;
		}
	}

}











