package main;

public class Aplicacao {

	public static void main(String[] args) {
		Aplicacao.usandoClasseJaEsperadaPelaClassePreexistente(); 
		Aplicacao.usandoClasseIncompativelComAdaptadorNaClassePreexistente();
	}

	public static void usandoClasseJaEsperadaPelaClassePreexistente() {
		/* 
		 * TODO ADAPTER.01 
		 * 
		 * 1. crie um objeto da classe RotaTransporte.
		 * 2. crie um objeto da classe Carga e adicione-o no objeto RotaTransporte.
		 * 3. calcule o ICMS, via metodo do objeto RotaTransporte.
		 * 4. mostre todas as cargas, via metodo do objeto RotaTransporte.
		 * 
		 * --------------------
		 * PERGUNTAS
		 * --------------------
		 * 
		 * A. O metodo abaixo corresponderia a um "codigo cliente" o qual ja combinava RotaTransporte com 
		 * Carga (ja estaria em uso), antes de aplicarmos o padrao?
		 * [RESPOSTA AQUI...]
		 */
	}

	public static void usandoClasseIncompativelComAdaptadorNaClassePreexistente() {
		/* TODO ADAPTER.02
		 * 		 
		 * 1. crie um objeto da classe RotaTransporte.
		 * 2. crie um objeto da classe Pedido com 2 objetos da classe ItemCompra, cada um para um Produto diferente.
		 * 3. adicione o objeto pedido no objeto RotaTransporte como se fosse um objeto Carga. 
		 * nao altere nenhuma linha de codigo das classes ja existentes.
		 * 4. calcule o ICMS, via metodo do objeto RotaTransporte.  
		 * 5. mostre todas as cargas, via metodo do objeto RotaTransporte.
		 * 
		 * --------------------
		 * PERGUNTAS
		 * --------------------
		 * 
		 * B. Quem seria a classe de objetos PREEXISTENTE?
		 * [RESPOSTA AQUI...]
		 * 
		 * C. Quem seria(m) a(s) classe(s) de objeto(s) ADAPTADA(S)? 
		 * [RESPOSTA AQUI...] 
		 * 
		 * D. Foi aplicado CLASS ADAPTER ou OBJECT ADAPTER? Por que ou quais as vantagens que a escolha
		 * realizada troxe?
		 * [RESPOSTA AQUI...] 
		 * 
		 * E. As classes PREEXISTENTE, a do TIPO IMPOSTO PELA PREEXISTENTE e a ADAPTADA(S) 
		 * foram modificadas na adaptação? Argumente.
		 * [RESPOSTA AQUI...] 
		 * 
		 * F. Este metodo implementa um codigo cliente que usa solucao disponibilizada pelo
		 * padrao Adapter. O metodo do TODO_ADAPTER.01 possui um codigo cliente sem adaptacao.
		 * Esse codigo cliente sem adaptacao teve que ser alterado devido 
		 * a aplicacao e uso do padrao adapter aqui em TODO_ADAPTER.02? 
		 * Explique o que isso siginifica, em termos de impactos a aplicarmos o padrao Adapter?
		 * [RESPOSTA AQUI...] 
		 * 
		 * G. Considerando os parametros de avaliacao da qualidade de um design OO 
		 * (ex.: coesão, acoplamento, reusabilidade, extensibilidade, flexibilidade a mudancas) e apos
		 * ter realizado esta pratica, indique quais desses parametros foram mais beneficiados com a
		 * aplicacao do padrao, segundo o que a equipe pode perceber. 
		 * [RESPOSTA AQUI...] 
		 */
	}

}
