package controller;

import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.Produto;
import model.Venda;
import view.TelaCadastroProduto;

public class ControllerProduto {
	
	
	private TelaCadastroProduto telaCadastroProduto;
	private MouseListener mouseListener;

	public ControllerProduto() {
		telaCadastroProduto = new TelaCadastroProduto(this);		
	}

	public boolean enviarNotaFiscalPorEmail(String a, String v) {
		String assunto = "VendaJava: " + a;  //Data
		String mensagem = "Valor: " + v;  // Total

		//TODO Coloque seu e-mail@academico.ifpb.edu.br e senha aqui para testar
		String email = "rocha.tiago@academico.ifpb.edu.br";
		String senha = "1234";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(email, senha);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@vendajava.pp.ads"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject(assunto);
			message.setText(mensagem);

			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			return false;
		}
	}

	public boolean salvarProduto(String nomeProduto, int valorProduto) {
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setPreco(valorProduto);

		int quantidade = 1;
		
		Venda venda = new Venda();
		venda.setData(Calendar.getInstance().getTime());					
		venda.addItemVenda(produto, quantidade);

		
		return enviarNotaFiscalPorEmail(venda.getData().toString(), String.valueOf(venda.getTotal()));		
	}

	public void iniciar() {
		telaCadastroProduto.exibir();
		
	}

		
	}

	/* 
	 * TODO 04
	 * 
	 * 1. Implemente os metodos que este controlador deve intermediar
	 * pelos eventos do usuario na classe TelaCadastroProduto (view), 
	 * acionando funcionalidades na classe Produto (model) e, eventualmente,
	 * exibindo resultado desses acionamentos de volta na view. 
	 * 
	 * 2. Para detectar melhor o que este controler deve prover como métodos, 
	 * veja os listeners dispostos na classe TelaCadastroProduto que estão se 
	 * acoplando diretamente com objetos da camada model.
	 *  
	 * 3. Verifique se este controlador pode manter referencias
	 * (como atributos desta classe) para objetos view e /ou model envolvidos.
	 * Se puder, declare-os e utilize-os nas implementacoes dos metodos deste
	 * controlador.
	 * 
	 * */

