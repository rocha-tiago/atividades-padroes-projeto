package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Venda {

	private Date data;

	private List<ItemVenda> itensVenda = new ArrayList<>();

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	/*
	 * TODO 01
	 * 1. Este metodo presume a guarda de todos ItemVenda, mas assume
	 * que os objetos itens sao criados fora, por quem eh cliente desta
	 * classe Venda. Esta classe teria o poder de criar esses itens em si?
	 * 
	 * 2. Para avaliar isso, veja se ela eh especialista na informacao
	 * para inicializar esses itens logo que criados/instanciados e/ou
	 * se esta classe os aglutinam/ajuntas dentro de si.
	 * 
	 * 3. Anote qual o principio GRASP que você considerou, caso tenha refatorado
	 * este codigo e explique como sua solucao trouxe beneficios ao design.
	 * 
	 * R. Creator
	 */
	
	public void addItemVenda(Produto produto, int quantidade) {		
		itensVenda.add(new ItemVenda(produto,quantidade));		
	}

	public float getTotal() {
		float total = 0;
		for (ItemVenda itemVenda : this.itensVenda) {
			total += itemVenda.getSubtotal();
		}
		return total;
	}

	/*
	 * TODO 02
	 * 1. Esta classe eh a especialista no conjunto de informacoes para
	 * estar dispondo deste metodo? 
	 * 
	 * 2. Para avaliar isso, veja quem seria a classe mais especializada e refatore
	 * este codigo, caso quem venha a ofertar este metodo seja outra classe.
	 * Verifique tambem o grau de acoplamento desta classe com o codigo atual
	 * e depois, caso o tenha refatorado (quantidade de dependencia com
	 * outras classes de objetos). 
	 * 
	 * 3. Anote qual o principio GRASP que você considerou, caso tenha refatorado
	 * este codigo e explique como sua solucao trouxe beneficios ao design.
	 * Na verdade seriam 2 principios aqui, ok?...
	 * 
	 * R. Especialista, Baixo acoplamento
	 * 
	 * Metodo movido para ItemVenda (getSubTotal())
	 */


	/**
	 * TODO 03
	 * 1. Este metodo afeta a coesao desta classe Venda? Devemos deixa-lo aqui?
	 * Num primeiro momento, podemos ate pensar que esta classe e a especialista
	 * na informacao para estar implementando envio de email da nota fiscal, mas 
	 * sera que tudo que se derivar dos dados aqui contidos for programado
	 * aqui, não incorreremos num inchamento desta classe? Sera que todas as 
	 * classes clientes desta classe Venda lhe pedirao para enviar nota fiscal?
	 * 
	 * 2. Para avaliar isso, considere se este metodo se encaixa no proposito/objetivo
	 * de coesao funcional desta classe Venda, que eh o de apenas representar os dados a
	 * serem abstraidos de uma compra (do modelo de negocios que se esta informatizando)
	 * na memoria e somente.
	 * 
	 * 3. Anote qual o principio GRASP que você considerou, caso tenha refatorado
	 * este codigo e explique como sua solucao trouxe beneficios ao design.
	 * 
	 *  
	 */
	public boolean enviarNotaFiscalPorEmail() {
		String assunto = "VendaJava: " + this.getData();
		String mensagem = "Valor: " + this.getTotal();

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
}


