package regrasDeNegocio;
import java.util.ArrayList;

public class Sessao {
	private String filme;
	private int sala;
	private String hora;
	private int quantidadeCadeiras;
	private ArrayList<Cadeira> cadeiras;
	private double valorIngresso;
	
	
	
	public Sessao(String hora, int quantidadeCadeiras, String filme, int sala) {
		this.filme = filme;
		this.sala = sala;
		this.hora = hora;
		this.quantidadeCadeiras = quantidadeCadeiras;
		cadeiras = cadeiraGenerator(quantidadeCadeiras);
	}
	
	
	
	
	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public int getQuantidadeCadeiras() {
		return quantidadeCadeiras;
	}



	public void setQuantidadeCadeiras(int quantidadeCadeiras) {
		this.quantidadeCadeiras = quantidadeCadeiras;
	}



	public ArrayList<Cadeira> getCadeiras() {
		return cadeiras;
	}



	public void setCadeiras(ArrayList<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}
	
	



	public String getFilme() {
		return filme;
	}




	public void setFilme(String filme) {
		this.filme = filme;
	}




	public int getSala() {
		return sala;
	}




	public void setSala(int sala) {
		this.sala = sala;
	}




	public double getValorIngresso() {
		return valorIngresso;
	}




	public void setValorIngresso(double valorIngresso) {
		this.valorIngresso = valorIngresso;
	}




	public ArrayList<Cadeira> cadeiraGenerator(int quantidade) {
		ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
		for(int i = 0; i < quantidade; i++) {
			cadeiras.add(new Cadeira());
		}
		return cadeiras;
	}
	
	public ArrayList<Integer> cadeirasVagas(){
		ArrayList<Integer> cadeirasVagas = new ArrayList<Integer>();
		for(int i = 0; i < this.quantidadeCadeiras; i++) {
			if(this.cadeiras.get(i).isDesocupada()) {
				cadeirasVagas.add(i);
			}
		}
		return cadeirasVagas;
	}

}
