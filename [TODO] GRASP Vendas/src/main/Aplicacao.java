package main;

import controller.ControllerProduto;
import view.TelaCadastroProduto;

public class Aplicacao {

	public static void main(String[] args) {

		ControllerProduto controller = new ControllerProduto();

		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(controller);

	}

}
