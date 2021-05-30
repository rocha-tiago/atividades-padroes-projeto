package controller;

import java.util.Calendar;
import model.Mensageiro;
import model.Produto;
import model.Venda;

public class ControllerProduto {

	public ControllerProduto() {

	}

	public boolean salvarProduto(String nomeProduto, int valorProduto) {
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setPreco(valorProduto);

		int quantidade = 1;

		Venda venda = new Venda();
		venda.setData(Calendar.getInstance().getTime());
		venda.addItemVenda(produto, quantidade);		
		
		return Mensageiro.enviarNotaFiscalPorEmail(venda);
	}

}

/*
 * TODO 04
 * 
 * 1. Implemente os metodos que este controlador deve intermediar pelos eventos
 * do usuario na classe TelaCadastroProduto (view), acionando funcionalidades na
 * classe Produto (model) e, eventualmente, exibindo resultado desses
 * acionamentos de volta na view.
 * 
 * 2. Para detectar melhor o que este controler deve prover como métodos, veja
 * os listeners dispostos na classe TelaCadastroProduto que estão se acoplando
 * diretamente com objetos da camada model.
 * 
 * 3. Verifique se este controlador pode manter referencias (como atributos
 * desta classe) para objetos view e /ou model envolvidos. Se puder, declare-os
 * e utilize-os nas implementacoes dos metodos deste controlador.
 * 
 */
