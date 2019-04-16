
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
	
	public void ingressoPronto() {
		System.out.println("~~~~INGRESSO~~~~");
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Horario: " + this.sessao.getHora());
		System.out.println("Numero da cadeira: " + this.numCadeira);
	}

}
