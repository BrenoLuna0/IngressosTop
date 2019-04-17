package regrasDeNegocio;

public class Ingresso {
	private static int id;
	
	private int codigo;
	private Sessao sessao;
	private int numCadeira;
	
	public Ingresso(Sessao sessao, int numCadeira) {
		this.codigo = id++;
		this.sessao = sessao;
		this.numCadeira = numCadeira;
		
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}
	
	public int getNumCadeira() {
		return this.numCadeira;
	}
	
	public void setNumCadeira(int numCadeira) {
		this.numCadeira = numCadeira;
	}
	
	public String ingressoPronto() {
		String msg = "";
		msg = msg.concat("~~~~INGRESSO~~~~\n");
		msg = msg.concat("Codigo: " + this.codigo + "\n");
		msg = msg.concat("Horario: " + this.sessao.getHora() + "\n");
		msg = msg.concat("Numero da cadeira: " + this.numCadeira + "\n");
		
		return msg;

	}

}
